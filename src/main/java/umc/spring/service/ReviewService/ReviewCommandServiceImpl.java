package umc.spring.service.ReviewService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.apiPayload.exception.handler.StoreHandler;
import umc.spring.converter.ReviewConverter;
import umc.spring.domain.Member;
import umc.spring.domain.Review;
import umc.spring.domain.Store;
import umc.spring.dto.ReviewRequestDTO;
import umc.spring.repository.MemberRepository.MemberRepository;
import umc.spring.repository.ReviewRepository.ReviewRepository;
import umc.spring.repository.StoreRepository.StoreRepository;

@Service
@RequiredArgsConstructor
public class ReviewCommandServiceImpl implements ReviewCommandService {

    private final ReviewRepository reviewRepository;
    private final StoreRepository storeRepository;
    private final MemberRepository memberRepository;

    @Override
    public Long addReview(Long storeId, ReviewRequestDTO dto, Long memberId) {
        Store store = storeRepository.findById(storeId)
                .orElseThrow(() -> new StoreHandler(ErrorStatus.STORE_NOT_FOUND));
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new StoreHandler(ErrorStatus.MEMBER_NOT_FOUND));

        return reviewRepository.save(ReviewConverter.toEntity(dto, member, store)).getId();
    }
}
