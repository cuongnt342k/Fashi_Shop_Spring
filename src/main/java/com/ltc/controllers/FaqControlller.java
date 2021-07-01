package com.ltc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FaqControlller {
    @RequestMapping(value = "/faq", method = RequestMethod.GET)
    public ModelAndView faqPage(){
        ModelAndView mav = new ModelAndView("faq");
        return mav;
    }
}
