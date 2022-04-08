package com.example.taxeboisson.ws;

import java.util.List;

import com.example.taxeboisson.bean.Locale;
import com.example.taxeboisson.service.impl.LocaleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping( "/api/taxe-boisson/locale")
public class LocaleWs {

    @Autowired
    LocaleServiceImpl localeService;

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
    public List<Locale> findByCategorielocaleRef(@PathVariable String ref) {
        return localeService.findByCategorielocaleRef(ref);
    }

    @DeleteMapping("/referenceCategorie/{ref}")
    public int deleteByCategorielocaleRef(@PathVariable String ref) {
        return localeService.deleteByCategorieLocaleRef(ref);
    }


    @PostMapping("/")
    public int save(@RequestBody Locale locale) {
        return localeService.save(locale);
    }

}

