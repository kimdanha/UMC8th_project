package umc.spring.converter;

import umc.spring.domain.*;
import umc.spring.dto.ReviewRequestDTO;

public class ReviewConverter {

    public static Review toEntity(ReviewRequestDTO dto, Member member, Store store) {
        return Review.builder()
                .title(dto.getTitle())
                .body(dto.getBody())
                .score(dto.getScore())
                .member(member)
                .store(store)
                .build();
    }
}

