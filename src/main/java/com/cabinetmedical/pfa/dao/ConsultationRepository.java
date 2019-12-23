package com.cabinetmedical.pfa.dao;

import com.cabinetmedical.pfa.classe.Consultation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

public interface ConsultationRepository extends JpaRepository<Consultation, Integer>, Serializable {

}
