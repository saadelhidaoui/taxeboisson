package com.example.taxeboisson.service.facade;

import com.example.taxeboisson.bean.CategorieLocale;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CategorieLocaleService {

    CategorieLocale findByRef(String ref);

    @Transactional
    int deleteByRef(String ref);

    List<CategorieLocale> findAll();

    int save(CategorieLocale categorieLocale);
}
