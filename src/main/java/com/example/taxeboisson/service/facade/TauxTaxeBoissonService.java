package com.example.taxeboisson.service.facade;

import com.example.taxeboisson.bean.TauxTaxeBoisson;

import java.util.List;

public interface TauxTaxeBoissonService {
    TauxTaxeBoisson findByRef(String ref);

    List<TauxTaxeBoisson> findByPourcentage(double pourcentage);

    List<TauxTaxeBoisson> findAll();

    int save(TauxTaxeBoisson tauxTaxeBoisson);


    int updatePourcentage(String ref, double nouveaupr);
}
