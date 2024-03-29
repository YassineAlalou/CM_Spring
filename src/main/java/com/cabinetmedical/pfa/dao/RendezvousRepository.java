package com.cabinetmedical.pfa.dao;

import com.cabinetmedical.pfa.classe.Rendezvous;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.io.Serializable;
import java.util.List;

@RepositoryRestResource
public interface RendezvousRepository extends JpaRepository<Rendezvous,Integer>, Serializable {
    public List<Rendezvous> findByDater(String dater);
}
