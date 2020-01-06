package com.cabinetmedical.pfa.service;

import com.cabinetmedical.pfa.classe.Consultation;
import com.cabinetmedical.pfa.classe.Ordonnance;
import com.cabinetmedical.pfa.dao.OrdonnanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class OrdonnanceService {
    @Autowired
    private OrdonnanceRepository ordonnanceRepository;
    @Autowired
    private ConsultationService consultationService;

    public List<Ordonnance> getAll(){
        return ordonnanceRepository.findAll();
    }

    public Ordonnance findById(int id){
        return ordonnanceRepository.findById(id).get();
    }

    public Ordonnance save(Ordonnance or, int id){
        Consultation ct = consultationService.findById(id);
        or.setConsultation(ct);
        return ordonnanceRepository.save(or);
    }

    public void delete(int id){
        ordonnanceRepository.deleteById(id);
    }

    public Ordonnance update(Ordonnance or, int id){
        Ordonnance ox = ordonnanceRepository.getOne(id);
        ox.setDateOr(or.getDateOr());
        ox.setConsultation(or.getConsultation());
        ordonnanceRepository.save(ox);
        return ox;
    }



}
