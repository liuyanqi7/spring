package com.qi.controller;

import com.qi.entity.Role;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import javax.servlet.http.HttpSession;
@Controller
@RequestMapping("/role")
public class RoleController {

/**
 *@BelongsProject: spring
 *@BelongsPackage: com.qi.controller
 *@Author: 7
 *@CreateTime: 2018-12-17 14:15
 *@Description: json
 *@Version: 1.0
 */
      /*  @RequestMapping("/addRole")
        public String addRole (HttpSession session, Role role){
            session.setAttribute("role",role);
            return "redirect:/role/showRoleJsonInfo.do";
        }
        @RequestMapping("/showRoleJsonInfo")
        public ModelAndView showRoleJson(HttpSession session){
            *//**
             * 转化为Json时如果使用模型视图，需要setView(new MappingJackson2JsonView()) 将View类型转化为Json
             *//*
            ModelAndView mv=new ModelAndView();
            mv.setView(new MappingJackson2JsonView());
            Role r = (Role) session.getAttribute("role");
            mv.addObject("role",r);
            return mv;
        }*/
            @RequestMapping("/addRole")
            public String addRole(RedirectAttributes ra, Role role){
                ra.addFlashAttribute("role",role);
                return "redirect:/role/showRoleJsonInfo.do";
            }
            @RequestMapping("/showRoleJsonInfo")
            public ModelAndView showRoleJsonInfo(Role role){
                ModelAndView mv = new ModelAndView();
                mv.setView(new MappingJackson2JsonView());
                mv.addObject("role",role);
                return mv;
            }
}
