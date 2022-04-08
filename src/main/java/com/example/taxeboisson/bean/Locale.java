package com.example.taxeboisson.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Locale {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String ref;
    private String adresse;
    private String rue;

    @OneToOne
    private Redevable redevable;

    @ManyToOne
    private CategorieLocale categorieLocale;

    @ManyToOne
    private Secteur secteur;

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getRef() {
        return ref;
    }
    public void setRef(String ref) {
        this.ref = ref;
    }
    public String getAdresse() {
        return adresse;
    }
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
    public String getRue() {
        return rue;
    }
    public void setRue(String rue) {
        this.rue = rue;
    }
    public Redevable getRedevable() {
        return redevable;
    }
    public void setRedevable(Redevable redevable) {
        this.redevable = redevable;
    }
    public CategorieLocale getCategorielocale() {
        return categorieLocale;
    }
    public void setCategorielocale(CategorieLocale categorieLocale) {
        this.categorieLocale = categorieLocale;
    }
    public Secteur getSecteur() {
        return secteur;
    }
    public void setSecteur(Secteur secteur) {
        this.secteur = secteur;
    }

}
