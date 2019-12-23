package com.cabinetmedical.pfa.service;

import com.cabinetmedical.pfa.classe.Consultation;
import com.cabinetmedical.pfa.dao.ConsultationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ConsultationService {

    @Autowired
    private ConsultationRepository consultationRepository;

    public List<Consultation> getAll(){
        return this.consultationRepository.findAll();
    }

    public Consultation findById(int id){
        return this.consultationRepository.findById(id).get();
    }

    public Consultation saveConsultation(Consultation c){
        Consultation ct = new Consultation();

        ct.setDateC(c.getDateC());
        ct.setDiagnostic(c.getDiagnostic());
        ct.setMotif(c.getMotif());
        ct.setPrice(c.getPrice());

        return ct;
    }

    public void deleteConsultation(int id){
        this.consultationRepository.deleteById(id);
    }

    public Consultation updateConsultation(Consultation c, int id){
        Consultation ct = consultationRepository.getOne(id);
        ct.setPrice(c.getPrice());
        ct.setMotif(c.getMotif());
        ct.setDiagnostic(c.getDiagnostic());
        ct.setDateC(c.getDateC());
        this.consultationRepository.save(ct);
        return ct;
    }
}
