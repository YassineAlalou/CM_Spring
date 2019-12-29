package com.cabinetmedical.pfa.service;


import com.cabinetmedical.pfa.classe.TypeConsultation;
import com.cabinetmedical.pfa.dao.TypeConsultationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TypeConsultationService {
    @Autowired
    private TypeConsultationRepository typeConsultationRepository;

    public List<TypeConsultation> getAll(){
        return this.typeConsultationRepository.findAll();
    }

    public TypeConsultation findById(int id){
        return typeConsultationRepository.findById(id).get();
    }

    public TypeConsultation saveType(TypeConsultation t){
        TypeConsultation tp = new TypeConsultation();
        tp.setLibelle(t.getLibelle());
        this.typeConsultationRepository.save(tp);
        return tp;
    }

    public void deleteType(int id){
        this.typeConsultationRepository.deleteById(id);
    }

    public TypeConsultation updateType(TypeConsultation tp, int id){
        TypeConsultation a= typeConsultationRepository.getOne(id);
        a.setLibelle(tp.getLibelle());
        this.typeConsultationRepository.save(a);
        return a;
    }


}
