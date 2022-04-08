package com.example.taxeboisson.service;

import com.example.taxeboisson.bean.Locale;
import com.example.taxeboisson.bean.Redevable;
import com.example.taxeboisson.bean.TauxTaxeBoisson;
import com.example.taxeboisson.bean.TaxeBoisson;
import com.example.taxeboisson.dao.TaxeBoissonDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Calendar;
import java.util.List;


import org.springframework.transaction.annotation.Transactional;



@Service
public class TaxeBoissonService {
    @Autowired
    TauxTaxeBoissonService tauxTaxeBoissonService;
    @Autowired
    private TaxeBoissonDao taxeBoissonDao;

    @Autowired
    LocaleService localeService;

    @Autowired
    RedevableService redevableService;



    public TaxeBoisson findByRedevableCin(String cin) {
        return taxeBoissonDao.findByRedevableCin(cin);
    }
    @Transactional
    public int deleteByRedevableCin(String cin) {
        return taxeBoissonDao.deleteByRedevableCin(cin);
    }

    @Transactional
    public int deleteByRef(String ref) {
        return taxeBoissonDao.deleteByRef(ref);
    }

    public TaxeBoisson findByRef(String ref) {
        return taxeBoissonDao.findByRef(ref);
    }

    @Transactional
    public int deleteByTypeRedevableCode(String code) {
        return taxeBoissonDao.deleteByTypeRedevableCode(code);
    }

    public TaxeBoisson findByLocaleRef(String ref) {
        return taxeBoissonDao.findByLocaleRef(ref);
    }
    @Transactional
    public int deleteByLocaleRef(String ref) {
        return taxeBoissonDao.deleteByLocaleRef(ref);
    }

    @Transactional
    public int deleteByLocaleSecteurCode(String code) {
        return taxeBoissonDao.deleteByLocaleSecteurCode(code);
    }


    @Transactional
    public int deleteByCategorielocaleRef(String ref) {
        return taxeBoissonDao.deleteByCategorielocaleRef(ref);
    }

    public TaxeBoisson findByLocaleRefAndTrimAndAnnee(String ref, double trim, double annee) {
        return taxeBoissonDao.findByLocaleRefAndTrimAndAnnee(ref, trim, annee);
    }
    public List<TaxeBoisson> findAll() {
        return taxeBoissonDao.findAll();
    }

    public int save(TaxeBoisson taxeBoisson) {
        Locale locale = localeService.findByRef(taxeBoisson.getLocale().getRef());
        taxeBoisson.setLocale(locale);

        Redevable redevable = redevableService.findByCin(taxeBoisson.getRedevable().getCin());
        taxeBoisson.setRedevable(redevable);

        int anneeActuelle = Calendar.getInstance().get(Calendar.YEAR);

        if(taxeBoisson.getAnnee()>anneeActuelle) {return -1;}
        else if(taxeBoisson.getChiffreAffaire()<=0) {return -2;}
        else if(findByLocaleRefAndTrimAndAnnee(taxeBoisson.getLocale().getRef(), taxeBoisson.getTrim(), taxeBoisson.getAnnee())!=null) {
            return -3;}

        else if(locale==null) {return -4;}
        else if(redevable==null) {return -5;}
        else {
            TauxTaxeBoisson t = tauxTaxeBoissonService.findByCategorieLocaleRef(taxeBoisson.getLocale().getCategorieLocale().getRef());
            taxeBoisson.setPourcentageApplique(t.getPourcentage());
            double mtb = taxeBoisson.getPourcentageApplique()*taxeBoisson.getChiffreAffaire();
            taxeBoisson.setMontantBase(mtb);
            taxeBoissonDao.save(taxeBoisson);
            return 1 ;

        }

    }









}
