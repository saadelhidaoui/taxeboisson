package com.example.taxeboisson.service.facade;

import com.example.taxeboisson.bean.TaxeBoisson;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface TaxeBoissonService {
    TaxeBoisson findByRef(String ref);

    TaxeBoisson findByLocaleRef(String ref);

    @Transactional
    int deleteByLocaleRef(String ref);

    TaxeBoisson findByLocaleRefAndTrimAndAnnee(String ref, double trim, double annee);

    TaxeBoisson findByRedevableCin(String cin);

    int deleteByRedevableCin(String cin);



    @Transactional
    int deleteByRef(String ref);

    List<TaxeBoisson> findAll();

    int save(TaxeBoisson taxeBoisson);
}
