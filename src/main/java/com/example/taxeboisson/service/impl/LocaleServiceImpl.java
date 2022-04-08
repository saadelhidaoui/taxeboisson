package com.example.taxeboisson.service.impl;

import java.util.List;

import com.example.taxeboisson.bean.CategorieLocale;
import com.example.taxeboisson.bean.Locale;
import com.example.taxeboisson.bean.Redevable;
import com.example.taxeboisson.bean.Secteur;
import com.example.taxeboisson.dao.LocaleDao;
import com.example.taxeboisson.service.facade.LocaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class LocaleServiceImpl implements LocaleService {
    @Override
    public Locale findByRef(String ref) {
        return localeDao.findByRef(ref);
    }

    @Transactional
    @Override
    public int deleteByRef(String ref) {
        return localeDao.deleteByRef(ref);
    }

    @Override
    public Locale findByAdresse(String adresse) {
        return localeDao.findByAdresse(adresse);
    }

    @Override
    public Locale findBySecteurCode(String code) {
        return localeDao.findBySecteurCode(code);
    }

    @Transactional
    @Override
    public int deleteBySecteurCode(String code) {
        return localeDao.deleteBySecteurCode(code);
    }

    @Override
    public Locale findByRedevableCin(String cin) {
        return localeDao.findByRedevableCin(cin);
    }

    @Transactional
    @Override
    public int deleteByRedevableCin(String cin) {
        return localeDao.deleteByRedevableCin(cin);
    }

    @Override
    public List<Locale> findByCategorielocaleRef(String ref) {
        return localeDao.findByCategorieLocaleRef(ref);
    }

    @Transactional
    public int deleteByCategorieLocaleRef(String ref) {
        return localeDao.deleteByCategorieLocaleRef(ref);
    }

    public List<Locale> findAll() {
        return localeDao.findAll();
    }

    public int save(Locale locale) {
        Secteur secteur = secteurService.findByCode(locale.getSecteur().getCode());
        locale.setSecteur(secteur);
        Redevable redevable = redevableService.findByCin(locale.getRedevable().getCin());
        locale.setRedevable(redevable);
        CategorieLocale categorielocale = categorielocaleServiceImpl.findByRef(locale.getCategorielocale().getRef());
        locale.setCategorielocale(categorielocale);
        if(findByRef(locale.getRef()) != null) {
            return -1;
        }else if(secteur == null) {
            return -2;
        }else if(redevable == null) {
            return -3;
        }else {
            localeDao.save(locale);
            return 1;
        }
    }



    @Autowired
    LocaleDao localeDao;
    @Autowired
    SecteurServiceImpl secteurService;
    @Autowired
    RedevableServiceImpl redevableService;
    @Autowired
    CategorieLocaleServiceImpl categorielocaleServiceImpl;
    @Autowired
    TaxeBoissonServiceImpl taxeBoissonService;

}
