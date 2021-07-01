package com.ltc.services.impl;

import com.ltc.dto.ProductDTO;
import com.ltc.model.Product;
import com.ltc.repo.ProductRepo;
import com.ltc.services.ProductServices;
import com.ltc.utils.BaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServicesImpl implements ProductServices {

    @Autowired
    private ProductRepo productRepo;

    private BaseMapper<Product, ProductDTO> mapper = new BaseMapper<>(Product.class, ProductDTO.class);

    @Override
    public Page<Product> getAllProduct(Pageable pageable) throws Exception {
//        productRepo.findAll(pageable).getContent();
//        List<Product> products= new ArrayList<>();
        return productRepo.findAll(pageable);
//        return null;
    }

    @Override
    public Page<Product> findProductByCategory(Long categoryId, Pageable pageable) throws Exception {
//        List<Product> products= productRepo.findAllByCategories_Id(categoryId, pageable);
        return productRepo.findAllByCategories_Id(categoryId,pageable);
    }

    @Override
    public Page<Product> findProductName(String productName, Pageable pageable) throws Exception {
        return productRepo.findByProductNameContaining(productName,pageable);
    }

    @Override
    public Product findProductById(Long productId) throws Exception {
        return productRepo.findById(productId);
    }


}
