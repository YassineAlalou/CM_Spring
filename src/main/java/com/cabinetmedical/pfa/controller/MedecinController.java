package com.cabinetmedical.pfa.controller;


import com.cabinetmedical.pfa.classe.Medecin;
import com.cabinetmedical.pfa.service.MedecinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medecin")
public class MedecinController {

    @Autowired
    private MedecinService medecinService;

    @GetMapping("/all")
    public List<Medecin> getAll(){
        return this.medecinService.getAll();
    }
    @GetMapping("{id}")
    public Medecin getType(@PathVariable int id){
        return this.medecinService.findById(id);
    }
    @PostMapping("/save")
    public Medecin saveMedecin(@RequestBody Medecin med){
        return this.medecinService.save(med);
    }

    @DeleteMapping("/{id}")
    public void deleteMedecin(@PathVariable int id){
        this.medecinService.deleteMedecin(id);
    }

    @PutMapping("/{id}")
    public Medecin updateMedecin(@PathVariable int id, @RequestBody Medecin med){
        return this.medecinService.updateMedecin(med,id);
    }

}
