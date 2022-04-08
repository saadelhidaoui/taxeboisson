package com.example.taxeboisson.dao;

import com.example.taxeboisson.bean.TaxeBoisson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaxeBoissonDao extends JpaRepository<TaxeBoisson, Long> {
    TaxeBoisson findByRef(String ref);
    TaxeBoisson findByRedevableCin(String cin);
    int deleteByRef(String ref);
    TaxeBoisson findByLocaleRef(String ref);
    int deleteByLocaleRef(String ref);
    int deleteByRedevableCin(String cin);
    int deleteByTypeRedevableCode(String code);
    int deleteByLocaleSecteurCode(String code);
    int deleteByCategorielocaleRef(String ref);
    //pour save
    TaxeBoisson findByLocaleRefAndTrimAndAnnee(String ref,double trim,double annee);
}
