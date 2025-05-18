package umc.spring.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.service.MissionCommandService.MissionCommandService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/missions")
public class MissionRestController {

    private final MissionCommandService missionCommandService;

    @PostMapping("/{missionId}/challenge")
    @Operation(summary = "미션 도전하기 API")
    public ApiResponse challengeMission(@PathVariable("missionId") Long missionId,
                                        @RequestParam("memberId") Long memberId) {
        return ApiResponse.onSuccess(missionCommandService.challengeMission(missionId, memberId));
    }
}
