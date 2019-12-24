package com.cabinetmedical.pfa.controller;


import com.cabinetmedical.pfa.classe.User;
import com.cabinetmedical.pfa.service.UserService;
import com.cabinetmedical.pfa.service.UserServiceImpl;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/User")
public class UserController {

    @Autowired
    private UserService userService ;

    @Autowired
    UserServiceImpl userServiceimpl ;

    @PostMapping("/register")
    public User register(@RequestBody UserForm user){
        return userService.saveUserR(user.getNom(),user.getPrenom(),user.getAge(),user.getPassword(),user.getTel(),user.getUsername(),user.getRepassword());
    }
    @GetMapping("/all")
    public List<User> getAll(){
        return userServiceimpl.getAll();
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable long id) {
        return userServiceimpl.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable long  id){
        userServiceimpl.deleteUser(id);
    }

    @PutMapping("/{id}")
    public User updateUser(@RequestBody User user, @PathVariable long id)
    {
        return userServiceimpl.updateUser(user,id);
    }

    @PutMapping("/activer/{username}")
    public void Activer(@PathVariable String username)
    {
        userServiceimpl.activerUser(username);
    }

    @PostMapping("/registerS")
    public User registerUser(@RequestBody UserForm user){
        return userService.saveUserS(user.getNom(),user.getPrenom(),user.getAge(),user.getPassword(),user.getTel(),user.getUsername(),user.getRepassword());
    }


}


@Data
class UserForm{
    private String nom;
    private String prenom;
    private double age;
    private String tel;
    private String username;
    private String password;
    private String repassword;


    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public double getAge() {
        return age;
    }

    public void setAge(double age) {
        this.age = age;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRepassword() {
        return repassword;
    }

    public void setRepassword(String repassword) {
        this.repassword = repassword;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
}

