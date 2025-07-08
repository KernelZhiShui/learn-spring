package org.example.springmvc.advice;

import org.example.springmvc.common.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public Result<String> error(Exception e) {
        return Result.error(500, e.getMessage());
    }
}
