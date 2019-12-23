package com.cabinetmedical.pfa.dao;

import com.cabinetmedical.pfa.classe.TypeConsultation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

public interface TypeConsultationRepository extends JpaRepository<TypeConsultation, Integer>, Serializable {
}
