package com.example.taxeboisson.dao;

import com.example.taxeboisson.bean.Secteur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SecteurDao extends JpaRepository<Secteur, Long> {

    /******            Get             ******/
    Secteur findByLibelle(String libelle);

    Secteur findByCode(String code);

    /******            delete          ******/
    int deleteByCode(String code);

    int deleteByLibelle(String libelle);
}