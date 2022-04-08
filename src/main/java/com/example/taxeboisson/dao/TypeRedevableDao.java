package com.example.taxeboisson.dao;

import com.example.taxeboisson.bean.TypeRedevable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeRedevableDao extends JpaRepository<TypeRedevable,Long> {
    TypeRedevable findByCode(String code);
    int deleteByCode(String code);

}
