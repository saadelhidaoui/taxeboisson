package com.example.taxeboisson.service.facade;

import com.example.taxeboisson.bean.Secteur;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface SecteurService {
    Secteur findByLibelle(String libelle);

    @Transactional
    int deleteByLibelle(String libelle);

    Secteur findByCode(String code);

    @Transactional
    int deleteByCode(String code);

    List<Secteur> findAll();

    int save(Secteur secteur);
}
