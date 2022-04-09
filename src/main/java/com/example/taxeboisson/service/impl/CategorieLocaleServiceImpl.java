package com.example.taxeboisson.service.impl;

import com.example.taxeboisson.bean.CategorieLocale;
import com.example.taxeboisson.dao.CategorieLocaleDao;
import com.example.taxeboisson.service.facade.CategorieLocaleService;
import com.example.taxeboisson.service.facade.LocaleService;
import com.example.taxeboisson.service.facade.TauxTaxeBoissonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CategorieLocaleServiceImpl implements CategorieLocaleService {
    @Autowired
    private CategorieLocaleDao categorieLocaleDao;
    @Autowired
    private TauxTaxeBoissonService tauxTaxeBoissonService;
    @Autowired
    LocaleService localService;

    @Override
    public CategorieLocale findByRef(String ref) {
        return categorieLocaleDao.findByRef(ref);
    }

    @Override
    public List<CategorieLocale> findAll() {
        return categorieLocaleDao.findAll();
    }

    @Transactional
    @Override
    public int deleteByRef(String ref) {
        int res1 = localService.deleteByCategorielocaleRef(ref);
        int res2 = categorieLocaleDao.deleteByRef(ref);
        return res1 + res2;
    }

    public CategorieLocale findByDescription(String description) {
        return categorieLocaleDao.findByDescription(description);
    }

    @Override
    public int save(CategorieLocale categorieLocale) {
        if (findByRef(categorieLocale.getRef()) != null) {
            return -1;
        }if (findByDescription(categorieLocale.getDescription()) != null) {
            return -2;
        } else {
            categorieLocaleDao.save(categorieLocale);
            return 1;
        }

    }



}
