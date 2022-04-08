package com.example.taxeboisson.service;

import com.example.taxeboisson.bean.CategorieLocale;
import com.example.taxeboisson.dao.CategorieLocaleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CategorielocaleService {
    @Autowired
    private CategorieLocaleDao categorieLocaleDao;
    @Autowired
    private TauxTaxeBoissonService tauxTaxeBoissonService;
    @Autowired
    LocaleService localService;

    public CategorieLocale findByRef(String ref) {
        return categorieLocaleDao.findByRef(ref);
    }
    public List<CategorieLocale> findAll() {
        return categorieLocaleDao.findAll();
    }

    @Transactional
    public int deleteByRef(String ref) {
        int res1 = localService.deleteByCategorielocaleRef(ref);
        int res2 = categorieLocaleDao.deleteByRef(ref);
        return res1 + res2;
    }

    public int save( CategorieLocale  categorieLocale){
        if(findByRef(categorieLocale.getRef() ) != null){
            return -1;
        }
        else {
            categorieLocaleDao.save(categorieLocale);
            return 1;
        }

    }
}
