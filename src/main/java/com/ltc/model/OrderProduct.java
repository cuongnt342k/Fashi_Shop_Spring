package com.ltc.model;

import javax.persistence.*;

@Entity
@Table(name = "order_product")
public class OrderProduct extends BaseModel{
    private Integer quantity;

    private Long total;

    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Product product = new Product();

    @ManyToOne
    @JoinColumn(name = "order_id", referencedColumnName = "id")
    Order order = new Order();

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
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
