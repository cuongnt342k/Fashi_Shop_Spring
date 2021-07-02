package com.ltc.controllers;

import com.ltc.dto.CartDTO;
import com.ltc.services.CartServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;

@Controller
public class ShoppingCartController {
    @Autowired
    CartServices cartServices;

    @RequestMapping(value = "/shopping-cart", method = RequestMethod.GET)
    public ModelAndView shoppingcartPage(HttpSession session) {
        HashMap<Long, CartDTO> cart = (HashMap<Long, CartDTO>) session.getAttribute("Cart");
        ModelAndView mav = new ModelAndView("shopping-cart");
        mav.addObject("cart", cart);
        return mav;
    }

    @RequestMapping(value = "/addCart")
    public String AddCart(HttpServletRequest request,
                          HttpSession session,
                          @RequestParam(value = "quantity") int quantity,
                          @RequestParam(value = "id") Long id) {
        HashMap<Long, CartDTO> cart = (HashMap<Long, CartDTO>) session.getAttribute("Cart");
        if (cart == null) {
            cart = new HashMap<Long, CartDTO>();
        }
        cart = cartServices.addCart(id,quantity,cart);
        session.setAttribute("Cart", cart);
        session.setAttribute("TotalQuantityCart", cartServices.totalQuantity(cart));
        session.setAttribute("TotalPriceCart", cartServices.totalPrice(cart));
        return "redirect:" + request.getHeader("Referer");
    }

    @RequestMapping(value = "/editCart")
    public String EditCart(HttpServletRequest request, HttpSession session) {
        HashMap<Long, CartDTO> cart = (HashMap<Long, CartDTO>) session.getAttribute("Cart");
        if (cart == null) {
            cart = new HashMap<Long, CartDTO>();
        }
        String[] cartId = request.getParameterValues("cartId");
        String[] quantity = request.getParameterValues("quantity");

        for (int i = 0; i < cart.size(); i++) {
            cart = cartServices.editCart(Long.parseLong(cartId[i]), Integer.parseInt(quantity[i]), cart);
        }
        session.setAttribute("Cart", cart);
        session.setAttribute("TotalQuantityCart", cartServices.totalQuantity(cart));
        session.setAttribute("TotalPriceCart", cartServices.totalPrice(cart));
        return "redirect:" + request.getHeader("Referer");
    }

    @RequestMapping(value = "deleteCart/{id}")
    public String DeleteCart(HttpServletRequest request, HttpSession session, @PathVariable Long id) {
        HashMap<Long, CartDTO> cart = (HashMap<Long, CartDTO>) session.getAttribute("Cart");
        if (cart == null) {
            cart = new HashMap<Long, CartDTO>();
        }
        cart = cartServices.deleteCart(id, cart);
        session.setAttribute("Cart", cart);
        session.setAttribute("TotalQuantityCart", cartServices.totalQuantity(cart));
        session.setAttribute("TotalPriceCart", cartServices.totalPrice(cart));
        return "redirect:" + request.getHeader("Referer");
    }

}
