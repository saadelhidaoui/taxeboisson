package com.example.taxeboisson.service.facade;

import com.example.taxeboisson.bean.CategorieLocale;
import org.springframework.transaction.annotation.Transactional;

public interface CategorieLocaleService {
    @Transactional
    int deleteByRef(String ref);

    int save(CategorieLocale categorieLocale);
}
