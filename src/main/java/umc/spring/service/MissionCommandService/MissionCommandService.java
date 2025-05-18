package umc.spring.service.MissionCommandService;

import umc.spring.dto.MissionRequestDTO;

public interface MissionCommandService {
    void addMissionToStore(Long storeId, MissionRequestDTO dto);
}
