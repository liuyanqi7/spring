package com.qi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
@Controller
public class Upload2 {
    /**
     * 使用spring mvc提供的类的方法上传文件
     * @param request
     * @return
     * @throws IOException
     */
    @RequestMapping("springUpload")
    public String springUpload(HttpServletRequest request) throws IOException {
        long startTime = System.currentTimeMillis();
        //将当前上下文初始化给 CommonsMutipartResolver （多部分解析器）
        CommonsMultipartResolver mu = new CommonsMultipartResolver(
                request.getSession().getServletContext()
        );
        //检查form中是否有enctype="multipart/form-data"
        if (mu.isMultipart(request)) {
            //将request变成多部分request
            MultipartHttpServletRequest mh = (MultipartHttpServletRequest) request;
            //获取mh中的所有文件名
            Iterator iter = mh.getFileNames();
            while (iter.hasNext()) {
                //一次遍历所有文件
                MultipartFile file = mh.getFile(iter.next().toString());
                if (file != null) {
                    System.out.println("request.getRealPath(\"upload\")");
                    String path=request.getRealPath("upload")+File.separator+file.getOriginalFilename();
                    System.out.println(path);
                    //上传
                    file.transferTo(new File(path));
                }

            }
        }
        long startTime1 = System.currentTimeMillis();
        System.out.println("方法三运行时间" + String.valueOf(startTime1 - startTime) + "ms");
        return "/sss";
    }
}
