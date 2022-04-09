package com.example.taxeboisson.service.impl;

import com.example.taxeboisson.bean.Redevable;
import com.example.taxeboisson.bean.TypeRedevable;
import com.example.taxeboisson.dao.RedevableDao;
import com.example.taxeboisson.service.facade.LocaleService;
import com.example.taxeboisson.service.facade.RedevableService;
import com.example.taxeboisson.service.facade.TaxeBoissonService;
import com.example.taxeboisson.service.facade.TypeRedevableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RedevableServiceImpl implements RedevableService {


    @Override
    public Redevable findByCin(String cin) {
        return redevableDao.findByCin(cin);
    }

    @Override
    public int save(Redevable redevable) {
        TypeRedevable typeRedevable = typeRedevableService.findByCode(redevable.getTypeRedevable().getCode());
        redevable.setTypeRedevable(typeRedevable);
        if (findByCin(redevable.getCin()) != null) {
            return -1;
        }
        if (typeRedevable == null) {
            return -2;
        } else {
            redevableDao.save(redevable);
            return 1;
        }

    }

    @Override
    public List<Redevable> findByTypeRedevableCode(String code) {
        return redevableDao.findByTypeRedevableCode(code);
    }

    @Override
    @Transactional
    public int deleteByCin(String cin) {
        return redevableDao.deleteByCin(cin);
    }

    @Transactional
    @Override
    public int deleteByTypeRedevableCode(String code) {
        return redevableDao.deleteByTypeRedevableCode(code);
    }

    @Override
    public List<Redevable> findAll() {
        return redevableDao.findAll();
    }


    @Autowired
    RedevableDao redevableDao;

    @Autowired
    LocaleService localeService;

    @Autowired
    TaxeBoissonService taxeBoissonService;
    @Autowired
    private TypeRedevableService typeRedevableService;


}