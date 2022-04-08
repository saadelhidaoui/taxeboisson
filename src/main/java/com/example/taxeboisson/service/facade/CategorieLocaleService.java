package com.example.taxeboisson.service.facade;

import com.example.taxeboisson.bean.CategorieLocale;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CategorieLocaleService {
    CategorieLocale findByRef(String ref);

    List<CategorieLocale> findAll();

    @Transactional
    int deleteByRef(String ref);

    int save(CategorieLocale categorieLocale);
}
