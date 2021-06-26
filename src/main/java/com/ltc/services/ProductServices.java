package com.ltc.services;


import com.ltc.dto.ProductDTO;
import com.ltc.model.Product;

import java.util.List;

public interface ProductServices {
    List<ProductDTO> findAllProduct() throws Exception;
}
