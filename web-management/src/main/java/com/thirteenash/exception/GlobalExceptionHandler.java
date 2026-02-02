package com.thirteenash.exception;

import com.thirteenash.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//全局异常处理
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    // 处理所有不可知的异常
    @ExceptionHandler
    public Result handleException(Exception e){
        log.error("程序出错了", e);
        return Result.error("服务器出错了，请联系管理人员~");
    }

    // 处理所有可知的异常
    @ExceptionHandler
    public Result handleDuplicateKeyException(DuplicateKeyException e){
        log.error("程序出错了", e);
        String message = e.getMessage();
        int i = message.indexOf("Duplicate entry");//indexOf 方法返回指定字符在字符串中第一次出现的索引
        String errMsg = message.substring(i);//substring 方法返回指定子字符串在此字符串中的开始索引和结束索引之间的子字符串
        String[] arr = errMsg.split(" ");//split 方法将此字符串根据匹配给定的正则表达式拆分为字符串数组
        return Result.error(arr[2] + "已存在");
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public Result handleHttpMessageNotReadableException(HttpMessageNotReadableException e) {
        log.error("JSON解析错误", e);
        return Result.error("请求参数格式错误，请检查数据格式");
    }
}
