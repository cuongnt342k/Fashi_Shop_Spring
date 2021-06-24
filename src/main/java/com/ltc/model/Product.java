package com.ltc.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "product")
public class Product extends BaseModel {

    @Column(name = "product_id", nullable = false, unique = true)
    private Long productId;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "img")
    private String img;

    @Column(name = "brand")
    private String brand;

    @Column(name = "size")
    private String size;

    @Column(name = "price")
    private Long price;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "categroy_id", referencedColumnName = "id")
    Categories categories = new Categories();

    @OneToMany(mappedBy = "product")
    List<OrderProduct> orderProducts = new ArrayList<>();

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }
}
