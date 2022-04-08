package com.example.taxeboisson.bean;

import javax.persistence.*;

@Entity
public class TauxTaxeBoisson {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String ref;
    private double pourcentage;

    @OneToOne
    private CategorieLocale categorieLocale;

    public CategorieLocale getCategorieLocale() {
        return categorieLocale;
    }

    public void setCategorieLocale(CategorieLocale categorieLocale) {
        this.categorieLocale = categorieLocale;
    }



    public void setId(Long id) {
        this.id = id;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public double getPourcentage() {
        return pourcentage;
    }

    public void setPourcentage(double pourcentage) {
        this.pourcentage = pourcentage;
    }

}
