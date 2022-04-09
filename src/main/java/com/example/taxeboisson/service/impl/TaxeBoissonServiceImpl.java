package com.example.taxeboisson.service.impl;

import com.example.taxeboisson.bean.Locale;
import com.example.taxeboisson.bean.Redevable;
import com.example.taxeboisson.bean.TauxTaxeBoisson;
import com.example.taxeboisson.bean.TaxeBoisson;
import com.example.taxeboisson.dao.TaxeBoissonDao;
import com.example.taxeboisson.service.facade.LocaleService;
import com.example.taxeboisson.service.facade.RedevableService;
import com.example.taxeboisson.service.facade.TauxTaxeBoissonService;
import com.example.taxeboisson.service.facade.TaxeBoissonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Calendar;
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
    public TaxeBoisson findByRedevableCin(String cin) {
        return taxeBoissonDao.findByRedevableCin(cin);
    }
    @Override
    @Transactional
    public int deleteByRedevableCin(String cin) {
        return taxeBoissonDao.deleteByRedevableCin(cin);
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
//    public int save(TaxeBoisson taxeBoisson) {
//        if (findByRef(taxeBoisson.getRef()) != null) {
//            return -1;
//        } else if (taxeBoisson.getChiffreAffaire() <= 0) {
//            return -2;
//        } else {
//            taxeBoissonDao.save(taxeBoisson);
//            return 1;
//        }
//    }
    public int save(TaxeBoisson taxeBoisson) {
        Locale locale = localeService.findByRef(taxeBoisson.getLocale().getRef());
        taxeBoisson.setLocale(locale);

        Redevable redevable = redevableService.findByCin(taxeBoisson.getRedevable().getCin());
        taxeBoisson.setRedevable(redevable);

        int anneeActuelle = Calendar.getInstance().get(Calendar.YEAR);

        if (taxeBoisson.getAnnee() > anneeActuelle) {
            return -1;
        } else if (taxeBoisson.getChiffreAffaire() <= 0) {
            return -2;
        } else if (findByLocaleRefAndTrimAndAnnee(taxeBoisson.getLocale().getRef(), taxeBoisson.getTrim(), taxeBoisson.getAnnee()) != null) {
            return -3;
        } else if (locale == null) {
            return -4;
        } else if (redevable == null) {
            return -5;
        } else {
            TauxTaxeBoisson t = tauxTaxeBoissonService.findByCategorieLocaleRef(taxeBoisson.getLocale().getCategorieLocale().getRef());
            taxeBoisson.setPourcentageApplique(t.getPourcentage());
            double mtb = taxeBoisson.getPourcentageApplique() * taxeBoisson.getChiffreAffaire();
            taxeBoisson.setMontantBase(mtb);
            taxeBoissonDao.save(taxeBoisson);
            return 1;

        }
    }
    @Autowired
     TauxTaxeBoissonService tauxTaxeBoissonService;

    @Autowired
     TaxeBoissonDao taxeBoissonDao;
    @Autowired
    LocaleService localeService;
    @Autowired
    RedevableService redevableService;

}
