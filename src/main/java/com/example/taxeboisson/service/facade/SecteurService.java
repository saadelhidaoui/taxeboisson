package com.example.taxeboisson.service.facade;

import com.example.taxeboisson.bean.Secteur;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface SecteurService {
    Secteur findByLibelle(String libelle);


    /******            Get          ******/
    Secteur findByCode(String code);
    List<Secteur> findAll();

    /******            delete          ******/
    int deleteByCode(String code);
    int deleteByLibelle(String libelle);

    /******            Post          ******/
    int save(Secteur secteur);
}
