package com.example.taxeboisson.service;

import java.util.List;

import com.example.taxeboisson.bean.CategorieLocale;
import com.example.taxeboisson.bean.Locale;
import com.example.taxeboisson.bean.Redevable;
import com.example.taxeboisson.bean.Secteur;
import com.example.taxeboisson.dao.LocaleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class LocaleService {
    @Autowired
    LocaleDao localeDao;
    @Autowired
    SecteurService secteurService;
    @Autowired
    RedevableService redevableService;
    @Autowired
    CategorielocaleService categorielocaleService;
    @Autowired
    TaxeBoissonService taxeBoissonService;


    public Locale findByRef(String ref) {
        return localeDao.findByRef(ref);
    }

    @Transactional
    public int deleteByRef(String ref) {
        return localeDao.deleteByRef(ref);
    }

    public Locale findByAdresse(String adresse) {
        return localeDao.findByAdresse(adresse);
    }

    public Locale findBySecteurCode(String code) {
        return localeDao.findBySecteurCode(code);
    }

    @Transactional
    public int deleteBySecteurCode(String code) {
        return localeDao.deleteBySecteurCode(code);
    }

    public Locale findByRedevableRef(String ref) {
        return localeDao.findByRedevableRef(ref);
    }

    @Transactional
    public int deleteByRedevableRef(String ref) {
        return localeDao.deleteByRedevableRef(ref);
    }

    public List<Locale> findByCategorielocaleRef(String ref) {
        return localeDao.findByCategorielocaleRef(ref);
    }

    @Transactional
    public int deleteByCategorielocaleRef(String ref) {
        return localeDao.deleteByCategorielocaleRef(ref);
    }



    public List<Locale> findAll() {
        return localeDao.findAll();
    }

    public int save(Locale locale) {
        Secteur secteur = secteurService.findByCode(locale.getSecteur().getCode());
        locale.setSecteur(secteur);
        Redevable redevable = redevableService.findByRef(locale.getRedevable().getRef());
        locale.setRedevable(redevable);
        CategorieLocale categorielocale = categorielocaleService.findByRef(locale.getCategorielocale().getRef());
        locale.setCategorielocale(categorielocale);
        if(findByRef(locale.getRef()) != null) {
            return -1;
        }else if(secteur == null) {
            return -2;
        }else if(redevable == null) {
            return -3;
        }else if(categorielocale==null) {
            return -4;
        }else {
            localeDao.save(locale);
            return 1;
        }
    }
}
