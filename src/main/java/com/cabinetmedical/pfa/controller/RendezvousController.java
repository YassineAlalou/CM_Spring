package com.cabinetmedical.pfa.controller;

import com.cabinetmedical.pfa.classe.Rendezvous;
import com.cabinetmedical.pfa.classe.User;
import com.cabinetmedical.pfa.dao.UserRepository;
import com.cabinetmedical.pfa.service.RendezvousService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rendezvous")
public class RendezvousController {

    @Autowired
    private RendezvousService rendezvousService;
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/all")
    public List<Rendezvous> getAll(){
        return this.rendezvousService.getAll();
    }

    @GetMapping("/dat/{dater}")
    public List<Rendezvous> getRdvbyDater(@PathVariable String dater){
        return this.rendezvousService.findByDater(dater);
    }

    @GetMapping("{id}")
    public Rendezvous getRdv(@PathVariable int id){
        return this.rendezvousService.findById(id);
    }

    @PostMapping("/{username}")
    public Rendezvous saveRendezvous(@RequestBody Rendezvous rdv, @PathVariable String  username){
        User user = userRepository.findByUsername(username);
        rdv.setUser(user);
        System.out.println(rdv.getUser());
        return rendezvousService.saveRendezvous(rdv);
    }

    @DeleteMapping("{id}")
    public void deleteRendezvous(@PathVariable int id){
        this.rendezvousService.deleteRendezvous(id);
    }

    @PutMapping("{id}")
    public Rendezvous updateConsultation(@RequestBody Rendezvous ct, @PathVariable int id){
        return this.rendezvousService.updateRendezvous(ct, id);
    }

}
