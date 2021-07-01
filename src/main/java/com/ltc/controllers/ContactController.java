package com.ltc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ContactController {
    @RequestMapping(value = "/contact", method = RequestMethod.GET)
    public ModelAndView contacPage(){
        ModelAndView mav = new ModelAndView("contact");
        return mav;
    }
}
