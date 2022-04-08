package com.example.taxeboisson.ws;

import com.example.taxeboisson.bean.TypeRedevable;
import com.example.taxeboisson.service.TypeRedevableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/taxe-boisson/typeredevable")
public class TypeRedevableWs {
    @GetMapping("code/{code}")
    public TypeRedevable findByCode(@PathVariable String code) {
        return typeRedevableService.findByCode(code);
    }

    @DeleteMapping("code/{code}")
    public int deleteByCode(@PathVariable String code) {
        return typeRedevableService.deleteByCode(code);
    }
    @GetMapping("/")
    public List<TypeRedevable> findAll() {
        return typeRedevableService.findAll();
    }
    @PostMapping("/")
    public int save(@RequestBody TypeRedevable typeRedevable) {
        return typeRedevableService.save(typeRedevable);
    }

    @Autowired
    TypeRedevableService typeRedevableService;
}

