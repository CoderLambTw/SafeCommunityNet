package com.youngwu.safecommunitynet.exception;

/**
 * @author: Young.Wu
 * @create-date: 2024/4/2 4:27 PM
 * @description:
 */
public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException() {
        super();
    }

    public UserNotFoundException(String message) {
        super(message);
    }
}
