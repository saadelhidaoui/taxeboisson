package com.example.taxeboisson.service.impl;

import com.example.taxeboisson.bean.CategorieLocale;
import com.example.taxeboisson.bean.Locale;
import com.example.taxeboisson.bean.Redevable;
import com.example.taxeboisson.bean.Secteur;
import com.example.taxeboisson.dao.LocaleDao;
import com.example.taxeboisson.service.facade.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class LocaleServiceImpl implements LocaleService {

    /******            DAO          ******/

    @Autowired
    private LocaleDao localeDao;

    /******            Services          ******/
    @Autowired
    private SecteurService secteurService;
    @Autowired
    private RedevableService redevableService;
    @Autowired
    private CategorieLocaleService categorieLocaleServic;


/***************    Put Methods     ****************/

    @Override
    public void update(Locale locale) {

        if (findByRef(locale.getRef()) != null) {
            localeDao.save(locale);
        }

    }

/***************    Post Methods     ****************/

    @Override
    public int save(Locale locale) {
        prepareLocale(locale);
        int res = validateLocale(locale);

        if (res < 0) {
            return res;
        } else {
            localeDao.save(locale);
            return 1;
        }
    }

/****************       Delete Methods          **************/
    @Transactional
    @Override
    public int deleteByRef(String ref) {
        return localeDao.deleteByRef(ref);
    }

    @Transactional
    @Override
    public int deleteBySecteurCode(String code) {
        return localeDao.deleteBySecteurCode(code);
    }

    @Transactional
    @Override
    public int deleteByRedevableCin(String cin) {
        return localeDao.deleteByRedevableCin(cin);
    }

    @Transactional
    @Override
    public int deleteByCategorielocaleRef(String ref) {
        return localeDao.deleteByCategorieLocaleRef(ref);
    }


/**     Get Methods     **/
    @Override
    public Locale findByRef(String ref) {
        return localeDao.findByRef(ref);
    }

    @Override
    public List<Locale> findByAdresse(String adresse) {
        return localeDao.findByAdresse(adresse);
    }

    @Override
    public List<Locale> findBySecteurCode(String code) {
        return localeDao.findBySecteurCode(code);
    }

    @Override
    public List<Locale> findByRedevableCin(String cin) {
        return localeDao.findByRedevableCin(cin);
    }

    @Override
    public List<Locale> findByCategorieLocaleRef(String ref) {
        return localeDao.findByCategorieLocaleRef(ref);
    }

    @Override
    public List<Locale> findBySecteurLibelle(String libelle) {
        return localeDao.deleteBySecteurLibelle(libelle);
    }

    @Override
    public List<Locale> findAll() {
        return localeDao.findAll();
    }


    /***************    validate and prepare     ****************/

    private int validateLocale(Locale locale) {
        if (findByRef(locale.getRef()) != null) {
            return -1;
        } else if (locale.getSecteur() == null) {
            return -2;
        } else if (locale.getRedevable() == null) {
            return -3;
        } else if (locale.getCategorieLocale() == null) {
            return -4;
        } else {

            return 1;
        }
    }

    private void prepareLocale(Locale locale) {
        Secteur secteur = secteurService.findByCode(locale.getSecteur().getCode());
        Redevable redevable = redevableService.findByCin(locale.getRedevable().getCin());
        CategorieLocale categorielocale = categorieLocaleServic.findByRef(locale.getCategorieLocale().getRef());

        locale.setRedevable(redevable);
        locale.setSecteur(secteur);
        locale.setCategorieLocale(categorielocale);
    }


}
