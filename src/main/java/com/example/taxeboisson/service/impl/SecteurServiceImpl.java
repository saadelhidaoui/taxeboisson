package com.example.taxeboisson.service.impl;

import java.util.List;

import com.example.taxeboisson.bean.Secteur;
import com.example.taxeboisson.dao.SecteurDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SecteurServiceImpl {

    @Autowired
    SecteurDao secteurDao;

    @Autowired
    LocaleServiceImpl localeService;

    public Secteur findByLibelle(String libelle) {
        return secteurDao.findByLibelle(libelle);
    }

    public int deleteByLibelle(String libelle) {
        return secteurDao.deleteByLibelle(libelle);
    }

    public Secteur findByCode(String code) {
        return secteurDao.findByCode(code);
    }

    @Transactional
    public int deleteByCode(String code) {
        int resultLocale =localeService.deleteBySecteurCode(code);
        int resultSecteur = secteurDao.deleteByCode(code);
        return resultLocale+resultSecteur;
    }

    public List<Secteur> findAll() {
        return secteurDao.findAll();
    }

    public int save(Secteur secteur) {
        if(findByCode(secteur.getCode()) != null) {
            return -1;
        }else {
            secteurDao.save(secteur);
            return 1;
        }
    }





}
