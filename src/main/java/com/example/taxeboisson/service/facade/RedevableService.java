package com.example.taxeboisson.service.facade;

import com.example.taxeboisson.bean.Redevable;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface RedevableService {
    Redevable findByCin(String cin);



    List<Redevable> findByTypeRedevableCode(String code);

    @Transactional
    int deleteByCin(String cin);

    @Transactional
    int deleteByTypeRedevableCode(String code);

    List<Redevable> findAll();

    int save(Redevable redevable);
}
