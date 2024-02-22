package com.dev.EmsBackend;

import com.dev.EmsBackend.emsuser.EmsUser;
import com.dev.EmsBackend.emsuser.EmsUserRepository;
import com.dev.EmsBackend.role.Role;
import com.dev.EmsBackend.role.RoleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashSet;
import java.util.Set;


@SpringBootApplication
public class EmsBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmsBackendApplication.class, args);

	}

	@Bean
	CommandLineRunner commandLineRunner(RoleRepository roleRepository, EmsUserRepository emsUserRepository, PasswordEncoder passwordEncoder){
		return args -> {
			if (roleRepository.findByAuthority("ADMIN").isPresent()){
				return;
			}
			Role adminRole= roleRepository.save(new Role(1,"ADMIN","This is an admin user."));
			roleRepository.save(new Role(2,"STUDENT","This is a student user."));
			roleRepository.save(new Role(3,"TEACHER","This is a teacher user."));
			Set<Role> roles = new HashSet<>();
			roles.add(adminRole);
			EmsUser admin = new EmsUser("ashik18710@gmail.com", passwordEncoder.encode("1871"), roles);
			emsUserRepository.save(admin);
		};
	}

}
