package com.cabinetmedical.pfa.controller;


import com.cabinetmedical.pfa.classe.Consultation;
import com.cabinetmedical.pfa.service.ConsultationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/consultation")
public class ConsultationController {

    @Autowired
    private ConsultationService consultationService;


    @GetMapping("/all")
    public List<Consultation> getAll(){
        return this.consultationService.getAll();
    }

    @PostMapping("/save")
    public Consultation saveConsultation(@RequestBody Consultation ct){
        return this.consultationService.saveConsultation(ct);
    }


    @DeleteMapping("{id}")
    public void deleteConsultation(@PathVariable int id){
        this.consultationService.deleteConsultation(id);
    }

    @PutMapping("{id}")
    public Consultation updateConsultation(@RequestBody Consultation ct, @PathVariable int id){
        return this.consultationService.updateConsultation(ct, id);
    }
}
