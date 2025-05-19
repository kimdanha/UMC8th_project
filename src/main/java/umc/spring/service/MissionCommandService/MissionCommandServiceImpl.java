package umc.spring.service.MissionCommandService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.apiPayload.exception.handler.MemberHandler;
import umc.spring.apiPayload.exception.handler.MissionHandler;
import umc.spring.apiPayload.exception.handler.StoreHandler;
import umc.spring.converter.MemberMissionConverter;
import umc.spring.domain.Member;
import umc.spring.domain.Mission;
import umc.spring.domain.Store;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.dto.MissionRequestDTO;
import umc.spring.repository.MemberMissionRepository.MemberMissionRepository;
import umc.spring.repository.MemberRepository.MemberRepository;
import umc.spring.repository.MissionRepository.MissionRepository;
import umc.spring.repository.StoreRepository.StoreRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MissionCommandServiceImpl implements MissionCommandService{

    private final StoreRepository storeRepository;
    private final MissionRepository missionRepository;
    private final MemberRepository memberRepository;
    private final MemberMissionRepository memberMissionRepository;

    public Long addMissionToStore(Long storeId, MissionRequestDTO dto) {
        Store store = storeRepository.findById(storeId)
                .orElseThrow(() -> new StoreHandler(ErrorStatus.STORE_NOT_FOUND));

        Mission mission = Mission.builder()
                .missionSpec(dto.getMissionSpec())
                .reward(dto.getReward())
                .store(store)
                .build();

        return missionRepository.save(mission).getId();
    }

    public Mission challengeMission(Long missionId, Long memberId) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new MemberHandler(ErrorStatus.MEMBER_NOT_FOUND));

        Mission mission = missionRepository.findById(missionId)
                .orElseThrow(() -> new MissionHandler(ErrorStatus.MISSION_NOT_FOUND));

        boolean alreadyChallenging = memberMissionRepository
                .existsByMemberAndMissionAndStatus(member, mission, MissionStatus.CHALLENGING);

        if (alreadyChallenging) {
            throw new MissionHandler(ErrorStatus.MISSION_ALREADY_CHALLENGED);
        }

        Optional<MemberMission> completedMissionOpt = memberMissionRepository
                .findByMemberAndMissionAndStatus(member, mission, MissionStatus.COMPLETE);

        if (completedMissionOpt.isPresent()) {
            MemberMission completedMission = completedMissionOpt.get();
            completedMission.updateStatus(MissionStatus.CHALLENGING);  // status 변경
            return mission;
        }

        // 3. 존재하지 않으면 새로 생성
        MemberMission newMission = MemberMissionConverter.toEntity(member, mission);
        memberMissionRepository.save(newMission);
        return mission;
    }

}
