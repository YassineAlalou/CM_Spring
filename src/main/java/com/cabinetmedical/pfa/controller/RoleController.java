package com.cabinetmedical.pfa.controller;


import com.cabinetmedical.pfa.classe.Role;
import com.cabinetmedical.pfa.dao.RoleRepository;
import com.cabinetmedical.pfa.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/Role")
public class RoleController {


    @Autowired
    private RoleService roleService;
    @Autowired
    private RoleRepository roleRepository;



    @GetMapping("/all")
    public List<Role> getAll(){
        return roleService.getAll();
    }

    @GetMapping("/{id}")
    public Role getRole(@PathVariable int id){
        return roleService.findById(id);
    }

    @PostMapping("/saveRole")
    public Role saveRole(@RequestBody Role r){
        roleService.saveRole(r);
        return roleService.findById(r.getId());
    }

    @PutMapping("/{id}")
    public Role updateRole(@RequestBody Role role, @PathVariable int id)
    {
        System.out.println(role);
        return roleService.updateRole(role,id);
    }

    @DeleteMapping("/{id}")
    public void deleteRole(@PathVariable long  id){
        roleService.deleteRole(id);
    }

}

