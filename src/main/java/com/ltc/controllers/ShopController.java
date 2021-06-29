package com.ltc.controllers;

import com.ltc.dto.ProductDTO;
import com.ltc.model.Product;
import com.ltc.services.ProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

//import com.ltc.services.ProductServices;

@Controller
public class ShopController {

    @Autowired
    ProductServices productServices;

    @RequestMapping(value = "/shop", method = RequestMethod.GET)
    public String shopPage(@RequestParam(value = "page") int page,
                           @RequestParam(value = "categoryId", required = false) Long categoryId,
                           @RequestParam(value = "sortName", required = false) String sortName, Pageable pageable, Model mav) throws Exception {

        ProductDTO productDTO = new ProductDTO();
//        int size = 6;
        Page<Product> pages;
        if (categoryId == null) {
            pages = productServices.getAllProduct(pageable);
        } else {
            pages = productServices.findProductByCategory(categoryId, pageable);
        }
        mav.addAttribute("number", pages.getNumber());
        mav.addAttribute("totalPages", pages.getTotalPages());
        mav.addAttribute("totalElements", pages.getTotalElements());
        mav.addAttribute("size", pages.getSize());
        mav.addAttribute("products", pages.getContent());
        mav.addAttribute("categoryId", categoryId);
        mav.addAttribute("page",page);
        return "shop";
    }

    @RequestMapping(value = "/shopSearch", method = RequestMethod.GET)
    public ModelAndView shopPage() throws Exception {
        ProductDTO productDTO = new ProductDTO();
        ModelAndView mav = new ModelAndView("shop");


        mav.addObject("products", productDTO);
        return mav;
    }
}
