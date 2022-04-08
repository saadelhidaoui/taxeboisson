package com.example.taxeboisson.service.impl;

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


    @Override
    public Secteur findByLibelle(String libelle) {
        return secteurDao.findByLibelle(libelle);
    }

    @Override
    public int deleteByLibelle(String libelle) {
        return secteurDao.deleteByLibelle(libelle);
    }

    @Override
    public Secteur findByCode(String code) {
        return secteurDao.findByCode(code);
    }

    @Transactional
    @Override
    public int deleteByCode(String code) {
        int resultLocale = localeService.deleteBySecteurCode(code);
        int resultSecteur = secteurDao.deleteByCode(code);
        return resultLocale + resultSecteur;
    }

    @Override
    public List<Secteur> findAll() {
        return secteurDao.findAll();
    }

    @Override
    public int save(Secteur secteur) {
        if (findByCode(secteur.getCode()) != null) {
            return -1;
        } else {
            secteurDao.save(secteur);
            return 1;
        }
    }


    @Autowired
    SecteurDao secteurDao;

    @Autowired
    LocaleService localeService;


}
