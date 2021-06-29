package com.ltc.services;


import com.ltc.dto.ProductDTO;
import com.ltc.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductServices {
    Page<Product> getAllProduct(Pageable pageable) throws Exception;

    Page<Product> findProductByCategory(Long categoryId, Pageable pageable) throws Exception;

    int getTotalItem();
}
