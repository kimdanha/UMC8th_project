package umc.spring.service.MissionCommandService;

import umc.spring.domain.Mission;
import umc.spring.dto.MissionRequestDTO;

public interface MissionCommandService {
    Long addMissionToStore(Long storeId, MissionRequestDTO dto);
    Mission challengeMission(Long missionId, Long memberId);
}
