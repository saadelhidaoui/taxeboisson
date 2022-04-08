package com.example.taxeboisson.ws;

import java.util.List;

import com.example.taxeboisson.bean.Secteur;
import com.example.taxeboisson.service.impl.SecteurServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping( "/api/taxe-boisson/secteur")
public class SecteurWs {

    @Autowired
    SecteurServiceImpl secteurService;

    @GetMapping("/libelle/{libelle}")
    public Secteur findByLibelle(@PathVariable String libelle) {
        return secteurService.findByLibelle(libelle);
    }

    @DeleteMapping("/libelle/{libelle}")
    public int deleteByLibelle(String libelle) {
        return secteurService.deleteByLibelle(libelle);
    }
    @GetMapping("/code/{code}")
    public Secteur findByCode(String code) {
        return secteurService.findByCode(code);
    }

    @DeleteMapping("/code/{code}")
    public int deleteByCode(@PathVariable String code) {
        return secteurService.deleteByCode(code);
    }

    @GetMapping("/")
    public List<Secteur> findAll() {
        return secteurService.findAll();
    }

    @PostMapping("/")
    public int save(@RequestBody Secteur secteur) {
        return secteurService.save(secteur);
    }


}
