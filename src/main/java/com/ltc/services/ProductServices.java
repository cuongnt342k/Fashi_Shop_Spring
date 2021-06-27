package com.ltc.services;


import com.ltc.dto.ProductDTO;
import com.ltc.model.Product;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductServices {
    List<ProductDTO> findAllProduct(Pageable pageable) throws Exception;
    int getTotalItem();
}
