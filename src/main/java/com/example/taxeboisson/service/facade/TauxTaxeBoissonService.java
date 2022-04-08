package com.example.taxeboisson.service.facade;

import com.example.taxeboisson.bean.TauxTaxeBoisson;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface TauxTaxeBoissonService {
    TauxTaxeBoisson findByRef(String ref);

    List<TauxTaxeBoisson> findByPourcentage(double pourcentage);

    List<TauxTaxeBoisson> findAll();

    int save(TauxTaxeBoisson tauxTaxeBoisson);


    int updatePourcentage(String ref, double nouveaupr);


    TauxTaxeBoisson findByCategorieLocaleRef(String ref);

    @Transactional
    int deleteByCategorieLocaleRef(String ref);
}
