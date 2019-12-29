package com.cabinetmedical.pfa.controller;


import com.cabinetmedical.pfa.classe.Consultation;
import com.cabinetmedical.pfa.classe.TypeConsultation;
import com.cabinetmedical.pfa.service.ConsultationService;
import com.cabinetmedical.pfa.service.TypeConsultationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/consultation")
public class ConsultationController {

    @Autowired
    private ConsultationService consultationService;
    @Autowired
    private TypeConsultationService typeConsultationService;


    @GetMapping("/all")
    public List<Consultation> getAll(){
        return this.consultationService.getAll();
    }

    @GetMapping("{id}")
    public Consultation getConsultation(@PathVariable int id){
        return this.consultationService.findById(id);
    }
    @PostMapping("/save/{id}")
    public Consultation saveConsultation(@RequestBody Consultation ct, @PathVariable int id){
        TypeConsultation tp = typeConsultationService.findById(id);
        ct.setTypeConsultation(tp);

        return consultationService.saveConsultation(ct);
    }


    @DeleteMapping("{id}")
    public void deleteConsultation(@PathVariable int id){
        consultationService.deleteConsultation(id);
    }

    @PutMapping("{id}")
    public Consultation updateConsultation(@RequestBody Consultation ct, @PathVariable int id){
        return consultationService.updateConsultation(ct, id);
    }
}
