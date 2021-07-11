package com.ltc.services.impl;

import com.ltc.dto.CartDTO;
import com.ltc.model.Product;
import com.ltc.repo.ProductRepo;
import com.ltc.services.CartServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class CartServicesImpl implements CartServices {

    @Autowired
    private ProductRepo productRepo;

    @Override
    public HashMap<Long, CartDTO> addCart(Long id, int quantity, HashMap<Long, CartDTO> cart) {
        CartDTO itemCart = new CartDTO();
        Product product = productRepo.findById(id);
        if (product != null && cart.containsKey(id)) {
            itemCart = cart.get(id);
            itemCart.setQuantity(itemCart.getQuantity() + quantity);
            itemCart.setTotalPrice(itemCart.getQuantity() * itemCart.getProduct().getPrice());
        } else {
            itemCart.setProduct(product);
            itemCart.setQuantity(quantity);
            itemCart.setTotalPrice(product.getPrice());
        }
        cart.put(id, itemCart);
        return cart;
    }

    @Override
    public HashMap<Long, CartDTO> editCart(Long cartId, int quantity, HashMap<Long, CartDTO> cart) {
        if (cart == null) {
            return cart;
        }
        CartDTO itemCart = new CartDTO();
        itemCart = cart.get(cartId);
        itemCart.setQuantity(quantity);
        Long totalPrice = quantity * itemCart.getProduct().getPrice();
        itemCart.setTotalPrice(totalPrice);
        cart.put(cartId, itemCart);
        return cart;
    }

    @Override
    public HashMap<Long, CartDTO> deleteCart(Long id, HashMap<Long, CartDTO> cart) {
        if (cart == null) {
            return cart;
        }
        if (cart.containsKey(id)) {
            cart.remove(id);
        }
        return cart;
    }

    @Override
    public Long totalQuantity(HashMap<Long, CartDTO> cart) {
        Long totalQuanty = Long.valueOf(0);
        for (Map.Entry<Long, CartDTO> itemCart : cart.entrySet()) {
            totalQuanty += itemCart.getValue().getQuantity();
        }
        return totalQuanty;
    }

    @Override
    public Long totalPrice(HashMap<Long, CartDTO> cart) {
        Long totalPrice = Long.valueOf(0);
        for (Map.Entry<Long, CartDTO> itemCart : cart.entrySet()) {
            totalPrice += itemCart.getValue().getTotalPrice();
        }
        return totalPrice;
    }
}
