package com.example.taxeboisson.service.facade;

import com.example.taxeboisson.bean.TaxeBoisson;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface TaxeBoissonService {

    TaxeBoisson findByRef(String ref);

    TaxeBoisson findByLocaleRef(String ref);

    @Transactional
    int deleteByLocaleRef(String ref);


    TaxeBoisson findByLocaleRefAndTrimAndAnnee(String ref, int trim, int annee);

    List<TaxeBoisson> findAll();


    int deleteByRef(String ref);

    TaxeBoisson findByAnnee(int annee);

    int deleteByAnnee(int annee);


    TaxeBoisson findByAnneeAndTrim(int annee, int trim);


    int deleteByAnneeAndTrim(int annee, int trim);


    int save(TaxeBoisson taxeBoisson);
}
