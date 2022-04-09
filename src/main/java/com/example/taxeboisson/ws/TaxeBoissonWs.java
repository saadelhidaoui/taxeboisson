package com.example.taxeboisson.ws;

import com.example.taxeboisson.bean.TaxeBoisson;
import com.example.taxeboisson.service.facade.TaxeBoissonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/taxe-boisson/taxe")
public class TaxeBoissonWs {


    @DeleteMapping("/ref/{ref}")
    public int deleteByRef(@PathVariable String ref) {
        return taxeBoissonService.deleteByRef(ref);
    }

    @GetMapping("/ref/{ref}")
    public TaxeBoisson findByRef(@PathVariable String ref) {
        return taxeBoissonService.findByRef(ref);
    }

    @GetMapping("/locale/ref/{ref}")
    public TaxeBoisson findByLocaleRef(@PathVariable String ref) {
        return taxeBoissonService.findByLocaleRef(ref);
    }

    @DeleteMapping("/locale/ref/{ref}")
    public int deleteByLocaleRef(@PathVariable String ref) {
        return taxeBoissonService.deleteByLocaleRef(ref);
    }


    @GetMapping("/locale/ref/{ref}/trim/{trim}/annee/{annee}")
    public TaxeBoisson findByLocaleRefAndTrimAndAnnee(@PathVariable String ref,@PathVariable int trim,@PathVariable int annee) {
        return taxeBoissonService.findByLocaleRefAndTrimAndAnnee(ref, trim, annee);
    }

    @GetMapping("/")
    public List<TaxeBoisson> findAll() {
        return taxeBoissonService.findAll();
    }

    @PostMapping("/")
    public int save(@RequestBody TaxeBoisson taxeBoisson) {
        return taxeBoissonService.save(taxeBoisson);
    }


    @Autowired
    TaxeBoissonService taxeBoissonService;
}
