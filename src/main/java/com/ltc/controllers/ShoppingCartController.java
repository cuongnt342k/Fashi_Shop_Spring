package com.ltc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ShoppingCartController {
    @RequestMapping(value = "/shopping-cart", method = RequestMethod.GET)
    public ModelAndView shoppingcartPage(){
        ModelAndView mav = new ModelAndView("shopping-cart");
        return mav;
    }
}
