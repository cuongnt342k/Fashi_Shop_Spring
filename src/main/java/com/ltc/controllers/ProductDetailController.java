package com.ltc.controllers;

import com.ltc.model.Product;
import com.ltc.services.ProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProductDetailController {
    @Autowired
    ProductServices productServices;

    @RequestMapping(value = "/product-deatil", method = RequestMethod.GET)
    public ModelAndView productdeatilPage(@RequestParam(value = "productId") Long productId) throws Exception {
        ModelAndView mav = new ModelAndView("product-detail");
        Product product = productServices.findProductById(productId);
        mav.addObject("product", product);
        return mav;
    }
}
