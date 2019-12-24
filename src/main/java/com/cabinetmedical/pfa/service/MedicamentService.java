package com.cabinetmedical.pfa.service;


import com.cabinetmedical.pfa.classe.Medicament;
import com.cabinetmedical.pfa.dao.MedicamentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional

public class MedicamentService {

    @Autowired
    private MedicamentRepository medicamentRepository;

    public List<Medicament> getAll(){

        return medicamentRepository.findAll();
    }

    public  Medicament findById(int id){

        return medicamentRepository.findById(id).get();
    }

    public Medicament save(Medicament medicament) {
        return medicamentRepository.save(medicament);
    }

    public void deleteMedicament(int id) {

        medicamentRepository.deleteById(id);
    }

    public Medicament updateMedicament(Medicament medicament, int id) {
        Medicament medEx = medicamentRepository.getOne(id);
        medEx.setLibelle(medicament.getLibelle());
        medEx.setFamille(medicament.getFamille());
        medEx.setQuantite(medicament.getQuantite());
        medEx.setDateex(medicament.getDateex());

        medicamentRepository.save(medEx);
        System.out.println(medEx);
        return medEx;
    }



}
