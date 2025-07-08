package org.example.springmvc.advice;

import org.example.springmvc.common.Result;
import org.example.springmvc.exception.BusinessException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 全局处理业务异常
     * @param businessException
     * @return
     */
    @ExceptionHandler(BusinessException.class)
    public Result<String> handleBusinessException(BusinessException businessException) {
        System.out.println("业务异常：" + businessException.getMessage());
        return Result.error(businessException.getCode(), businessException.getMessage());
    }

    /**
     * 全局处理其他异常
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    public Result<String> error(Exception e) {
        System.out.println("其他异常：" + e.getMessage());
        return Result.error(500, e.getMessage());
    }
}
