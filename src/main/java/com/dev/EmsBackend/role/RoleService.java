package com.dev.EmsBackend.role;
// This class will contain all the business logics we need to implement for user roles

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {

    private final RoleRepository roleRepository;
    @Autowired
    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }


    public List<Role> getRole(){
        // method to get all user roles
        return roleRepository.findAll();
    }
}
