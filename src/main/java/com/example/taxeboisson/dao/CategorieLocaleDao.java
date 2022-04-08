package com.example.taxeboisson.dao;

import com.example.taxeboisson.bean.CategorieLocale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategorieLocaleDao extends JpaRepository<CategorieLocale,Long> {
    CategorieLocale findByRef(String ref);
    int deleteByRef(String ref);
}
