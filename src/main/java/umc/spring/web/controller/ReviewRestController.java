package umc.spring.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.dto.ReviewRequestDTO;
import umc.spring.domain.Store;
import umc.spring.service.ReviewService.ReviewCommandService;
import umc.spring.service.ReviewService.ReviewCommandServiceImpl;

@RestController
@RequestMapping("/reviews")
@RequiredArgsConstructor
public class ReviewRestController {
    private final ReviewCommandServiceImpl reviewCommandService;

    @PostMapping("/{storeId}")
    @Operation(summary = "가게 리뷰 작성 API")
    public ApiResponse addReview(@PathVariable("storeId") Long storeId,
                                 @RequestBody @Valid ReviewRequestDTO dto,
                                 @RequestParam("memberId") Long memberId) {
        return ApiResponse.onSuccess(reviewCommandService.addReview(storeId, dto, memberId));
    }

}
