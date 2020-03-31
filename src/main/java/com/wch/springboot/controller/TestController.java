package com.wch.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
public class TestController {

    @RequestMapping("/test")
    public String test() {
        return "hello.html";
    }

    @RequestMapping("/success")
    public String success(Map<String,Object> map){
        map.put("hello","hello world");
        return "success";
    }

}
