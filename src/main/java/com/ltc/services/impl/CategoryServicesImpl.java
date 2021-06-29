package com.ltc.services.impl;

import com.ltc.dto.CategoriesDTO;
import com.ltc.dto.ProductDTO;
import com.ltc.model.Categories;
import com.ltc.model.Product;
import com.ltc.repo.CategoryRepo;
import com.ltc.services.CategoryServices;
import com.ltc.utils.BaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServicesImpl implements CategoryServices {

    @Autowired
    CategoryRepo categoryRepo;

    private BaseMapper<Categories, CategoriesDTO> mapper = new BaseMapper<>(Categories.class, CategoriesDTO.class);

    @Override
    public List<CategoriesDTO> getAllCategory(Pageable pageable) throws Exception {
        List<Categories> categories= categoryRepo.findAll();
        return mapper.toDtoBean(categories);
    }
}
