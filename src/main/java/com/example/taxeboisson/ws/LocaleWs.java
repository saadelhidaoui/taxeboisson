package com.example.taxeboisson.ws;

import com.example.taxeboisson.bean.Locale;
import com.example.taxeboisson.service.facade.LocaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/taxe-boisson/locale")
public class LocaleWs {

    @Autowired
    LocaleService localeService;

    /**
     * GetMapping
     **/
    @GetMapping("/ref/{ref}")
    public Locale findByRef(@PathVariable String ref) {
        return localeService.findByRef(ref);
    }

    @GetMapping("/adresse/{adresse}")
    public List<Locale> findByAdresse(@PathVariable String adresse) {
        return localeService.findByAdresse(adresse);
    }

    @GetMapping("/secteur/code/{code}")
    public List<Locale> findBySecteurCode(@PathVariable String code) {
        return localeService.findBySecteurCode(code);
    }

    @GetMapping("/")
    public List<Locale> findAll() {
        return localeService.findAll();
    }

    @GetMapping("/redevable/cin/{cin}")
    public List<Locale> findByRedevableCin(@PathVariable String cin) {
        return localeService.findByRedevableCin(cin);
    }

    @GetMapping("/referenceCategorielocale/ref/{ref}")
    public List<Locale> findByCategorieLocaleRef(@PathVariable String ref) {
        return localeService.findByCategorieLocaleRef(ref);
    }

    /**
     * DeleteMapping
     **/
    @DeleteMapping("/ref/{ref}")
    public int deleteByRef(@PathVariable String ref) {
        return localeService.deleteByRef(ref);
    }

    @DeleteMapping("/secteur/code/{code}")
    public int deleteBySecteurCode(@PathVariable String code) {
        return localeService.deleteBySecteurCode(code);
    }

    @DeleteMapping("/redevable/cin/{cin}")
    public int deleteByRedevableCin(@PathVariable String cin) {
        return localeService.deleteByRedevableCin(cin);
    }

    @DeleteMapping("/referenceCategorie/ref/{ref}")
    public int deleteByCategorielocaleRef(@PathVariable String ref) {
        return localeService.deleteByCategorielocaleRef(ref);
    }

    /**
     * PostMapping
     **/
    @PostMapping("/")
    public int save(@RequestBody Locale locale) {
        return localeService.save(locale);
    }


}

