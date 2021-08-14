package com.ltc.services.impl;

import com.ltc.dto.ProductDTO;
import com.ltc.model.Product;
import com.ltc.model.User;
import com.ltc.repo.CategoryRepo;
import com.ltc.repo.ProductRepo;
import com.ltc.services.ProductServices;
import com.ltc.utils.BaseMapper;
import com.ltc.utils.Const;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

@Service
public class ProductServicesImpl implements ProductServices {

    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private CategoryRepo categoryRepo;

    private BaseMapper<Product, ProductDTO> mapper = new BaseMapper<>(Product.class, ProductDTO.class);

    @Override
    public Page<Product> getAllProduct(Pageable pageable, Boolean deleted) throws Exception {
//        productRepo.findAll(pageable).getContent();
//        List<Product> products= new ArrayList<>();
        return productRepo.findAllByDeleted(deleted,pageable);
//        return null;
    }

    @Override
    public Page<Product> findProductByCategory(Long categoryId, Pageable pageable) throws Exception {
//        List<Product> products= productRepo.findAllByCategories_Id(categoryId, pageable);
        return productRepo.findAllByCategories_Id(categoryId, pageable);
    }

    @Override
    public Page<Product> findProductName(String productName, Pageable pageable) throws Exception {
        return productRepo.findByProductNameContaining(productName, pageable);
    }

    @Override
    public Product findProductById(Long productId) throws Exception {
        return productRepo.findById(productId);
    }

    @Override
    public ProductDTO saveOrUpdate(ProductDTO productDTO, String username,Long categoryId) throws Exception {
        boolean isCreate = productDTO.getId() == null ? true : false;
        Date currentDate = new Date();
        if (isCreate) {
            productDTO.setCreatedDate(currentDate);
            productDTO.setCreatedBy(username);
            productDTO.setDeleted(false);
            productDTO.setUpdatedBy(username);
            productDTO.setUpdatedDate(currentDate);
        } else {
            Product product = productRepo.findById(productDTO.getId());
            productDTO.setUpdatedBy(username);
            productDTO.setUpdatedDate(currentDate);
            productDTO.setDeleted(product.getDeleted());
        }
        Product product = new Product();

        BeanUtils.copyProperties(productDTO, product);

        product.setCategories(categoryRepo.findOne(categoryId));

        productRepo.saveAndFlush(product);

        return productDTO;
    }

    @Override
    public void deleteProduct(Long productId, String username) throws Exception {
        Date currentDate = new Date();
        Product product = productRepo.findOne(productId);
        product.setDeleted(true);
        product.setUpdatedBy(username);
        product.setUpdatedDate(currentDate);
        productRepo.save(product);
    }
}
