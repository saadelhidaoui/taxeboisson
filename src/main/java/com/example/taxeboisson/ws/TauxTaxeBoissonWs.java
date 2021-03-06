package com.example.taxeboisson.ws;

import com.example.taxeboisson.bean.TauxTaxeBoisson;
import com.example.taxeboisson.service.facade.TauxTaxeBoissonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/taxe-boisson/taux-taxe-boisson")
public class TauxTaxeBoissonWs {

    @GetMapping("/ref/{ref}")
    public TauxTaxeBoisson findByRef(@PathVariable String ref) {
        return tauxTaxeBoissonService.findByRef(ref);
    }

    @GetMapping("/")
    public List<TauxTaxeBoisson> findAll() {
        return tauxTaxeBoissonService.findAll();
    }

    @GetMapping("/pourcentage/{pourcentage}")
    public List<TauxTaxeBoisson> findByPourcentage(@PathVariable double pourcentage) {
        return tauxTaxeBoissonService.findByPourcentage(pourcentage);
    }

    @PostMapping("/")
    public int save(@RequestBody TauxTaxeBoisson tautaxeboisson) {
        return tauxTaxeBoissonService.save(tautaxeboisson);
    }


    @PutMapping("/updatepourcentage/ref/{ref}/nouveaupr/{nouveaupr}")
    public int updatePourcentage(@PathVariable String ref, @PathVariable double nouveaupr) {
        return tauxTaxeBoissonService.updatePourcentage(ref, nouveaupr);
    }
    @GetMapping("/categorielocal/ref/{ref}")
    public TauxTaxeBoisson findByCategorieLocaleRef(@PathVariable String ref) {
        return tauxTaxeBoissonService.findByCategorieLocaleRef(ref);
    }

    @DeleteMapping("categorielocal/ref/{ref}")
    public int deleteByCategorieLocaleRef(@PathVariable String ref) {
        return tauxTaxeBoissonService.deleteByCategorieLocaleRef(ref);
    }

    @Autowired
    private TauxTaxeBoissonService tauxTaxeBoissonService;
}
