package org.example.springmvc.exception;

import lombok.Getter;

public enum BusinessExceptionEnum {

    USER_NOT_EXIST(10001, "用户不存在"),
    USER_EXIST(10002, "用户已存在"),
    USER_NOT_LOGIN(10003, "用户未登录"),
    USER_NOT_ADMIN(10004, "用户不是管理员"),
    USER_NOT_EXIST_OR_PASSWORD_ERROR(10005, "用户不存在或密码错误");
    @Getter
    private Integer code;
    @Getter
    private String message;

    BusinessExceptionEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
