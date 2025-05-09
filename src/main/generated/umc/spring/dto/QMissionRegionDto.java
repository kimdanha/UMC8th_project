package umc.spring.dto;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * umc.spring.dto.QMissionRegionDto is a Querydsl Projection type for MissionRegionDto
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QMissionRegionDto extends ConstructorExpression<MissionRegionDto> {

    private static final long serialVersionUID = 77596940L;

    public QMissionRegionDto(com.querydsl.core.types.Expression<Long> missionId, com.querydsl.core.types.Expression<Long> storeId, com.querydsl.core.types.Expression<String> storeName, com.querydsl.core.types.Expression<String> regionName, com.querydsl.core.types.Expression<Integer> reward, com.querydsl.core.types.Expression<String> missionSpec, com.querydsl.core.types.Expression<java.time.LocalDate> deadline, com.querydsl.core.types.Expression<Long> regionCompletedCount, com.querydsl.core.types.Expression<String> cursorValue) {
        super(MissionRegionDto.class, new Class<?>[]{long.class, long.class, String.class, String.class, int.class, String.class, java.time.LocalDate.class, long.class, String.class}, missionId, storeId, storeName, regionName, reward, missionSpec, deadline, regionCompletedCount, cursorValue);
    }

}

