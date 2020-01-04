package com.cabinetmedical.pfa.classe;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Getter
@Setter
public class Rendezvous {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String dater;
    private String motif;

    @ManyToOne(fetch = FetchType.EAGER)
    private User user;


    public Rendezvous() {
    }

    public Rendezvous(String dater, String motif, User user, Consultation consultation) {
        this.dater = dater;
        this.motif = motif;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDater() {
        return dater;
    }

    public void setDater(String dater) {
        this.dater = dater;
    }

    public String getMotif() {
        return motif;
    }

    public void setMotif(String motif) {
        this.motif = motif;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
