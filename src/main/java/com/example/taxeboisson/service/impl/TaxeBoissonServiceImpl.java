package com.example.taxeboisson.service.impl;

import com.example.taxeboisson.bean.*;
import com.example.taxeboisson.dao.TaxeBoissonDao;
import com.example.taxeboisson.service.facade.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Calendar;
import java.util.List;

@Service
public class TaxeBoissonServiceImpl implements TaxeBoissonService {

    @Override
    public TaxeBoisson findByRef(String ref) {
        return taxeBoissonDao.findByRef(ref);
    }

    @Override
    public TaxeBoisson findByLocaleRef(String ref) {
        return taxeBoissonDao.findByLocaleRef(ref);
    }

    @Override
    @Transactional
    public int deleteByLocaleRef(String ref) {
        return taxeBoissonDao.deleteByLocaleRef(ref);
    }

    @Override
    public TaxeBoisson findByLocaleRefAndTrimAndAnnee(String ref, int trim, int annee) {
        return taxeBoissonDao.findByLocaleRefAndTrimAndAnnee(ref, trim, annee);
    }

    @Override
    @Transactional
    public int deleteByRef(String ref) {
        return taxeBoissonDao.deleteByRef(ref);
    }

    @Override
    public List<TaxeBoisson> findAll() {
        return taxeBoissonDao.findAll();
    }

    @Override
    public TaxeBoisson findByAnnee(int annee) {
        return taxeBoissonDao.findByAnnee(annee);
    }

    @Override
    @Transactional
    public int deleteByAnnee(int annee) {
        return taxeBoissonDao.deleteByAnnee(annee);
    }

    @Override
    public TaxeBoisson findByAnneeAndTrim(int annee, int trim) {
        return taxeBoissonDao.findByAnneeAndTrim(annee, trim);
    }

    @Override
    @Transactional
    public int deleteByAnneeAndTrim(int annee, int trim) {
        return taxeBoissonDao.deleteByAnneeAndTrim(annee, trim);
    }


    void prepare(TaxeBoisson taxeBoisson) {
        Locale locale = localeService.findByRef(taxeBoisson.getLocale().getRef());
        taxeBoisson.setLocale(locale);

        if (locale != null) {
            Redevable redevable = redevableService.findByCin(taxeBoisson.getLocale().getRedevable().getCin());
            taxeBoisson.getLocale().setRedevable(redevable);

            CategorieLocale categorieLocale = categorieLocaleService.findByRef(taxeBoisson.getLocale().getCategorieLocale().getRef());
            taxeBoisson.getLocale().setCategorieLocale(categorieLocale);

            Secteur secteur = secteurService.findByCode(taxeBoisson.getLocale().getSecteur().getCode());
            taxeBoisson.getLocale().setSecteur(secteur);
        }

    }
    public int save(TaxeBoisson taxeBoisson) {
        prepare(taxeBoisson);

        int res = validate(taxeBoisson);

        if (res > 0) {
            handleProcess(taxeBoisson);
        }

        return res;
    }

    int validate(TaxeBoisson taxeBoisson) {
        int anneeActuelle = Calendar.getInstance().get(Calendar.YEAR);
        int tri = taxeBoisson.getTrim();

        TaxeBoisson byLocaleRefAndTrimAndAnnee = null;

        if (taxeBoisson.getLocale() != null) {
            byLocaleRefAndTrimAndAnnee = findByLocaleRefAndTrimAndAnnee(taxeBoisson.getLocale().getRef(), tri, taxeBoisson.getAnnee());
        }

        if (taxeBoisson.getAnnee() > anneeActuelle) {
            return -1;
        } else if (taxeBoisson.getChiffreAffaire() <= 0) {
            return -2;
        } else if (taxeBoisson.getLocale() == null) {
            return -3;
        }else if (taxeBoisson.getLocale().getRedevable() == null) {
            return -4;
        } else if (taxeBoisson.getLocale().getCategorieLocale() == null) {
            return -5;
        } else if (taxeBoisson.getLocale().getSecteur() == null) {
            return -6;
        }  else if (byLocaleRefAndTrimAndAnnee != null) {
            return -7;
        } else {

            return 1;

        }

    }

    void handleProcess(TaxeBoisson taxeBoisson) {
        TauxTaxeBoisson t = tauxTaxeBoissonService.findByCategorieLocaleRef(taxeBoisson.getLocale().getCategorieLocale().getRef());

        taxeBoisson.setPourcentageApplique(t.getPourcentage());
        double mtb = (taxeBoisson.getPourcentageApplique() / 100) * taxeBoisson.getChiffreAffaire();

        taxeBoisson.setMontantBase(mtb);
        taxeBoissonDao.save(taxeBoisson);
    }



    @Autowired
    private TauxTaxeBoissonService tauxTaxeBoissonService;
    @Autowired
    private TaxeBoissonDao taxeBoissonDao;
    @Autowired
    private LocaleService localeService;
    @Autowired
    private RedevableService redevableService;
    @Autowired
    private CategorieLocaleService categorieLocaleService;
    @Autowired
    private SecteurService secteurService;

}
