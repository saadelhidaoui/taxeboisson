package com.example.taxeboisson.ws;

import com.example.taxeboisson.bean.Redevable;
import com.example.taxeboisson.service.facade.RedevableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/taxe-boisson/redevable")
public class RedevableWs {


    @GetMapping("/cin/{cin}")
    public Redevable findByCin(@PathVariable String cin) {
        return redevableService.findByCin(cin);
    }

    @PostMapping("/")
    public int save(@RequestBody Redevable redevable) {
        return redevableService.save(redevable);
    }

    @GetMapping("/type-redevable/code/{code}")
    public List<Redevable> findByTypeRedevableCode(@PathVariable String code) {
        return redevableService.findByTypeRedevableCode(code);
    }

    @DeleteMapping("/cin/{cin}")
    public int deleteByCin(@PathVariable String cin) {
        return redevableService.deleteByCin(cin);
    }

    @DeleteMapping("/type-redevable/code/{code}")
    public int deleteByTypeRedevableCode(@PathVariable String code) {
        return redevableService.deleteByTypeRedevableCode(code);
    }

    @GetMapping("/")
    public List<Redevable> findAll() {
        return redevableService.findAll();
    }

    @Autowired
    RedevableService redevableService;
}
