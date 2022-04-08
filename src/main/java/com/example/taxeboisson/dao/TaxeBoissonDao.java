package com.example.taxeboisson.dao;

import com.example.taxeboisson.bean.TaxeBoisson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaxeBoissonDao extends JpaRepository<TaxeBoisson, Long> {
    TaxeBoisson findByRef(String ref);
    TaxeBoisson findByRedevableCin(String cin);
    TaxeBoisson findByLocaleRef(String ref);

    int deleteByRef(String ref);
    int deleteByLocaleRef(String ref);
    int deleteByRedevableCin(String cin);
    int deleteByRedevableTypeRedevableCode(String code);
    int deleteByLocaleSecteurCode(String code);
    int deleteByLocaleCategorieLocaleRef(String ref);

    //pour save
    TaxeBoisson findByLocaleRefAndTrimAndAnnee(String ref,double trim,double annee);
}
