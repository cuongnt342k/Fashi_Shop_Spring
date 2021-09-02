package com.ltc.controllers;

import com.ltc.dto.CartDTO;
import com.ltc.services.CartServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ShoppingCartController {
    @Autowired
    CartServices cartServices;

    @RequestMapping(value = "/shopping-cart", method = RequestMethod.GET)
    public ModelAndView shoppingCartPage(HttpSession session) {
        HashMap<Long, CartDTO> cart = (HashMap<Long, CartDTO>) session.getAttribute("Cart");
        ModelAndView mav = new ModelAndView("shopping-cart");
        mav.addObject("cart", cart);
        return mav;
    }

    @RequestMapping(value = "/shopping-cart/getAll", method = RequestMethod.GET)
    public List<CartDTO> getAllProductnCart(HttpSession session) {
        HashMap<Long, CartDTO> cart = (HashMap<Long, CartDTO>) session.getAttribute("Cart");
        List<CartDTO> product = cart.entrySet().stream()
                .map(entry -> entry.getValue())
                .collect(Collectors.toList());
        return product;
    }

    @PostMapping(value = "/addCart")
    public String addCart(HttpServletRequest request,
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
        return " item(s) of this product were added to your shopping cart!";
    }

    @RequestMapping(value = "/editCart")
    public ModelAndView editCart(HttpServletRequest request, HttpSession session) {
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
        ModelAndView mav = new ModelAndView("shopping-cart");
        return mav;
    }

    @RequestMapping(value = "deleteCart/{id}")
    public String deleteCart(HttpServletRequest request, HttpSession session, @PathVariable Long id) {
        HashMap<Long, CartDTO> cart = (HashMap<Long, CartDTO>) session.getAttribute("Cart");
        if (cart == null) {
            cart = new HashMap<Long, CartDTO>();
        }
        cart = cartServices.deleteCart(id, cart);
        session.setAttribute("Cart", cart);
        session.setAttribute("TotalQuantityCart", cartServices.totalQuantity(cart));
        session.setAttribute("TotalPriceCart", cartServices.totalPrice(cart));
        return " Deleted successfully! ";
    }

}
