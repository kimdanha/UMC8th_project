package umc.spring.service.ReviewService;

import umc.spring.domain.Review;
import umc.spring.dto.ReviewRequestDTO;

public interface ReviewCommandService {
    Review addReview(Long storeId, ReviewRequestDTO dto, Long memberId);
}
