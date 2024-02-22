package com.dev.EmsBackend.emsuser;
// This class will contain all the business logics we need to implement for emsusers

import com.dev.EmsBackend.role.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class EmsUserService implements UserDetailsService {

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

    @Autowired
    private PasswordEncoder encoder;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("Program on user details service.");

        return userRepository.findEmsUserByEmail(username).orElseThrow(() -> new UsernameNotFoundException("invalid user !"));
    }

}
