package com.ltc.controllers;

import com.ltc.dto.CartDTO;
import com.ltc.dto.OrderDTO;
import com.ltc.dto.OrderProductDTO;
import com.ltc.services.CartServices;
import com.ltc.services.CheckOutServices;
import com.ltc.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class CheckOutController {
    @Autowired
    CartServices cartServices;

    @Autowired
    CheckOutServices checkOutServices;

    @RequestMapping(value = "/check-out", method = RequestMethod.GET)
    public ModelAndView checkOutPage(HttpSession session){
        HashMap<Long, CartDTO> cart = (HashMap<Long, CartDTO>) session.getAttribute("Cart");
        ModelAndView mav = new ModelAndView("check-out");
        mav.addObject("orders",new OrderDTO());
        mav.addObject("cart", cart);
        return mav;
    }

    @RequestMapping(value = "/check-out", method = RequestMethod.POST)
    public String saveOrder(HttpSession session, @Valid @ModelAttribute("orders") OrderDTO orderDTOs, Errors errors, HttpServletResponse response) throws Exception {
        PrintWriter out = response.getWriter();
        if (errors.hasErrors() == true){
            out.print("error");
            return "check-out";
        }
        orderDTOs.setTotalPrice((Long) session.getAttribute("TotalPriceCart"));
        orderDTOs.setTotalQuantity((Long) session.getAttribute("TotalQuantityCart"));
        HashMap<Long, CartDTO> cart = (HashMap<Long, CartDTO>) session.getAttribute("Cart");
        if (cart.isEmpty()){
            out.print("error");
            return "check-out";
        }
        List<OrderProductDTO> orderProductDTOS = new ArrayList<>();
        for (Map.Entry<Long, CartDTO> items: cart.entrySet()) {
            OrderProductDTO orderProductDTO = new OrderProductDTO();
            orderProductDTO.setProduct(items.getValue().getProduct());
            orderProductDTO.setTotal(items.getValue().getTotalPrice());
            orderProductDTO.setQuantity(items.getValue().getQuantity());
            orderProductDTOS.add(orderProductDTO);
        }

        try {
            checkOutServices.saveOrUpdate(orderDTOs, SecurityUtils.getPrincipal().getUsername(),orderProductDTOS);
        }catch (Exception e){
            System.out.println(e);
        }
        session.removeAttribute("Cart");
        session.removeAttribute("TotalQuantityCart");
        session.removeAttribute("TotalPriceCart");
        return "check-order";
    }
}
