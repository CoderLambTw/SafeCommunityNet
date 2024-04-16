package com.youngwu.safecommunitynet.model.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.sql.Time;
import java.util.Date;

/**
 * @author: Young.Wu
 * @create-date: 2024/4/16 3:35 PM
 * @description:
 */

@Data
public class SocialEventUpdatedDto {

    @NotNull(message = "id is required")
    private Long id;

    @NotNull(message = "userId is required")
    private Long userId;

    private Date eventDate;

    private Time eventTime;

    // 緯度
    private Double latitude;

    // 經度
    private Double longitude;

    private String location;

    private String eventType;

    private String description;

}
