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

    @GetMapping("/annee/{annee}")
    public TaxeBoisson findByAnnee(@PathVariable int annee) {
        return taxeBoissonService.findByAnnee(annee);
    }
    @DeleteMapping("/annee/{annee}")
    public int deleteByAnnee(@PathVariable int annee) {
        return taxeBoissonService.deleteByAnnee(annee);
    }

    @GetMapping("/findbyanneandtrim/annee/{annee}/trim/{trim}")
    public TaxeBoisson findByAnneeAndTrim(@PathVariable int annee,@PathVariable int trim) {
        return taxeBoissonService.findByAnneeAndTrim(annee, trim);
    }
    @DeleteMapping("/deletebyanneandtrim/annee/{annee}/trim/{trim}")
    public int deleteByAnneeAndTrim(@PathVariable int annee,@PathVariable int trim) {
        return taxeBoissonService.deleteByAnneeAndTrim(annee, trim);
    }

    @GetMapping("/redevable/cin/{cin}")
    public TaxeBoisson findByRedevableCin(@PathVariable String cin) {
        return taxeBoissonService.findByRedevableCin(cin);
    }

    @Autowired
    TaxeBoissonService taxeBoissonService;
}
