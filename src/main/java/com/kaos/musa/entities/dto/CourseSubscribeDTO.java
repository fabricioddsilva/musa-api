package com.kaos.musa.entities.dto;

public record CourseSubscribeDTO(
        Integer userId,
        Integer courseId,
        Integer trailId
) {
}
