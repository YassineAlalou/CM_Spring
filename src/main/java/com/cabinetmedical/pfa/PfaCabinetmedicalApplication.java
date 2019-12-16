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

		    //userService.save( new Role(1,"ADMIN"));
			//userService.save( new Role(2,"SECRETAIRE"));



			userService.saveUser("admin" ,"admin",99, "admin", "1234", "1234" , "090909090");

			userService.addRoleToUser("admin","ADMIN");

			userService.saveUser("ADMIN" ,"Admin",22, "0676767676", "admin", "admin", "admin");
			userService.addRoleToUser("admin","ADMIN");


		};
	}

*/

}
