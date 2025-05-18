package umc.spring.repository.MemberMissionRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.domain.Member;
import umc.spring.domain.Mission;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.domain.mapping.MemberMission;

import java.util.Optional;

public interface MemberMissionRepository extends JpaRepository<MemberMission, Long> {

    boolean existsByMemberAndMissionAndStatus(Member member, Mission mission, MissionStatus status);
    Optional<MemberMission> findByMemberAndMissionAndStatus(Member member, Mission mission, MissionStatus status);

}


