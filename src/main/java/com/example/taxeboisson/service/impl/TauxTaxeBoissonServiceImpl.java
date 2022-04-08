package com.example.taxeboisson.service.impl;

import com.example.taxeboisson.bean.TauxTaxeBoisson;
import com.example.taxeboisson.dao.TauxTaxeBoissonDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TauxTaxeBoissonServiceImpl {
    @Autowired
    private TauxTaxeBoissonDao tauxTaxeBoissonDao;


    public TauxTaxeBoisson findByRef(String ref) {
        return tauxTaxeBoissonDao.findByRef(ref);
    }

    public List<TauxTaxeBoisson> findByPourcentage(double pourcentage) {
        return tauxTaxeBoissonDao.findByPourcentage(pourcentage);
    }

    public List<TauxTaxeBoisson> findAll() {
        return tauxTaxeBoissonDao.findAll();
    }

    public int save(TauxTaxeBoisson tauxTaxeBoisson) {
        if(findByRef(tauxTaxeBoisson.getRef()) != null){
            return -1;
        } else if(tauxTaxeBoisson.getPourcentage() <= 0){
            return -2;
        }else {
            tauxTaxeBoissonDao.save(tauxTaxeBoisson);
            return 1;
        }

    }

    public int updatepourcentage(String ref, double nouveaupr) {
        TauxTaxeBoisson tauxTaxeBoisson;
        tauxTaxeBoisson=findByRef(ref);

        if(tauxTaxeBoisson!=null)
        {
            tauxTaxeBoisson.setPourcentage(nouveaupr);
            tauxTaxeBoissonDao.save(tauxTaxeBoisson);
            return 1;
        }
        else return 0;


    }
}
