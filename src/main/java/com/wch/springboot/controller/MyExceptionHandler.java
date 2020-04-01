package com.wch.springboot.controller;

import com.wch.springboot.exception.UserNotExistException;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class MyExceptionHandler {

    @ExceptionHandler(UserNotExistException.class)
    public Map<String,Object> handlerException(Exception ex, HttpServletRequest request){
        Map<String,Object> map = new HashMap<>();
        map.put("message",ex.getMessage());
        map.put("code","user.notexist");
        return map;
    }




}



