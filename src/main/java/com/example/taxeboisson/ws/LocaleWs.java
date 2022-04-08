package com.example.taxeboisson.ws;

import com.example.taxeboisson.bean.Locale;
import com.example.taxeboisson.service.facade.LocaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/taxe-boisson/locale")
public class LocaleWs {

    @GetMapping("/ref/{ref}")
    public Locale findByRef(@PathVariable String ref) {
        return localeService.findByRef(ref);
    }

    @DeleteMapping("/ref/{ref}")
    public int deleteByRef(@PathVariable String ref) {
        return localeService.deleteByRef(ref);
    }

    @GetMapping("/adresse/{adresse}")
    public Locale findByAdresse(@PathVariable String adresse) {
        return localeService.findByAdresse(adresse);
    }

    @GetMapping("/secteur/code/{code}")
    public Locale findBySecteurCode(@PathVariable String code) {
        return localeService.findBySecteurCode(code);
    }

    @DeleteMapping("/secteur/code/{code}")
    public int deleteBySecteurCode(@PathVariable String code) {
        return localeService.deleteBySecteurCode(code);
    }

    @GetMapping("/")
    public List<Locale> findAll() {
        return localeService.findAll();
    }

    @GetMapping("/redevable/{cin}")
    public Locale findByRedevableCin(@PathVariable String cin) {
        return localeService.findByRedevableCin(cin);
    }

    @DeleteMapping("/redevable/cin")
    public int deleteByRedevableCin(@PathVariable String cin) {
        return localeService.deleteByRedevableCin(cin);
    }

    @GetMapping("/referenceCategorielocale/{ref}")
    public Locale findByCategorielocaleRef(@PathVariable String ref) {
        return localeService.findByCategorieLocaleRef(ref);
    }

    @DeleteMapping("/referenceCategorie/{ref}")
    public int deleteByCategorielocaleRef(@PathVariable String ref) {
        return localeService.deleteByCategorieLocaleRef(ref);
    }


    @PostMapping("/")
    public int save(@RequestBody Locale locale) {
        return localeService.save(locale);
    }


    @Autowired
    LocaleService localeService;

}

