package com.cabinetmedical.pfa.dao;


import com.cabinetmedical.pfa.classe.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import java.io.Serializable;

@RepositoryRestResource
public interface UserRepository extends JpaRepository<User,Long>, Serializable {
        public User findByUsername(String username);
}
