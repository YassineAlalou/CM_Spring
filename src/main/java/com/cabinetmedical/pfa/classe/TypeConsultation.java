package com.cabinetmedical.pfa.classe;

import antlr.collections.List;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@ToString
public class TypeConsultation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String libelle;

    @JsonIgnore
    @OneToMany(mappedBy = "typeConsultation", cascade = CascadeType.ALL)
    private Set<Consultation> consultations;

    public TypeConsultation() {
    }


    public int getId() {
        return id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
}
