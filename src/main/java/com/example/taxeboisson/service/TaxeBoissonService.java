package com.example.taxeboisson.service;

import com.example.taxeboisson.bean.TaxeBoisson;
import com.example.taxeboisson.dao.TaxeBoissonDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaxeBoissonService {
    @Autowired
    private TauxTaxeBoissonService tauxTaxeBoissonService;
    @Autowired
    private TaxeBoissonDao taxeBoissonDao;

    public TaxeBoisson findByRef(String ref) {
        return taxeBoissonDao.findByRef(ref);
    }

    public TaxeBoisson findByLocaleRef(String ref) {
        return taxeBoissonDao.findByLocaleRef(ref);
    }

    public int deleteByLocaleRef(String ref) {
        return taxeBoissonDao.deleteByLocaleRef(ref);
    }

    public int deleteByCategorielocaleRef(String ref) {
        return taxeBoissonDao.deleteByCategorielocaleRef(ref);
    }

    public int deleteByTypeRedevableCode(String code) {
        return taxeBoissonDao.deleteByTypeRedevableCode(code);
    }

    public TaxeBoisson findByLocaleRefAndTrimAndAnnee(String ref, double trim, double annee) {
        return taxeBoissonDao.findByLocaleRefAndTrimAndAnnee(ref, trim, annee);
    }

    public int deleteByRef(String ref) {
        return taxeBoissonDao.deleteByRef(ref);
    }

    public TaxeBoisson findByRedevableRef(String ref) {
        return taxeBoissonDao.findByRedevableRef(ref);
    }

    public int deleteByRedevableRef(String ref) {
        return taxeBoissonDao.deleteByRedevableRef(ref);
    }

    public List<TaxeBoisson> findAll() {
        return taxeBoissonDao.findAll();
    }

    public int save(TaxeBoisson taxeBoisson) {
        if(findByRef(taxeBoisson.getRef()) != null) {return -1;}
        else if(taxeBoisson.getChiffreAffaire()<=0) {return -2;}
        else {
            taxeBoissonDao.save(taxeBoisson);
            return 1;
        }
    }
}
