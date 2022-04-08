package com.example.taxeboisson.service;

import com.example.taxeboisson.bean.Redevable;
import com.example.taxeboisson.bean.TypeRedevable;
import com.example.taxeboisson.dao.RedevableDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RedevableService {

    @Autowired
    RedevableDao redevableDao;

    @Autowired
    LocaleService localeService;

    @Autowired
    TaxeBoissonService taxeBoissonService;
    @Autowired
    private TypeRedevableService typeRedevableService;



    public Redevable findByRef(String ref) {
        return redevableDao.findByRef(ref);
    }


    public int save(Redevable redevable) {
        TypeRedevable typeRedevable=typeRedevableService.findByCode(redevable.getTypeRedevable().getCode());
        redevable.setTypeRedevable(typeRedevable);
        if(findByRef(redevable.getRef())!=null){
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

    @Transactional
    public int deleteByTypeRedevableCode(String code) {
        return redevableDao.deleteByTypeRedevableCode(code);
    }

    public List<Redevable> findAll() {
        return redevableDao.findAll();
    }

}
