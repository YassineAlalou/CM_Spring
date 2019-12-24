package com.cabinetmedical.pfa.controller;


import com.cabinetmedical.pfa.classe.Medicament;
import com.cabinetmedical.pfa.service.MedicamentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicament")
public class MedicamentController {
    @Autowired
    private MedicamentService medicamentService;

    @GetMapping("/all")
    public List<Medicament> getAll(){
        return this.medicamentService.getAll();
    }
    @GetMapping("{id}")
    public Medicament getType(@PathVariable int id){
        return this.medicamentService.findById(id);
    }

    @PostMapping("/save")
    public Medicament saveMedicament(@RequestBody Medicament med){
        return this.medicamentService.save(med);
    }

    @DeleteMapping("/{id}")
    public void deleteMedicament(@PathVariable int id){
        this.medicamentService.deleteMedicament(id);
    }

    @PutMapping("/{id}")
    public Medicament updateMedicament(@PathVariable int id, @RequestBody Medicament med){
        return this.medicamentService.updateMedicament(med,id);
    }

}
