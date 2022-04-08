package com.example.taxeboisson.service.facade;

import com.example.taxeboisson.bean.TaxeBoisson;

import java.util.List;

public interface TaxeBoissonService {
    TaxeBoisson findByRef(String ref);

    TaxeBoisson findByLocaleRef(String ref);

    int deleteByLocaleRef(String ref);

    TaxeBoisson findByLocaleRefAndTrimAndAnnee(String ref, double trim, double annee);

    int deleteByRef(String ref);

    List<TaxeBoisson> findAll();

    int save(TaxeBoisson taxeBoisson);
}
