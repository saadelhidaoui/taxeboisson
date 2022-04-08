package com.example.taxeboisson.ws;

import com.example.taxeboisson.bean.Redevable;
import com.example.taxeboisson.service.RedevableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/taxe-boisson/redevable")
public class RedevableWs {
    @Autowired
    RedevableService redevableService;

    @GetMapping("/ref/{ref}")
    public Redevable findByRef(@PathVariable String ref) {
        return redevableService.findByRef(ref);
    }


    @DeleteMapping("/ref/{ref}")
    public int deleteByRef(@PathVariable String ref) {
        return redevableService.deleteByRef(ref);
    }


    @PostMapping("/")
    public int save(@RequestBody Redevable redevable) {
        return redevableService.save(redevable);
    }
    @GetMapping("/type-redevable/code/{code}")
    public List<Redevable> findByTypeRedevableCode(@PathVariable String code) {
        return redevableService.findByTypeRedevableCode(code);
    }
    @DeleteMapping("/type-redevable/code/{code}")
    public int deleteByTypeRedevableCode(@PathVariable String code) {
        return redevableService.deleteByTypeRedevableCode(code);
    }
    @GetMapping("/")
    public List<Redevable> findAll() {
        return redevableService.findAll();
    }


}
