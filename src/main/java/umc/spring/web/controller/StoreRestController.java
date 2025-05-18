package umc.spring.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.spring.dto.MissionRequestDTO;
import umc.spring.service.MissionCommandService.MissionCommandService;

@RestController
@RequestMapping("/stores")
@RequiredArgsConstructor
public class StoreRestController {
    private final MissionCommandService missionService;

    @PostMapping("/{storeId}/missions")
    @Operation(summary = "가게에 미션 추가 API")
    public void addMissionToStore(@PathVariable("storeId") Long storeId,
                                  @RequestBody @Valid MissionRequestDTO dto) {
        missionService.addMissionToStore(storeId, dto);
    }
}
