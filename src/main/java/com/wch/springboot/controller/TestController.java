package com.wch.springboot.controller;

import com.wch.springboot.exception.UserNotExistException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class TestController {

    @RequestMapping("/test")
    public String test() {
        return "hello.html";
    }

    @RequestMapping("/success")
    public String success(Map<String,Object> map, @RequestParam("user") String user){
        System.out.println(user);
        System.out.println(user.equals("aaa"));
        if("aaa".equals(user)){
            throw new UserNotExistException();
        }

        map.put("hello","hello world");
        return "success";
    }

}
