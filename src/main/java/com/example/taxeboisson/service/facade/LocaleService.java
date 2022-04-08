package com.example.taxeboisson.service.facade;

import com.example.taxeboisson.bean.Locale;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface LocaleService {
    Locale findByRef(String ref);

    @Transactional
    int deleteByRef(String ref);

    Locale findByAdresse(String adresse);

    Locale findBySecteurCode(String code);

    @Transactional
    int deleteBySecteurCode(String code);

    Locale findByRedevableCin(String cin);

    @Transactional
    int deleteByRedevableCin(String cin);

    List<Locale> findByCategorielocaleRef(String ref);
}
