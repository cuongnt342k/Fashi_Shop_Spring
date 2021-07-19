package com.ltc.controllers.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/admin")
public class OrderManagementController {
    @RequestMapping(value = "/order-management", method = RequestMethod.GET)
    public ModelAndView orderManagementPage() {
        ModelAndView mav = new ModelAndView("admin/order-management");
        return mav;
    }

}
