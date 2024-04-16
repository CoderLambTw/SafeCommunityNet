package com.youngwu.safecommunitynet.model.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.sql.Time;
import java.util.Date;

/**
 * @author: Young.Wu
 * @create-date: 2024/4/9 4:18 PM
 * @description:
 */

@Data
public class SocialEventCreateDto {

    @NotNull(message = "userId is required")
    private Long userId;

    @NotNull(message = "eventDate is required")
    private Date eventDate;

    @NotNull(message = "eventTime is required")
    private Time eventTime;

    @NotNull(message = "latitude is required")
    private Double latitude;

    @NotNull(message = "longitude is required")
    private Double longitude;

    @NotNull(message = "location is required")
    private String location;

    @NotNull(message = "eventType is required")
    private String eventType;

    @NotNull(message = "description is required")
    private String description;
}
