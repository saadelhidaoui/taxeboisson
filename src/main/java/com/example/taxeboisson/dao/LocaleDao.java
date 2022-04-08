package com.example.taxeboisson.dao;

import java.util.List;

import com.example.taxeboisson.bean.Locale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface LocaleDao extends JpaRepository<Locale, Long>{
    Locale findByRef(String ref);
    int deleteByRef(String ref);
    Locale findByAdresse(String adresse);
    Locale findBySecteurCode(String code);
    int deleteBySecteurCode(String code);
    Locale findByRedevableRef(String ref);
    int deleteByRedevableRef(String ref);
    List<Locale> findByCategorielocaleRef(String ref);
    int deleteByCategorielocaleRef(String ref);
}
