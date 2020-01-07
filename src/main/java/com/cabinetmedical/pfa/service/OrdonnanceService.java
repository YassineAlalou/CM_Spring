package com.cabinetmedical.pfa.service;

import com.cabinetmedical.pfa.classe.Consultation;
import com.cabinetmedical.pfa.classe.Ordonnance;
import com.cabinetmedical.pfa.classe.Rendezvous;
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
    private RendezvousService rendezvousService;

    public List<Ordonnance> getAll(){
        return ordonnanceRepository.findAll();
    }

    public Ordonnance findById(int id){
        return ordonnanceRepository.findById(id).get();
    }

    public Ordonnance save(Ordonnance or, int id){
        Rendezvous ct = rendezvousService.findById(id);
        or.setRendezvous(ct);
        return ordonnanceRepository.save(or);
    }

    public void delete(int id){
        ordonnanceRepository.deleteById(id);
    }

    public Ordonnance update(Ordonnance or, int id){
        Ordonnance ox = ordonnanceRepository.getOne(id);
        ox.setRendezvous(or.getRendezvous());
        ordonnanceRepository.save(ox);
        return ox;
    }



}
