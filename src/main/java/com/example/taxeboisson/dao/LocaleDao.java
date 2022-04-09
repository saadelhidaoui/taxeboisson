package com.example.taxeboisson.dao;

import java.util.List;

import com.example.taxeboisson.bean.Locale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface LocaleDao extends JpaRepository<Locale, Long> {
    /******            Get          ******/
    Locale findByRef(String ref);

    List<Locale> findByCategorieLocaleRef(String ref);

    List<Locale> findByAdresse(String adresse);

    List<Locale> findBySecteurCode(String code);

    List<Locale> findByRedevableCin(String cin);

    /******            Delete          ******/
    int deleteByRef(String ref);

    int deleteBySecteurCode(String code);

    int deleteByRedevableCin(String cin);

    int deleteByCategorieLocaleRef(String ref);

    List<Locale> deleteBySecteurLibelle(String libelle);
}
