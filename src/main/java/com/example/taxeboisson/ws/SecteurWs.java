package com.example.taxeboisson.ws;

import com.example.taxeboisson.bean.Secteur;
import com.example.taxeboisson.service.facade.SecteurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/taxe-boisson/secteur")
public class SecteurWs {

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


    @Autowired
    SecteurService secteurService;

}
