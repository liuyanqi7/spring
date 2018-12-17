package com.qi.controller;

import com.qi.entity.Role;
import com.qi.entity.RoleParams;
import com.qi.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class FindRoleController {
/**
 *@BelongsProject: spring
 *@BelongsPackage: com.qi.controller
 *@Author: 7
 *@CreateTime: 2018-12-17 15:47
 *@Description: a
 *@Version: 1.0
 */
    @RequestMapping("findRolesTest")
    public ModelAndView test(Role role){
        List<Role> roleList = new ArrayList<Role>();
        Role r1 = new Role();
        r1.setRoleName("关羽");
        roleList.add(r1);
        Role r2 = new Role();
        r2.setRoleName("张飞");
        roleList.add(r2);
        ModelAndView mv = new ModelAndView();
        mv.setView(new MappingJackson2JsonView());
        mv.addObject(roleList);
        return mv;
    }
    @RequestMapping("/findRoles")
    public ModelAndView findRoles(@RequestBody RoleParams roleParams) {
        System.out.println(roleParams.getRoleName());
        System.out.println(roleParams.getPageParams().getLimit());

        List<Role> roleList = new ArrayList<Role>();
        Role r1 = new Role();
        r1.setRoleName("关羽");
        roleList.add(r1);
        Role r2 = new Role();
        r2.setRoleName("张飞");
        roleList.add(r2);
        ModelAndView mv = new ModelAndView();
        mv.setView(new MappingJackson2JsonView());
        mv.addObject(roleList);
        return mv;

    }

    @RequestMapping("/deleteRole")
    public ModelAndView deleteRole(@RequestBody List<Integer> idList) {
        ModelAndView mv = new ModelAndView();
        mv.setView(new MappingJackson2JsonView());
        mv.addObject("idList",idList);
        System.out.println(idList);
        return mv;
    }


    @RequestMapping("/roleList")
    public ModelAndView roleList(@RequestBody List<Role> rolesList) {
        ModelAndView mv = new ModelAndView();
        mv.setView(new MappingJackson2JsonView());

        for (Role role : rolesList) {
            System.out.println(role.getRoleName());
        }

        return mv;
    }


    @RequestMapping("/xuliehua")
    public ModelAndView xuliehua(User user) {
        ModelAndView mv = new ModelAndView();

        /*System.out.println(username);
        System.out.println(password);*/
        mv.setView(new MappingJackson2JsonView());
        mv.addObject(user);
        return mv;

    }

}
