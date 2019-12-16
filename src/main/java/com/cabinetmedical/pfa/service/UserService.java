package com.cabinetmedical.pfa.service;



import com.cabinetmedical.pfa.classe.Role;
import com.cabinetmedical.pfa.classe.User;

import java.util.List;

public interface UserService {
    public User saveUser(String nom, String prenom, double age, String tel, String username, String password, String confirmedPassword);
    public Role save(Role role);
    public User loadUserByUsername(String username);
    public void addRoleToUser(String username,String rolename);


    List<User> getAll();

    User saveUserR(String nom, String prenom, double age, String tel, String username, String password, String repassword, long id);
}
