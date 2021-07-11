package com.ltc.repo;

import com.ltc.model.Order;

import java.util.List;

public interface CheckOutRepo extends BaseRepository<Order,Long>{
    public List<Order> findByUserIdAndStatus(Long userId, Integer status);

    public Order findById(Long orderId);
}
