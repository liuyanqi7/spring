package com.qi.controller;

import com.qi.entity.Role;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Map;

@SessionAttributes(value = {"names"},types = Integer.class)
@Controller
public class TestController {
/**
 *@BelongsProject: spring
 *@BelongsPackage: com.qi.controller
 *@Author: 7
 *@CreateTime: 2018-12-17 15:11
 *@Description: session
 *@Version: 1.0
 */
        @RequestMapping("/test")
        public String test(Map<String,Object> map){
            map.put("names", Arrays.asList("zhangsan","lisi","wangwu"));
            map.put("age",21);
            return "test";
        }
    @RequestMapping("/test2")
    public ModelAndView test2() {
        ModelAndView mv = new ModelAndView();
        Role role = new Role();
        role.setRoleName("总经理");
        mv.addObject("role", role);
        mv.setViewName("test");
        return mv;
    }
    @RequestMapping("/test3")
    public String test3(Model model) {
        Role role = new Role();
        role.setRoleName("普通员工");
        model.addAttribute("role", role);
        return "test";
    }
}
