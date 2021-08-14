package com.ltc.controllers;

import com.ltc.model.Product;
import com.ltc.services.ProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ShopController {

    @Autowired
    ProductServices productServices;

    @RequestMapping(value = "/shop", method = RequestMethod.GET)
    public String shopPage(@RequestParam(value = "categoryId", required = false) Long categoryId,
                           @RequestParam(value = "sortName", required = false) String sortName, Pageable pageable, Model mav) throws Exception {
        Page<Product> pages;
        if (categoryId != null) {
            pages = productServices.findProductByCategory(categoryId, pageable);
        } else {
            pages = productServices.getAllProduct(pageable,false);
        }
        mav.addAttribute("number", pages.getNumber());
        mav.addAttribute("totalPages", pages.getTotalPages());
        mav.addAttribute("totalElements", pages.getTotalElements());
        mav.addAttribute("size", pages.getSize());
        mav.addAttribute("products", pages.getContent());
        mav.addAttribute("categoryId", categoryId);
//        mav.addAttribute("page", page);
        return "shop";
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String shopSearch(@RequestParam(value = "page") int page,
                             @RequestParam(value = "categoryId", required = false) Long categoryId,
                             @RequestParam(value = "textSearch", required = false) String textSearch,
                             Pageable pageable, Model mav) throws Exception {
        Page<Product> pages;
        if (textSearch != null) {
            pages = productServices.findProductName(textSearch, pageable);
        } else {
            pages = productServices.getAllProduct(pageable,false);
        }
        mav.addAttribute("number", pages.getNumber());
        mav.addAttribute("totalPages", pages.getTotalPages());
        mav.addAttribute("totalElements", pages.getTotalElements());
        mav.addAttribute("size", pages.getSize());
        mav.addAttribute("products", pages.getContent());
        mav.addAttribute("page", page);
        mav.addAttribute("textSearch", textSearch);
        return "shop";
    }
}
