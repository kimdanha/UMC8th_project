package umc.spring.dto;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * umc.spring.dto.QMemberMissionDto is a Querydsl Projection type for MemberMissionDto
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QMemberMissionDto extends ConstructorExpression<MemberMissionDto> {

    private static final long serialVersionUID = 419256794L;

    public QMemberMissionDto(com.querydsl.core.types.Expression<Long> memberMissionId, com.querydsl.core.types.Expression<umc.spring.domain.enums.MissionStatus> status, com.querydsl.core.types.Expression<java.time.LocalDateTime> updatedAt, com.querydsl.core.types.Expression<Long> missionId, com.querydsl.core.types.Expression<Long> storeId, com.querydsl.core.types.Expression<Integer> reward, com.querydsl.core.types.Expression<java.time.LocalDate> deadline, com.querydsl.core.types.Expression<String> storeName, com.querydsl.core.types.Expression<String> cursor) {
        super(MemberMissionDto.class, new Class<?>[]{long.class, umc.spring.domain.enums.MissionStatus.class, java.time.LocalDateTime.class, long.class, long.class, int.class, java.time.LocalDate.class, String.class, String.class}, memberMissionId, status, updatedAt, missionId, storeId, reward, deadline, storeName, cursor);
    }

}

