package umc.spring.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.spring.dto.ReviewRequestDTO;
import umc.spring.domain.Store;
import umc.spring.service.ReviewService.ReviewCommandServiceImpl;

@RestController
@RequestMapping("/reviews")
@RequiredArgsConstructor
public class ReviewRestController {
    private final ReviewCommandServiceImpl reviewService;

    @PostMapping("/{storeId}")
    @Operation(summary = "가게 리뷰 작성 API")
    public void addReview(@PathVariable Long storeId,
                          @RequestBody @Valid ReviewRequestDTO dto,
                          @RequestParam Long memberId) {
        reviewService.addReview(storeId, dto, memberId);
    }

}
