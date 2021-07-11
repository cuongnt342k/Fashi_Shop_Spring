package com.ltc.services;

import com.ltc.dto.OrderDTO;
import com.ltc.dto.OrderProductDTO;
import com.ltc.model.Order;

import java.util.List;

public interface CheckOutServices {
    public List<Order> getOrderByUserName(Long userId, Integer status);

    public OrderDTO saveOrUpdate(OrderDTO orderDTO, String username, List<OrderProductDTO> orderProductDTO) throws Exception;

    public void deleteOrder(List<Long> orderId, String username) throws Exception;
}
