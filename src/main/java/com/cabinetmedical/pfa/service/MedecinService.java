package com.cabinetmedical.pfa.service;


import com.cabinetmedical.pfa.classe.Medecin;
import com.cabinetmedical.pfa.dao.MedecinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MedecinService {

    @Autowired
    private MedecinRepository medecinRepository;

    public List<Medecin> getAll(){

        return medecinRepository.findAll();
    }

    public  Medecin findById(int id){

        return medecinRepository.findById(id).get();
    }

    public Medecin save(Medecin medicament) {
        return medecinRepository.save(medicament);
    }

    public void deleteMedecin(int id) {

        medecinRepository.deleteById(id);
    }

    public Medecin updateMedecin(Medecin medecin, int id) {
        Medecin medEx = medecinRepository.getOne(id);
        medEx.setNom(medecin.getNom());
        medEx.setPrenom(medecin.getPrenom());
        medEx.setSpecialite(medecin.getSpecialite());
        medEx.setAdresse(medecin.getAdresse());
        medEx.setInfos(medecin.getInfos());
        medecinRepository.save(medEx);
        System.out.println(medEx);
        return medEx;
    }
}
