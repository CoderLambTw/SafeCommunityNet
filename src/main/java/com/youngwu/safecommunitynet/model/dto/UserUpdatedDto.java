package com.youngwu.safecommunitynet.model.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * @author: Young.Wu
 * @create-date: 2024/4/8 4:54 PM
 * @description:
 */

@Data
public class UserUpdatedDto {

    @NotNull
    private Long id;

    private String userName;

    private String email;

    private String password;
}
