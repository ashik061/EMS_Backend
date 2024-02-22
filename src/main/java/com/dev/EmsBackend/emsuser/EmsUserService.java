package com.dev.EmsBackend.emsuser;
// This class will contain all the business logics we need to implement for emsusers

import com.dev.EmsBackend.role.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmsUserService implements UserDetailsService {

    private final EmsUserRepository userRepository;

    @Autowired
    public EmsUserService(EmsUserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Autowired
    private PasswordEncoder encoder;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("Program on user details service.");

        return userRepository.findEmsUserByEmail(username).orElseThrow(() -> new UsernameNotFoundException("invalid user !"));
    }

    public ResponseEntity<EmsUser> viewUserDetails(UUID uuid) {
        EmsUser emsUser = userRepository.findById(uuid)
                .orElseThrow(()-> new IllegalStateException("User not found !"));
        return ResponseEntity.ok(emsUser);
    }

    public ResponseEntity<EmsUser> updateUserDetails(UUID uuid, EmsUser emsUserDetails) {
        EmsUser emsUser = userRepository.findById(uuid)
                .orElseThrow(()-> new IllegalStateException("User not found !"));
        emsUser.setEmail(emsUserDetails.getEmail());
        emsUser.setName(emsUserDetails.getName());
        emsUser.setPhone(emsUserDetails.getPhone());
        emsUser.setPassword(emsUserDetails.getPassword());

        EmsUser updatedUser = userRepository.save(emsUser);
        return ResponseEntity.ok(updatedUser);
    }


}
