package com.example.taxeboisson.service.facade;

import com.example.taxeboisson.bean.Locale;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface LocaleService {
    Locale findByRef(String ref);

    @Transactional
    int deleteByRef(String ref);

    List<Locale>  findByAdresse(String adresse);

    List<Locale>  findBySecteurCode(String code);

    @Transactional
    int deleteBySecteurCode(String code);

    List<Locale>  findByRedevableCin(String cin);

    @Transactional
    int deleteByRedevableCin(String cin);

    List<Locale>  findByCategorieLocaleRef(String ref);


    @Transactional
    int deleteByCategorielocaleRef(String ref);

    List<Locale> findAll();

    int save(Locale locale);
}
