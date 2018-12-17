package com.qi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
/**
 *@BelongsProject: spring
 *@BelongsPackage: com.qi.controller
 *@Author: 7
 *@CreateTime: 2018-12-17 11:26
 *@Description: springmvc
 *@Version: 1.0
 */
        @RequestMapping("hello")
        public ModelAndView hello(){
            ModelAndView mv=new ModelAndView();
            //添加模型数据(request)
            mv.addObject("message","helloWorld");
            //设置逻辑视图名，视图解析器会根据该名字解析到具体的视图页面
            mv.setViewName("hello");
            return mv;
        }
}
