package com.qi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
@Controller
@RequestMapping("/header")
public class HeaderController {
/**
 *@BelongsProject: spring
 *@BelongsPackage: com.qi.controller
 *@Author: 7
 *@CreateTime: 2018-12-17 16:51
 *@Description: con
 *@Version: 1.0
 */
        @RequestMapping("/getHeaderAndCookie")
        public String testHeaderAndCoolie(
                @RequestHeader(value = "User-Agent",required = false,defaultValue = "attribute")
                        String userAgent, HttpSession session){
            System.out.println("请求头：" + userAgent);
            System.out.println("sessionId===" + session.getId());
            return null;
        }

}
