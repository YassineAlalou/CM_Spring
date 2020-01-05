package com.cabinetmedical.pfa.service;

import com.cabinetmedical.pfa.classe.Rendezvous;
import com.cabinetmedical.pfa.dao.RendezvousRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RendezvousService {
    @Autowired
    private RendezvousRepository rendezvousRepository;

    public List<Rendezvous> getAll(){
        return this.rendezvousRepository.findAll();
    }

    public Rendezvous findById(int id){
        return this.rendezvousRepository.findById(id).get();
    }

    public List<Rendezvous> findByDater(String dater) {return this.rendezvousRepository.findByDater(dater);}

    public Rendezvous saveRendezvous(Rendezvous r){
        return rendezvousRepository.save(r);
    }



    public void deleteRendezvous(int id){
        this.rendezvousRepository.deleteById(id);
    }

    public Rendezvous updateRendezvous(Rendezvous c, int id){
        Rendezvous ct = rendezvousRepository.getOne(id);
        ct.setDater(c.getDater());
        ct.setMotif(c.getMotif());
        ct.setDiagnostic(c.getDiagnostic());
        ct.setPrice(c.getPrice());
        ct.setUser(c.getUser());
        ct.setTypeConsultation(c.getTypeConsultation());

        this.rendezvousRepository.save(ct);
        return ct;
    }



}
