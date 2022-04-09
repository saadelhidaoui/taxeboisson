package com.example.taxeboisson.bean;

import javax.persistence.*;

@Entity
public class TaxeBoisson {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String ref;
    private int annee;
    private int trim;
    private double chiffreAffaire;
    private double pourcentageApplique;
    private double montantBase;

    @ManyToOne
    private Locale locale;

    @ManyToOne
    private Redevable redevable;


    public Locale getLocale() {
        return locale;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }

    public String getRef() {
        return ref;
    }
    public void setRef(String ref) {
        this.ref = ref;
    }
    public int getAnnee() {
        return annee;
    }
    public void setAnnee(int annee) {
        this.annee = annee;
    }
    public int getTrim() {
        return trim;
    }
    public void setTrim(int trim) {
        this.trim = trim;
    }
    public double getChiffreAffaire() {
        return chiffreAffaire;
    }
    public void setChiffreAffaire(double chiffreAffaire) {
        this.chiffreAffaire = chiffreAffaire;
    }
    public double getPourcentageApplique() {
        return pourcentageApplique;
    }
    public void setPourcentageApplique(double pourcentageApplique) {
        this.pourcentageApplique = pourcentageApplique;
    }
    public double getMontantBase() {
        return montantBase;
    }
    public void setMontantBase(double montantBase) {
        this.montantBase = montantBase;
    }



}
