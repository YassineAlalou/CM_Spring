package com.cabinetmedical.pfa.classe;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@ToString
public class Ordonnance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Temporal(TemporalType.DATE)
    private Date dateOr;

    @ManyToOne(fetch = FetchType.LAZY)
    private Consultation consultation;



    public Ordonnance() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDateOr() {
        return dateOr;
    }

    public void setDateOr(Date dateOr) {
        this.dateOr = dateOr;
    }
}
