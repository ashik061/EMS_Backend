package com.dev.EmsBackend.authentication;

import com.dev.EmsBackend.emsuser.EmsUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")    
@CrossOrigin("*")
public class AuthenticationController {

    @Autowired
    private final AuthenticationService authenticationService;

    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/register")
    public EmsUser registerNewUser(@RequestBody RegistrationDTO body){
        return authenticationService.registerNewUser(body.getEmail(), body.getPassword());
    }
}
