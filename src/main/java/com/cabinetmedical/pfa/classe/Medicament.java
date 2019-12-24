package com.cabinetmedical.pfa.classe;


import lombok.Data;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@ToString
public class Medicament {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String libelle;
    private String famille;
    private int quantite;
    private String dateex;

    public Medicament(String libelle, String famille, int quantite, String dateex) {
        this.libelle = libelle;
        this.famille = famille;
        this.quantite = quantite;
        this.dateex = dateex;
    }

    public Medicament() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getFamille() {
        return famille;
    }

    public void setFamille(String famille) {
        this.famille = famille;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public String getDateex() {
        return dateex;
    }

    public void setDateex(String dateex) {
        this.dateex = dateex;
    }
}
