package com.dev.EmsBackend.admin;

import com.dev.EmsBackend.emsuser.EmsUser;
import com.dev.EmsBackend.emsuser.EmsUserRepository;
import com.dev.EmsBackend.emsuser.EmsUserService;
import com.dev.EmsBackend.role.Role;
import com.dev.EmsBackend.role.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AdminService {

    @Autowired
    private final EmsUserRepository userRepository;
    @Autowired
    private final RoleRepository roleRepository;

    public AdminService(EmsUserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    public List<EmsUser> viewAllUsers() {
        return userRepository.findAll();
    }

    public EmsUser createNewUser(EmsUser emsUser) {
        return userRepository.save(emsUser);
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
        emsUser.setStatus(emsUserDetails.isStatus());

        EmsUser updatedUser = userRepository.save(emsUser);
        return ResponseEntity.ok(updatedUser);
    }

    public ResponseEntity<Map<String, Boolean>> deleteUser(UUID uuid) {
        EmsUser emsUser = userRepository.findById(uuid)
                .orElseThrow(()-> new IllegalStateException("User not found !"));

        userRepository.delete(emsUser);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
