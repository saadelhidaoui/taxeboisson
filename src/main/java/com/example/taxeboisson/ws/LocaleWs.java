package com.example.taxeboisson.ws;

import java.util.List;

import com.example.taxeboisson.bean.Locale;
import com.example.taxeboisson.service.LocaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping( "/api/Taxe-Boisson/locale")
public class LocaleWs {

    @Autowired
    LocaleService localeService;

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

    @GetMapping("/referenceRedevable/{ref}")
    public Locale findByRedevableRef(@PathVariable String ref) {
        return localeService.findByRedevableRef(ref);
    }

    @DeleteMapping("/referenceRedevable/ref")
    public int deleteByRedevableRef(@PathVariable String ref) {
        return localeService.deleteByRedevableRef(ref);
    }

    @GetMapping("/referenceCategorielocale/{ref}")
    public List<Locale> findByCategorielocaleRef(@PathVariable String ref) {
        return localeService.findByCategorielocaleRef(ref);
    }

    @DeleteMapping("/referenceCategorie/{ref}")
    public int deleteByCategorielocaleRef(@PathVariable String ref) {
        return localeService.deleteByCategorielocaleRef(ref);
    }

    @DeleteMapping("/redevable/typeRedevable/{code}")
    public int deleteByTypeRedevableCode(@PathVariable String code) {
        return localeService.deleteByTypeRedevableCode(code);
    }

    @PostMapping("/")
    public int save(@RequestBody Locale locale) {
        return localeService.save(locale);
    }

}

