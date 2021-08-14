package com.ltc.repo;

import com.ltc.dto.ProductDTO;
import com.ltc.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface ProductRepo extends BaseRepository<Product,Long>, ProductRepoCustom{

    Page<Product> findAllByCategories_Id(Long categoryId, Pageable page);

    Page<Product> findByProductNameContaining(String productName, Pageable page);

    Page<Product> findAllByDeleted(Boolean deleted, Pageable page);

    Product findById(Long productId);
}
