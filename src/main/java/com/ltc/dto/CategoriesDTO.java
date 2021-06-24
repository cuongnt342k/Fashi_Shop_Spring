package com.ltc.dto;

import com.ltc.model.Product;

import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

public class CategoriesDTO extends BaseDTO{

    private String categoryName;

    public String getCategoryName() {
        return categoryName;
    }
    private List<Product> products = new ArrayList<>();

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
