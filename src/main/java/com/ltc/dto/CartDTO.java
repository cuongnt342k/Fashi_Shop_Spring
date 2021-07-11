package com.ltc.dto;

import com.ltc.model.Product;

public class CartDTO extends BaseDTO{
    private int quantity;

    private Long  totalPrice;

    private Product product;

    public CartDTO() {
    }

    public CartDTO(int quantity, Long totalPrice, Product product) {
        this.quantity = quantity;
        this.totalPrice = totalPrice;
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Long getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Long totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
