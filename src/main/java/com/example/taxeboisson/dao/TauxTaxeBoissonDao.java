package com.example.taxeboisson.dao;

import com.example.taxeboisson.bean.TauxTaxeBoisson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TauxTaxeBoissonDao extends JpaRepository<TauxTaxeBoisson,Long> {
    TauxTaxeBoisson findByRef(String ref);
    List<TauxTaxeBoisson> findByPourcentage(double pourcentage);

}
