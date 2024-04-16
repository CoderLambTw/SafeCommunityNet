package com.youngwu.safecommunitynet.exception;

/**
 * @author: Young.Wu
 * @create-date: 2024/4/2 4:27 PM
 * @description:
 */
public class DataNotFoundException extends RuntimeException {
    public DataNotFoundException() {
        super();
    }

    public DataNotFoundException(String message) {
        super(message);
    }
}
