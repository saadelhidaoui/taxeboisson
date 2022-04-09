package com.example.taxeboisson.dao;

import java.util.List;

import com.example.taxeboisson.bean.Locale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface LocaleDao extends JpaRepository<Locale, Long>{
    Locale findByRef(String ref);
    int deleteByRef(String ref);
    List<Locale> findByAdresse(String adresse);
    List<Locale>  findBySecteurCode(String code);
    int deleteBySecteurCode(String code);
    List<Locale>  findByRedevableCin(String cin);
    int deleteByRedevableCin(String cin);
    List<Locale>  findByCategorieLocaleRef(String ref);
    int deleteByCategorieLocaleRef(String ref);
}
