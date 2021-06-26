package com.ltc.controllers;

import com.ltc.dto.ProductDTO;
//import com.ltc.services.ProductServices;
import com.ltc.services.ProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ShopController {

    @Autowired
    ProductServices productServices;

    @RequestMapping(value = "/shop", method = RequestMethod.GET)
    public ModelAndView shopPage() throws Exception {
        List<ProductDTO> productDTOList = productServices.findAllProduct();
        ModelAndView mav = new ModelAndView("shop");
        mav.addObject("productList",productDTOList);
        return mav;
    }

}
