package com.cabinetmedical.pfa.classe;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@ToString
public class Consultation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Temporal(TemporalType.DATE)
    private Date dateC;
    private String motif;
    private String diagnostic;
    private long price;



    @ManyToOne(fetch = FetchType.LAZY)
    private TypeConsultation typeConsultation;


    public Consultation() {
    }


    public int getId() {
        return id;
    }

    public Date getDateC() {
        return dateC;
    }

    public String getMotif() {
        return motif;
    }

    public String getDiagnostic() {
        return diagnostic;
    }

    public long getPrice() {
        return price;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDateC(Date dateC) {
        this.dateC = dateC;
    }

    public void setMotif(String motif) {
        this.motif = motif;
    }

    public void setDiagnostic(String diagnostic) {
        this.diagnostic = diagnostic;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public TypeConsultation getTypeConsultation() {
        return typeConsultation;
    }

    public void setTypeConsultation(TypeConsultation typeConsultation) {
        this.typeConsultation = typeConsultation;
    }
}
