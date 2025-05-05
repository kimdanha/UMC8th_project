package umc.spring.repository.MemberMissionRepository;

import umc.spring.domain.enums.MissionStatus;
import umc.spring.dto.MemberMissionDto;

import java.time.LocalDateTime;
import java.util.List;

public interface MemberMissionRepositoryCustom {
    List<MemberMissionDto> findMissionsWithCursor(
            Long memberId,
            MissionStatus status,
            LocalDateTime updatedAt,
            Long missionId,
            int pageSize
    );
}

