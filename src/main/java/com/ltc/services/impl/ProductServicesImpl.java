package com.ltc.services.impl;

import com.ltc.dto.ProductDTO;
import com.ltc.model.Product;
import com.ltc.repo.ProductRepo;
import com.ltc.services.ProductServices;
import com.ltc.utils.BaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServicesImpl implements ProductServices {

    @Autowired
    private ProductRepo productRepo;

    private BaseMapper<Product, ProductDTO> mapper = new BaseMapper<>(Product.class, ProductDTO.class);

    @Override
    public List<ProductDTO> findAllProduct() throws Exception {
        List<Product> products= productRepo.findAll();
//        List<Product> products= new ArrayList<>();
        return mapper.toDtoBean(products);
//        return null;
    }

}
