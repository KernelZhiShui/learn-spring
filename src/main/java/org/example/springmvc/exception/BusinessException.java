package org.example.springmvc.exception;

import lombok.Data;

/**
 * 业务异常类
 */
@Data
public class BusinessException extends RuntimeException {
    private Integer code; // 错误码
    private String message=""; // 错误信息

    public BusinessException(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public BusinessException(BusinessExceptionEnum businessExceptionEnum) {
        this.code = businessExceptionEnum.getCode();
        this.message = businessExceptionEnum.getMessage();
    }
}
