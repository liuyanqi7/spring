package com.qi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProductController {
/**
 *@BelongsProject: spring
 *@BelongsPackage: com.qi.controller
 *@Author: 7
 *@CreateTime: 2018-12-17 15:28
 *@Description: restful
 *@Version: 1.0
 */
    @RequestMapping("/getPro/{classid}/{productid}")
    private String getProduct(@PathVariable("classid") int classid, @PathVariable("productid") int productid, Model model){
        model.addAttribute("classid", classid);
        model.addAttribute("productid", productid);
        return "test";
    }

}
