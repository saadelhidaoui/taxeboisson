package com.example.taxeboisson.service.impl;

import com.example.taxeboisson.bean.TauxTaxeBoisson;
import com.example.taxeboisson.dao.TauxTaxeBoissonDao;
import com.example.taxeboisson.service.facade.TauxTaxeBoissonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TauxTaxeBoissonServiceImpl implements TauxTaxeBoissonService {

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
        } else return 0;
    }

    @Override
    public TauxTaxeBoisson findByCategorieLocaleRef(String ref) {
        return tauxTaxeBoissonDao.findByCategorieLocaleRef(ref);
    }

    @Override
    @Transactional
    public int deleteByCategorieLocaleRef(String ref) {
        return tauxTaxeBoissonDao.deleteByCategorieLocaleRef(ref);
    }

    @Autowired
    private TauxTaxeBoissonDao tauxTaxeBoissonDao;


}
