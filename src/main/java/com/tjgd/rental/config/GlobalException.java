package com.tjgd.rental.config;


import com.tjgd.rental.utils.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;



@RestControllerAdvice
@Slf4j
public class GlobalException {


    //全局异常处理
    @ExceptionHandler(Exception.class)
    public Result handleException(Exception e){

        log.error("异常信息：{}", e.getMessage());

        return Result.error().setMessage(e.getMessage());
    }


}
