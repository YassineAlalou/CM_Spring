package com.cabinetmedical.pfa.controller;


import com.cabinetmedical.pfa.classe.TypeConsultation;
import com.cabinetmedical.pfa.service.TypeConsultationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/typeconsultation")
public class TypeConsultationController {
    @Autowired
    private TypeConsultationService typeConsultationService;

    @GetMapping("/all")
    public List<TypeConsultation> getAll(){
        return this.typeConsultationService.getAll();
    }
    @GetMapping("{id}")
    public TypeConsultation getType(@PathVariable int id){
        return this.typeConsultationService.findById(id);
    }

    @PostMapping("/save")
    public TypeConsultation saveType(@RequestBody TypeConsultation tp){
        return this.typeConsultationService.saveType(tp);
    }

    @DeleteMapping("/{id}")
    public void deleteType(@PathVariable int id){
        this.typeConsultationService.deleteType(id);
    }

    @PutMapping("/{id}")
    public TypeConsultation updateType(@PathVariable int id, @RequestBody TypeConsultation tp){
        return this.typeConsultationService.updateType(tp,id);
    }

}
