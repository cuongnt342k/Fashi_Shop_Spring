package com.ltc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CategoryController {
    @RequestMapping(value = "/category", method = RequestMethod.GET)
    public ModelAndView shopPage(){
        ModelAndView mav = new ModelAndView("shop");
        return mav;
    }
}
