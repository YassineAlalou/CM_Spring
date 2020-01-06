package com.cabinetmedical.pfa.controller;

import com.cabinetmedical.pfa.classe.Consultation;
import com.cabinetmedical.pfa.classe.Ordonnance;
import com.cabinetmedical.pfa.service.ConsultationService;
import com.cabinetmedical.pfa.service.OrdonnanceService;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ordonnance")
public class OrdonnanceController {

    @Autowired
    private OrdonnanceService ordonnanceService;
    @Autowired
    private ConsultationService consultationService;

    @GetMapping("/all")
    public List<Ordonnance> getAll(){
        return ordonnanceService.getAll();
    }

    @GetMapping("/{id}")
    public Ordonnance findById(@PathVariable int id){
        return ordonnanceService.findById(id);
    }

    @PostMapping("/save/{id}")
    public Ordonnance save(@RequestBody Ordonnance or, @PathVariable int id){
//        Consultation cn = consultationService.findById(id);
//        or.setConsultation(cn);
//        System.out.println(or);
        System.out.println("-------------------------------------HOROBOO--------------------------------------------------");
        return ordonnanceService.save(or, id);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        ordonnanceService.delete(id);
    }

    @PutMapping("/{id}")
    public Ordonnance update(@RequestBody Ordonnance or, @PathVariable int id){
        return ordonnanceService.update(or,id);
    }

}
