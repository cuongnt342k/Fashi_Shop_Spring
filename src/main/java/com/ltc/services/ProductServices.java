package com.ltc.services;


import com.ltc.dto.ProductDTO;
import com.ltc.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductServices {
    Page<Product> getAllProduct(Pageable pageable) throws Exception;

    Page<Product> findProductByCategory(Long categoryId, Pageable pageable) throws Exception;

    Page<Product> findProductName(String productName, Pageable pageable) throws Exception;

    Product findProductById(Long productId) throws Exception;

    public ProductDTO saveOrUpdate(ProductDTO productDTO, String username,Long categoryId) throws Exception;

}
