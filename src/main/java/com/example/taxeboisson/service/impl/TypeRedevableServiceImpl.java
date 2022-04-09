package com.example.taxeboisson.service.impl;

import com.example.taxeboisson.bean.Redevable;
import com.example.taxeboisson.bean.TypeRedevable;
import com.example.taxeboisson.dao.TypeRedevableDao;
import com.example.taxeboisson.service.facade.RedevableService;
import com.example.taxeboisson.service.facade.TypeRedevableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TypeRedevableServiceImpl implements TypeRedevableService {
    @Autowired
    private RedevableService redevableService;
    @Autowired
    private TypeRedevableDao typeRedevableDao;

    @Override
    public int save(TypeRedevable typeRedevable) {
        if (findByCode(typeRedevable.getCode()) != null) {
            return -1;
        }else if(typeRedevable.getLibelle() == null){
            return -2;
        }else {
            typeRedevableDao.save(typeRedevable);
            return 1;
        }
    }
    @Transactional
    @Override
    public int deleteByCode(String code) {
        List<Redevable> redevables=redevableService.findByTypeRedevableCode(code);
        redevables.forEach(
                e->{
                    e.setTypeRedevable(null);
                    redevableService.update(e);
                }
        );
        return typeRedevableDao.deleteByCode(code);
    }

    @Override
    public TypeRedevable findByCode(String code) {
        return typeRedevableDao.findByCode(code);
    }


    @Override
    public List<TypeRedevable> findAll() {
        return typeRedevableDao.findAll();
    }
}
