package com.example.taxeboisson.service.facade;

import com.example.taxeboisson.bean.Locale;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface LocaleService {
    Locale findByRef(String ref);


    /******            Get             ******/
    List<Locale> findByAdresse(String adresse);

    List<Locale> findByCategorieLocaleRef(String ref);

    List<Locale> findBySecteurCode(String code);

    List<Locale> findByRedevableCin(String cin);

    List<Locale> findAll();

    /******            delete          ******/
    @Transactional
    int deleteByRef(String ref);

    @Transactional
    int deleteBySecteurCode(String code);

    @Transactional
    int deleteByRedevableCin(String cin);

    @Transactional
    int deleteByCategorielocaleRef(String ref);

    /******            Post          ******/
    int save(Locale locale);

    void update(Locale locale);

    List<Locale> findBySecteurLibelle(String libelle);
}
