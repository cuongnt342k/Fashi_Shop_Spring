package com.ltc.services;

import com.ltc.dto.CategoriesDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CategoryServices {
    List<CategoriesDTO> getAllCategory(Pageable pageable) throws Exception;
}
