package com.cabinetmedical.pfa.dao;

import com.cabinetmedical.pfa.classe.Ordonnance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

public interface OrdonnanceRepository extends JpaRepository<Ordonnance, Integer>, Serializable {
}
