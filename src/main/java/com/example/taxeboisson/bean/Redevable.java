package com.example.taxeboisson.bean;

import javax.persistence.*;
import java.util.List;

@Entity
public class Redevable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String cin;
    private String nom;
    private String prenom;
    private String adresse;

    @ManyToOne
    private TypeRedevable typeRedevable;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

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
