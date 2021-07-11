package com.ltc.services.impl;

import com.ltc.dto.OrderDTO;
import com.ltc.dto.OrderProductDTO;
import com.ltc.model.Order;
import com.ltc.model.OrderProduct;
import com.ltc.repo.CheckOutRepo;
import com.ltc.repo.OrderDetailsRepo;
import com.ltc.services.CheckOutServices;
import com.ltc.utils.Const;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Service
public class CheckOutServicesImpl implements CheckOutServices {
    @Autowired
    OrderDetailsRepo orderDetailsRepo;

    @Autowired
    CheckOutRepo checkOutRepo;

    @Override
    public List<Order> getOrderByUserName(Long userId, Integer status) {
        return checkOutRepo.findByUserIdAndStatus(userId,status);
    }

    @Override
    public OrderDTO saveOrUpdate(OrderDTO orderDTO, String username, List<OrderProductDTO> orderProductDTOList) throws Exception {

        boolean isCreate = orderDTO.getId() == null ? true : false;

        Date currentDate = new Date();
        if(isCreate){
            orderDTO.setCreatedDate(currentDate);
            orderDTO.setCreatedBy(username);
            orderDTO.setDeleted(false);
            orderDTO.setUpdatedBy(username);
            orderDTO.setUpdatedDate(currentDate);
            orderDTO.setStatus(Const.STATUS.ACTIVCE);
        } else {
            orderDTO.setUpdatedBy(username);
            orderDTO.setUpdatedDate(currentDate);
        }
        Order order = new Order();
        BeanUtils.copyProperties(orderDTO, order);
        List<OrderProduct> orderProducts = new ArrayList<>();
        for (OrderProductDTO orderProductDTO : orderProductDTOList) {
            boolean isCreateDetail = orderProductDTO.getId() == null ? true : false;
            if (isCreateDetail) {
                orderProductDTO.setCreatedDate(currentDate);
                orderProductDTO.setCreatedBy(username);
                orderProductDTO.setDeleted(false);
                orderProductDTO.setOrder(order);
            }else {
                orderProductDTO.setUpdatedBy(username);
                orderProductDTO.setUpdatedDate(currentDate);
            }
            OrderProduct orderProduct = new OrderProduct();
            BeanUtils.copyProperties(orderProductDTO, orderProduct);
            orderProducts.add(orderProduct);
        }
        order.setOrderProducts(orderProducts);

        checkOutRepo.saveAndFlush(order);

        return orderDTO;
    }

    @Override
    public void deleteOrder(List<Long> orderId, String username) throws Exception {
        Date currentDate = new Date();
        List<Order> list = new ArrayList<>();
        for(Long id : orderId) {
            Order order = checkOutRepo.findById(id);
            order.setDeleted(true);
            order.setCreatedBy(username);
            order.setCreatedDate(currentDate);
            list.add(order);
        }
        checkOutRepo.save(list);
    }
}
