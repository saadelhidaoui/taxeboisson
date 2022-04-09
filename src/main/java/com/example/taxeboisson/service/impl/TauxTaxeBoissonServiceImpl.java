package com.example.taxeboisson.service.impl;

import com.example.taxeboisson.bean.CategorieLocale;
import com.example.taxeboisson.bean.TauxTaxeBoisson;
import com.example.taxeboisson.dao.TauxTaxeBoissonDao;
import com.example.taxeboisson.service.facade.CategorieLocaleService;
import com.example.taxeboisson.service.facade.TauxTaxeBoissonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TauxTaxeBoissonServiceImpl implements TauxTaxeBoissonService {
    @Autowired
    private TauxTaxeBoissonDao tauxTaxeBoissonDao;

    @Autowired
    private CategorieLocaleService categorieLocaleService;

    @Override
    public TauxTaxeBoisson findByCategorieLocaleRef(String ref) {
        return tauxTaxeBoissonDao.findByCategorieLocaleRef(ref);
    }

    @Override
    @Transactional
    public int deleteByCategorieLocaleRef(String ref) {
        return tauxTaxeBoissonDao.deleteByCategorieLocaleRef(ref);
    }


    @Override
    public TauxTaxeBoisson findByRef(String ref) {
        return tauxTaxeBoissonDao.findByRef(ref);
    }

    @Override
    public List<TauxTaxeBoisson> findByPourcentage(double pourcentage) {
        return tauxTaxeBoissonDao.findByPourcentage(pourcentage);
    }

    @Override
    public List<TauxTaxeBoisson> findAll() {
        return tauxTaxeBoissonDao.findAll();
    }

    @Override
    public int save(TauxTaxeBoisson tauxTaxeBoisson) {
        if (findByRef(tauxTaxeBoisson.getRef()) != null) {
            return -1;
        } else if (tauxTaxeBoisson.getPourcentage() <= 0) {
            return -2;
        } else {
            CategorieLocale categorieLocale= categorieLocaleService.findByRef(tauxTaxeBoisson.getCategorieLocale().getRef());
            tauxTaxeBoisson.setCategorieLocale(categorieLocale);
            tauxTaxeBoissonDao.save(tauxTaxeBoisson);
            return 1;
        }

    }

    @Override
    public int updatePourcentage(String ref, double nouveaupr) {
        TauxTaxeBoisson tauxTaxeBoisson;
        tauxTaxeBoisson = findByRef(ref);

        if (tauxTaxeBoisson != null) {
            tauxTaxeBoisson.setPourcentage(nouveaupr);
            tauxTaxeBoissonDao.save(tauxTaxeBoisson);
            return 1;
        } else return -1;
    }



}
