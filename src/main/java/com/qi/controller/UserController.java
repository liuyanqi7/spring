package com.qi.controller;

import com.qi.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {
/**
 *@BelongsProject: spring
 *@BelongsPackage: com.qi.controller
 *@Author: 7
 *@CreateTime: 2018-12-17 12:01
 *@Description: chuancan
 *@Version: 1.0
 */
        @RequestMapping("/login1")
        public ModelAndView login(User user){
            ModelAndView mv = new ModelAndView();
            mv.addObject("user",user);
            mv.setViewName("succ");
            return mv;
        }

        @RequestMapping("/login")
        public String login(User user, HttpSession session){
            session.setAttribute("user",user);
            return "redirect:list.do";
        }
        @RequestMapping("/list")
        public String list(User user,HttpSession session){
            User u = (User) session.getAttribute("user");
            System.out.println(u.getUsername());
            return "list";
        }
        @RequestMapping("/getPro")
        public String getProductById(@RequestParam("proId") Integer id){
            System.out.println("proid====" + id);
            return null;
        }

}
