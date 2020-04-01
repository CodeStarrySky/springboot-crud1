package com.wch.springboot.component;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginHandlerInterceptor implements HandlerInterceptor {
     @Override
   public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        HttpSession session = request.getSession();
//        if(session.getAttribute("loginUser")==null){
//            request.setAttribute("msg","无访问权限");
//            request.getRequestDispatcher("/index.html").forward(request,response);
//            return false;
//        }

       return true;
   }


}
