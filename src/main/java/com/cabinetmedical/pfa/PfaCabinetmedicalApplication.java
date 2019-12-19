package com.cabinetmedical.pfa;

import com.cabinetmedical.pfa.classe.Role;
import com.cabinetmedical.pfa.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class PfaCabinetmedicalApplication {

    public static void main(String[] args) {
        SpringApplication.run(PfaCabinetmedicalApplication.class, args);
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder()
    {
        return new BCryptPasswordEncoder();
    }

/*
	@Bean
    CommandLineRunner start(UserService userService){


		return args->{

		    userService.save( new Role(1,"ADMIN"));
			userService.save( new Role(2,"SECRETAIRE"));
			userService.save( new Role(3,"PATIENT"));



			userService.saveUser("Alalou" ,"yassine",23, "1234", "0677844627", "Admin" , "1234");
			userService.addRoleToUser("Admin","ADMIN");

            userService.saveUser("nomsec" ,"prenomsec",25, "1234", "0677844699", "User1" , "1234");
            userService.addRoleToUser("User1","SECRETAIRE");

            userService.saveUser("Pat" ,"PatPrenom",12, "1234", "0677845555", "Patient1" , "1234");
            userService.addRoleToUser("Patient1","PATIENT");




		};
	}
*/

}
