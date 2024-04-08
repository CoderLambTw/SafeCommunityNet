package com.youngwu.safecommunitynet.model.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * @author: Young.Wu
 * @create-date: 2024/4/8 4:54 PM
 * @description:
 */

@Data
public class UserCreateDto {

    @NotNull(message = "Email is required")
    private String email;

    @NotNull(message = "Username is required")
    private String username;

    @NotNull(message = "Password is required")
    private String password;
}
