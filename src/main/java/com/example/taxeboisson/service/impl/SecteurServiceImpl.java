package com.example.taxeboisson.service.impl;

import com.example.taxeboisson.bean.Locale;
import com.example.taxeboisson.bean.Secteur;
import com.example.taxeboisson.dao.SecteurDao;
import com.example.taxeboisson.service.facade.LocaleService;
import com.example.taxeboisson.service.facade.SecteurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SecteurServiceImpl implements SecteurService {
    /******            DAO          ******/
    @Autowired
    private SecteurDao secteurDao;
    /******            Service         ******/

    @Autowired
    private LocaleService localeService;

/***************    Delete Methods     ****************/

    @Override
    @Transactional
    public int deleteByLibelle(String libelle) {

        List<Locale> locales= localeService.findBySecteurLibelle(libelle);
        for (Locale locale : locales) {
            locale.setSecteur(null);
            localeService.update(locale);
        }
        return secteurDao.deleteByLibelle(libelle);
    }

    @Transactional
    @Override
    public int deleteByCode(String code) {

        List<Locale> locales= localeService.findBySecteurCode(code);
        for (Locale locale : locales) {
            locale.setSecteur(null);
            localeService.update(locale);
        }
        return localeService.deleteBySecteurCode(code) ;
    }

/***************    Post Methods     ****************/

    @Override
    public int save(Secteur secteur) {
        if (findByCode(secteur.getCode()) != null) {
            return -1;
        }if (findByCode(secteur.getLibelle()) != null) {
            return -2;
        } else {
            secteurDao.save(secteur);
            return 1;
        }
    }
/***************    Get Methods     ****************/

    @Override
    public Secteur findByLibelle(String libelle) {
        return secteurDao.findByLibelle(libelle);
    }

    @Override
    public Secteur findByCode(String code) {
        return secteurDao.findByCode(code);
    }

    @Override
    public List<Secteur> findAll() {
        return secteurDao.findAll();
    }

}
