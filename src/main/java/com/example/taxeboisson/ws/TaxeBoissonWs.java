package com.example.taxeboisson.ws;

import java.util.List;

import com.example.taxeboisson.bean.TaxeBoisson;
import com.example.taxeboisson.service.TaxeBoissonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/taxe-Boisson/taxe")
public class TaxeBoissonWs {
    @Autowired
    TaxeBoissonService taxeBoissonService ;

    @DeleteMapping("/ref/{ref}")
    public int deleteByRef(@PathVariable String  ref) {
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
    public TaxeBoisson findByLocaleRefAndTrimAndAnnee(String ref, double trim, double annee) {
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

}
