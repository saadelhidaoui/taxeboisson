package com.example.taxeboisson.service.facade;

import com.example.taxeboisson.bean.TypeRedevable;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface TypeRedevableService {
    TypeRedevable findByCode(String code);

    int deleteByCode(String code);

    List<TypeRedevable> findAll();

    int save(TypeRedevable typeRedevable);
}
