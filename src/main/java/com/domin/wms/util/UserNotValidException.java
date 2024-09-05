package com.domin.wms.util;

public class UserNotValidException extends RuntimeException {
    public UserNotValidException(String msg) {
        super(msg);
    }
}
