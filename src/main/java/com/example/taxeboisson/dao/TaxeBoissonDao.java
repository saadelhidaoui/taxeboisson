package com.example.taxeboisson.dao;

import com.example.taxeboisson.bean.TaxeBoisson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TaxeBoissonDao extends JpaRepository<TaxeBoisson, Long> {

    TaxeBoisson findByRef(String ref);

    int deleteByRef(String ref);

    TaxeBoisson findByAnnee(int annee);

    int deleteByAnnee(int annee);

    TaxeBoisson findByAnneeAndTrim(int annee,int trim);

    int deleteByAnneeAndTrim(int annee,int trim);


    TaxeBoisson findByLocaleRef(String ref);

    int deleteByLocaleRef(String ref);

    //pour save
    TaxeBoisson findByLocaleRefAndTrimAndAnnee(String ref, int trim, int annee);


}
