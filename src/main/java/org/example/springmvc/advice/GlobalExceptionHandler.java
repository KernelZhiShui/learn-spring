package org.example.springmvc.advice;

import org.example.springmvc.vo.response.Result;
import org.example.springmvc.exception.BusinessException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 全局处理业务异常
     *
     * @param businessException 业务异常
     * @return 错误信息
     */
    @ExceptionHandler(BusinessException.class)
    public Result<String> handleBusinessException(BusinessException businessException) {
        System.out.println("业务异常：" + businessException.getMessage());
        return Result.error(businessException.getCode(), businessException.getMessage());
    }

    /**
     * 全局处理业务异常
     *
     * @param methodArgumentNotValidException 校验异常
     * @return 错误信息
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Result<String> handleValidException(MethodArgumentNotValidException methodArgumentNotValidException) {
        System.out.println("校验异常：" + methodArgumentNotValidException.getMessage());
        BindingResult bindingResult = methodArgumentNotValidException.getBindingResult();
        Map<String, String> errorMap = new HashMap<>();
        for (FieldError fieldError : bindingResult.getFieldErrors()) {
            errorMap.put(fieldError.getField(), fieldError.getDefaultMessage());
        }
        System.out.println("errorMap:" + errorMap);
        return Result.error(500, "效验失败", errorMap);
    }

    /**
     * 全局处理其他异常
     *
     * @param e 异常
     * @return 错误信息
     */
    @ExceptionHandler(Exception.class)
    public Result<String> error(Exception e) {
        System.out.println("其他异常：" + e.getMessage());
        return Result.error(500, e.getMessage());
    }
}
