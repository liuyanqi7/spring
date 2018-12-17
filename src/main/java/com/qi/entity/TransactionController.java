package com.qi.entity;


import com.qi.interceptor.TransactionValidator;
import org.springframework.stereotype.Controller;
import org.springframework.validation.DataBinder;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/validate")
public class TransactionController {

    @RequestMapping("/validator")
    public ModelAndView transValidate(@Valid Transaction trans, Errors errors) {
        //是否存在错误
        if (errors.hasErrors()) {
            List<FieldError> errorList = errors.getFieldErrors();
            for (FieldError fieldError : errorList) {
                System.out.println("错误的字段：" + fieldError.getField() + ",\t" + fieldError.getDefaultMessage());
            }
        }

        ModelAndView mv = new ModelAndView();
        mv.setViewName("hello");
        return mv;
    }

    @InitBinder
    public void initBinder(DataBinder binder) {
        binder.setValidator(new TransactionValidator());
    }


}
