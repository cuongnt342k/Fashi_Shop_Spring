package com.ltc.dto;

import com.ltc.model.Categories;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;

public class ProductDTO extends BaseDTO{

    private Long productId;

    @NotBlank
    private String productName;

    private String img;

    @NotBlank
    private String brand;

    @NotNull
    private Long price;

    @NotNull
    private Long salePrice;

    private Long categoriId;

    private String description;

    public Long getProductId() {
        return productId;
    }

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


    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Long getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(Long salePrice) {
        this.salePrice = salePrice;
    }

    public Long getCategoriId() {
        return categoriId;
    }

    public void setCategoriId(Long categoriId) {
        this.categoriId = categoriId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
