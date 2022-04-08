package com.example.taxeboisson.ws;

import com.example.taxeboisson.bean.TauxTaxeBoisson;
import com.example.taxeboisson.service.facade.TauxTaxeBoissonService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @PutMapping("/updatepourcentage/ref/{ref}/Nouveaupr/{Nouveaupr}")
    public int updatepourcentage(@PathVariable String ref, @PathVariable double Nouveaupr) {
        return tauxTaxeBoissonService.updatePourcentage(ref, Nouveaupr);
    }

    @Autowired
    private TauxTaxeBoissonService tauxTaxeBoissonService;
}
