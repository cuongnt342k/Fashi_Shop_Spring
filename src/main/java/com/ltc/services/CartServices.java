package com.ltc.services;

import com.ltc.dto.CartDTO;

import java.util.HashMap;

public interface CartServices {
    public HashMap<Long, CartDTO> addCart(Long id, int quantity, HashMap<Long, CartDTO> cart);

    public HashMap<Long,CartDTO> editCart(Long id, int quantity, HashMap<Long,CartDTO> cart);

    public HashMap<Long,CartDTO> deleteCart(Long id, HashMap<Long, CartDTO> cart);

    public int totalQuantity(HashMap<Long, CartDTO> cart);

    public double totalPrice(HashMap<Long, CartDTO> cart);
}
