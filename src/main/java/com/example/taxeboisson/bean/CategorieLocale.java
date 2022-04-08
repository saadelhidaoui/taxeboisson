package com.example.taxeboisson.bean;

import javax.persistence.*;
import java.util.List;

@Entity
public class CategorieLocale {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String ref;
    private String description;
     @OneToOne
     TauxTaxeBoisson tauxTaxeBoisson;

    public Long getId() {
        return id;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
