package com.ltc.services;

import com.ltc.dto.OrderDTO;
import com.ltc.dto.OrderProductDTO;
import com.ltc.model.Product;

import java.util.List;

public interface OrderDetailServices{
    public List<OrderProductDTO> saveOrUpdate(List<OrderProductDTO> orderProductDTO, String username, OrderDTO orderDTO) throws Exception;

}
