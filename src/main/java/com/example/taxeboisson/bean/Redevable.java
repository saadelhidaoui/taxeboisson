package com.example.taxeboisson.bean;

import javax.persistence.*;

@Entity
public class Redevable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String cin;
    @ManyToOne
    private TypeRedevable typeRedevable;




    public TypeRedevable getTypeRedevable() {
        return typeRedevable;
    }

    public void setTypeRedevable(TypeRedevable typeRedevable) {
        this.typeRedevable = typeRedevable;
    }


    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }


}
