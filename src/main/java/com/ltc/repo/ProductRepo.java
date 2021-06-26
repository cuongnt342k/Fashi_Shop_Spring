package com.ltc.repo;

import com.ltc.model.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface ProductRepo extends BaseRepository<Product,Long>, ProductRepoCustom{

//    @Query(value = "select * from product where  category_id = ?1 and is_deleted = false", nativeQuery = true)
//    public List<Product> getProductByCategory(Long categoryId) throws Exception;

}
