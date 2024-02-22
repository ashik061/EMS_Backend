package com.dev.EmsBackend.authentication;

import com.dev.EmsBackend.emsuser.EmsUser;
import com.dev.EmsBackend.emsuser.EmsUserRepository;
import com.dev.EmsBackend.role.Role;
import com.dev.EmsBackend.role.RoleRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Transactional
public class AuthenticationService {

    @Autowired
    private final EmsUserRepository emsUserRepository;
    @Autowired
    private final RoleRepository roleRepository;
    @Autowired
    private final PasswordEncoder passwordEncoder;

    public AuthenticationService(EmsUserRepository emsUserRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.emsUserRepository = emsUserRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public EmsUser registerNewUser(String email, String password){
        String encodedPassword = passwordEncoder.encode(password);
        Role usrRole = roleRepository.findByAuthority("STUDENT").get();// default user is a student
        Set<Role> authorities = new HashSet<>();
        authorities.add(usrRole);
        return emsUserRepository.save(new EmsUser(email,encodedPassword,authorities));
    }


}
