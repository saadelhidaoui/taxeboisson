package com.example.taxeboisson.service.impl;

import com.example.taxeboisson.bean.TaxeBoisson;
import com.example.taxeboisson.dao.TaxeBoissonDao;
import com.example.taxeboisson.service.facade.TauxTaxeBoissonService;
import com.example.taxeboisson.service.facade.TaxeBoissonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TaxeBoissonServiceImpl implements TaxeBoissonService {

    @Override
    public TaxeBoisson findByRef(String ref) {
        return taxeBoissonDao.findByRef(ref);
    }

    @Override
    public TaxeBoisson findByLocaleRef(String ref) {
        return taxeBoissonDao.findByLocaleRef(ref);
    }

    @Override
    @Transactional
    public int deleteByLocaleRef(String ref) {
        return taxeBoissonDao.deleteByLocaleRef(ref);
    }

    @Override
    public TaxeBoisson findByLocaleRefAndTrimAndAnnee(String ref, double trim, double annee) {
        return taxeBoissonDao.findByLocaleRefAndTrimAndAnnee(ref, trim, annee);
    }

    @Override
    @Transactional
    public int deleteByRef(String ref) {
        return taxeBoissonDao.deleteByRef(ref);
    }

    @Override
    public List<TaxeBoisson> findAll() {
        return taxeBoissonDao.findAll();
    }

    @Override
    public int save(TaxeBoisson taxeBoisson) {
        if (findByRef(taxeBoisson.getRef()) != null) {
            return -1;
        } else if (taxeBoisson.getChiffreAffaire() <= 0) {
            return -2;
        } else {
            taxeBoissonDao.save(taxeBoisson);
            return 1;
        }
    }

    @Autowired
    private TauxTaxeBoissonService tauxTaxeBoissonService;

    @Autowired
    private TaxeBoissonDao taxeBoissonDao;

}
