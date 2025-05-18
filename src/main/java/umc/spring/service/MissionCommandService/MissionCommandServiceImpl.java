package umc.spring.service.MissionCommandService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.apiPayload.exception.handler.StoreHandler;
import umc.spring.domain.Mission;
import umc.spring.domain.Store;
import umc.spring.dto.MissionRequestDTO;
import umc.spring.repository.MissionRepository.MissionRepository;
import umc.spring.repository.StoreRepository.StoreRepository;

@Service
@RequiredArgsConstructor
public class MissionCommandServiceImpl implements MissionCommandService{

    private final StoreRepository storeRepository;
    private final MissionRepository missionRepository;

    public void addMissionToStore(Long storeId, MissionRequestDTO dto) {
        Store store = storeRepository.findById(storeId)
                .orElseThrow(() -> new StoreHandler(ErrorStatus.STORE_NOT_FOUND));

        Mission mission = Mission.builder()
                .missionSpec(dto.getMissionSpec())
                .reward(dto.getReward())
                .store(store)
                .build();

        missionRepository.save(mission);
    }

}
