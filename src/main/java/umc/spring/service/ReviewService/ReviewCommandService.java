package umc.spring.service.ReviewService;

import umc.spring.dto.ReviewRequestDTO;

public interface ReviewCommandService {
    void addReview(Long storeId, ReviewRequestDTO dto, Long memberId);
}
