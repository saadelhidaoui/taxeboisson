package com.example.taxeboisson.service.impl;

import com.example.taxeboisson.bean.Redevable;
import com.example.taxeboisson.bean.TypeRedevable;
import com.example.taxeboisson.dao.RedevableDao;
import com.example.taxeboisson.service.facade.RedevableService;
import com.example.taxeboisson.service.facade.TypeRedevableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RedevableServiceImpl implements RedevableService {
    @Autowired
    private RedevableDao redevableDao;
    @Autowired
    private TypeRedevableService typeRedevableService;

    @Override
    public int save(Redevable redevable) {
        prepare(redevable);
        if (findByCin(redevable.getCin()) != null) {
            return -1;
        }
        else if (redevable.getTypeRedevable() == null) {
            return -2;
        }else {
            redevableDao.save(redevable);
            return 1;
        }

    }
    @Override
    public Redevable findByCin(String cin) {
        return redevableDao.findByCin(cin);
    }

    @Override
    @Transactional
    public int deleteByCin(String cin) {
        return redevableDao.deleteByCin(cin);
    }

    @Override
    public List<Redevable> findByTypeRedevableCode(String code) {
        return redevableDao.findByTypeRedevableCode(code);
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

    private void prepare(Redevable redevable){
        TypeRedevable typeRedevable = typeRedevableService.findByCode(redevable.getTypeRedevable().getCode());
        redevable.setTypeRedevable(typeRedevable);
    }

    @Override
    public void update(Redevable e) {
        redevableDao.save(e);
    }
}
