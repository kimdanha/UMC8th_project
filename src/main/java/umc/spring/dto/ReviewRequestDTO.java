package umc.spring.dto;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class ReviewRequestDTO {
    @NotBlank(message = "리뷰 제목은 필수입니다.")
    private String title;

    private String body;

    @NotNull(message = "평점은 필수입니다.")
    @DecimalMin(value = "0.0", inclusive = false, message = "0점 이상이어야 합니다.")
    @DecimalMax(value = "5.0", message = "5점 이하여야 합니다.")
    private Float score;

}
