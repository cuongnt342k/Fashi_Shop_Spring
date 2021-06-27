package com.ltc.controllers;

import com.ltc.dto.ProductDTO;
//import com.ltc.services.ProductServices;
import com.ltc.services.ProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ShopController {

    @Autowired
    ProductServices productServices;

    @RequestMapping(value = "/shop", method = RequestMethod.GET)
    public ModelAndView shopPage(@RequestParam("page") int page,
                                 @RequestParam("limit") int limit) throws Exception {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setPage(page);
        productDTO.setLimit(limit);
        ModelAndView mav = new ModelAndView("shop");
        Pageable pageable = new PageRequest(page-1,limit);
        productDTO.setListResult(productServices.findAllProduct(pageable));
        productDTO.setTotalItem(productServices.getTotalItem());
        productDTO.setTotalPage((int) Math.ceil((double) productDTO.getTotalItem()/productDTO.getLimit()));
        //List<ProductDTO> productDTOList = productServices.findAllProduct(pageable);
        mav.addObject("products",productDTO);
        return mav;
    }

}
