package com.dev.EmsBackend.emsuser;
// This class will contain all the business logics we need to implement for emsusers

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmsUserService {

    private final EmsUserRepository userRepository;

    @Autowired
    public EmsUserService(EmsUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<EmsUser> getAllUsers() {
        return userRepository.findAll();
    }

    public void addNewUser(EmsUser emsUser) {
        Optional<EmsUser> userByEmail= userRepository
                .findEmsUserByEmail(emsUser.getEmail());
        if (userByEmail.isPresent()){
            throw new IllegalStateException("This email is already registered");
        }
        userRepository.save(emsUser);
    }


}
