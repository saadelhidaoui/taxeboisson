package com.example.taxeboisson.ws;

import com.example.taxeboisson.bean.CategorieLocale;
import com.example.taxeboisson.service.impl.CategorieLocaleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/taxe-boisson/categorie-locale")
public class CategorieLocaleWs {
    @Autowired
    private CategorieLocaleServiceImpl categorielocaleServiceImpl;
    @GetMapping("/ref/{ref}")
    public CategorieLocale findByRef(@PathVariable String ref) {
        return categorielocaleServiceImpl.findByRef(ref);
    }
    @GetMapping("/")
    public List<CategorieLocale> findAll() {
        return categorielocaleServiceImpl.findAll();
    }
    @DeleteMapping("/ref/{ref}")
    public int deleteByRef(@PathVariable String ref) {
        return categorielocaleServiceImpl.deleteByRef(ref);
    }
    @PostMapping("/")
    public int save(@RequestBody CategorieLocale categorielocale) {
        return categorielocaleServiceImpl.save(categorielocale);
    }

}
