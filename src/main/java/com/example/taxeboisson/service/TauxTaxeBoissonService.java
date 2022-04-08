package com.example.taxeboisson.service;

import com.example.taxeboisson.bean.CategorieLocale;
import com.example.taxeboisson.bean.TauxTaxeBoisson;
import com.example.taxeboisson.dao.TauxTaxeBoissonDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TauxTaxeBoissonService {
    @Autowired
    private TauxTaxeBoissonDao tauxTaxeBoissonDao;
    @Autowired
    private CategorielocaleService categorieLocaleService;


    public TauxTaxeBoisson findByRef(String ref) {
        return tauxTaxeBoissonDao.findByRef(ref);
    }

    public List<TauxTaxeBoisson> findByPourcentage(double pourcentage) {
        return tauxTaxeBoissonDao.findByPourcentage(pourcentage);
    }

    public TauxTaxeBoisson findByCategorieLocaleRef(String ref) {
        return tauxTaxeBoissonDao.findByCategorieLocaleRef(ref);
    }

    public int deleteByCategorieLocaleRef(String ref) {
        return tauxTaxeBoissonDao.deleteByCategorieLocaleRef(ref);
    }

    public List<TauxTaxeBoisson> findAll() {
        return tauxTaxeBoissonDao.findAll();
    }

    public int save(TauxTaxeBoisson tauxTaxeBoisson) {
        CategorieLocale categorie = categorieLocaleService.findByRef(tauxTaxeBoisson.getCategorieLocale().getRef());
        tauxTaxeBoisson.setCategorieLocale(categorie);
        if (findByRef(tauxTaxeBoisson.getRef()) != null) {
            return -1;
        } else if (tauxTaxeBoisson.getPourcentage() <= 0) {
            return -2;
        } else if (categorie == null) {
            return -3;
        } else if (tauxTaxeBoissonDao.findByCategorieLocaleRef(tauxTaxeBoisson.getCategorieLocale().getRef()) != null) {//pour assurer qu'une categorie n'a qu'un seul TauTaxeBoisson
            return -4;
        } else {
            tauxTaxeBoissonDao.save(tauxTaxeBoisson);
            return 1;

        }
    }


    public int updatepourcentage(String ref, double nouveaupr) {
        TauxTaxeBoisson tauxTaxeBoisson = findByRef(ref);
        if (tauxTaxeBoisson == null) {
            return -1;
        } else if (nouveaupr <= 0) {
            return -2;
        } else {
            tauxTaxeBoisson.setPourcentage(nouveaupr);
            tauxTaxeBoissonDao.save(tauxTaxeBoisson);
            return 1;
        }
    }

}
