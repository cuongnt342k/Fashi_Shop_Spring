package com.ltc.dto;

import com.ltc.model.Order;
import com.ltc.model.Product;

public class OrderProductDTO extends BaseDTO{
    private Integer quantity;

    private Long total;

    private Order order;

    private Product product;

    public Order getOrder() {
        return order;
    }

    public Product getProduct() {
        return product;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

}
