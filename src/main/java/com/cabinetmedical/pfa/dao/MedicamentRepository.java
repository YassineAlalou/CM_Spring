package com.cabinetmedical.pfa.dao;


import com.cabinetmedical.pfa.classe.Medicament;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.io.Serializable;

@RepositoryRestResource
public interface MedicamentRepository extends JpaRepository<Medicament,Integer>, Serializable {
    public Medicament findByLibelle(String libelle);
}
