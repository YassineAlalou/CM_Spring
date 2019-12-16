package com.cabinetmedical.pfa.dao;


import com.cabinetmedical.pfa.classe.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

public interface RoleRepository extends JpaRepository<Role,Integer>, Serializable {
    public Role findByLibelle(String Libelle);
}
