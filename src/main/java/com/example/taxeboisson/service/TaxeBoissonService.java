package com.example.taxeboisson.service;

import com.example.taxeboisson.bean.TaxeBoisson;
import com.example.taxeboisson.dao.TaxeBoissonDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.IsoFields;
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


    public TaxeBoisson findByLocaleRefAndTrimAndAnnee(String ref, double trim, double annee) {
        return taxeBoissonDao.findByLocaleRefAndTrimAndAnnee(ref, trim, annee);
    }

    public int deleteByRef(String ref) {
        return taxeBoissonDao.deleteByRef(ref);
    }


    public List<TaxeBoisson> findAll() {
        return taxeBoissonDao.findAll();
    }

    public int save(TaxeBoisson taxeBoisson) {
        if(findByRef(taxeBoisson.getRef()) != null) {return -1;}
        else if(taxeBoisson.getChiffreAffaire()<=0) {return -2;}
        else {

            LocalDate dateNow=LocalDate.now();
            int trim=(dateNow.getMonthValue()/3-1) +1;

            taxeBoisson.setAnnee(dateNow.getYear());
            taxeBoisson.setTrim(trim);

            taxeBoissonDao.save(taxeBoisson);
            return 1;
        }
    }
}
