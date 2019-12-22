package com.cabinetmedical.pfa.service;


import com.cabinetmedical.pfa.classe.Role;
import com.cabinetmedical.pfa.classe.User;
import com.cabinetmedical.pfa.dao.RoleRepository;
import com.cabinetmedical.pfa.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional

public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    @Override
    public User saveUser(String nom, String prenom, double age,  String password, String tel, String username, String confirmedPassword) {
        User user = userRepository.findByUsername(username);
        if( user != null)
            throw new RuntimeException("User Already Exists");
        //if ( !password.equals(confirmedPassword))
          //  throw new RuntimeException(("les mots de passes ne correspondent pas !"));
        User User1 = new User();
        User1.setUsername(username);
        User1.setPassword(bCryptPasswordEncoder.encode(password));
        User1.setAge(age);
        User1.setNom(nom);
        User1.setPrenom(prenom);
        User1.setTel(tel);
        userRepository.save(User1);
        addRoleToUser(username,"PATIENT");
        System.out.println(User1);
        return User1;
    }

    @Override
    public Role save(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public User loadUserByUsername(String login) {
        return userRepository.findByUsername(login);
    }

    @Override
    public void addRoleToUser(String login, String rolename) {
        User user = userRepository.findByUsername(login);
        Role role = roleRepository.findByLibelle(rolename);
        user.getRoles().add(role);
    }

    @Override
    public List<User> getAll(){

        return userRepository.findAll();
    }

    public void deleteUser(long id) {

        userRepository.deleteById(id);
    }

    public User updateUser(User user, long id) {
        User userEx = userRepository.getOne(id);
        userEx.setUsername(user.getUsername());
        if( user.getPassword() != "")
        {
            userEx.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
            System.out.println(user.getPassword());
        }

        userRepository.save(userEx);
        System.out.println(userEx);
        return userEx;
    }

    public User findById(long id) {

        return userRepository.findById(id).get();
    }

    @Override
    public User saveUserR(String nom, String prenom, double age,  String password, String tel, String username, String confirmedPassword) {

        User user1 = userRepository.findByUsername(username);
        if( user1 != null)
            throw new RuntimeException("User Already Exists");
        if ( ! password.equals(confirmedPassword))
            throw new RuntimeException(("les mots de passes ne correspondent pas !"));
        User user = new User();
        user.setUsername(username);
        user.setPassword(bCryptPasswordEncoder.encode(password));
        user.setAge(age);
        user.setNom(nom);
        user.setPrenom(prenom);
        user.setTel(tel);
        userRepository.save(user);
        // addRoleToUser(username,"PATIENT");
        return user;
    }

    @Override
    public User saveUserS(String nom, String prenom, double age,  String password, String tel, String username, String confirmedPassword) {

        User user1 = userRepository.findByUsername(username);
        if( user1 != null)
            throw new RuntimeException("User Already Exists");
        if ( ! password.equals(confirmedPassword))
            throw new RuntimeException(("les mots de passes ne correspondent pas !"));
        User user = new User();
        user.setUsername(username);
        user.setPassword(bCryptPasswordEncoder.encode(password));
        user.setAge(age);
        user.setNom(nom);
        user.setPrenom(prenom);
        user.setTel(tel);
        userRepository.save(user);
        addRoleToUser(username,"SECRETAIRE");
        return user;
    }

}
