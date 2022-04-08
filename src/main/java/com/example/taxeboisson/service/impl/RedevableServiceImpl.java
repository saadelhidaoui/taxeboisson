package com.example.taxeboisson.service.impl;

import com.example.taxeboisson.bean.Redevable;
import com.example.taxeboisson.bean.TypeRedevable;
import com.example.taxeboisson.dao.RedevableDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RedevableServiceImpl {


    @Autowired
    RedevableDao redevableDao;

    @Autowired
    LocaleServiceImpl localeService;

    @Autowired
    TaxeBoissonServiceImpl taxeBoissonService;
    @Autowired
    private TypeRedevableServiceImpl typeRedevableService;



    public Redevable findByCin(String cin) {
        return redevableDao.findByCin(cin);
    }


    public int save(Redevable redevable) {
        TypeRedevable typeRedevable=typeRedevableService.findByCode(redevable.getTypeRedevable().getCode());
        redevable.setTypeRedevable(typeRedevable);
        if(findByCin(redevable.getCin())!=null){
            return -1;
        }
        if(typeRedevable==null){
            return -2;
        }else {
            redevableDao.save(redevable);
            return 1;
        }

    }

    public List<Redevable> findByTypeRedevableCode(String code) {
        return redevableDao.findByTypeRedevableCode(code);
    }

    public int deleteByCin(String cin) {
        return redevableDao.deleteByCin(cin);
    }

    @Transactional
    public int deleteByTypeRedevableCode(String code) {
        return redevableDao.deleteByTypeRedevableCode(code);
    }

    public List<Redevable> findAll() {
        return redevableDao.findAll();
    }

}
