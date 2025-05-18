package umc.spring.dto;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class MissionRequestDTO {

    @NotBlank(message = "미션 설명은 필수입니다.")
    @Size(max = 50, message = "미션 설명은 최대 50자까지 입력 가능합니다.")
    private String missionSpec;

    @NotNull(message = "보상(reward)은 필수입니다.")
    @Min(value = 1, message = "보상은 1 이상이어야 합니다.")
    private Integer reward;

    @NotNull(message = "마감일(deadline)은 필수입니다.")
    @Future(message = "마감일은 미래 날짜여야 합니다.")
    private LocalDate deadline;
}

