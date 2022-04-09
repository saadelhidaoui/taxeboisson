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




    @Transactional
    int deleteByRef(String ref);

    List<TaxeBoisson> findAll();

    int save(TaxeBoisson taxeBoisson);
}
