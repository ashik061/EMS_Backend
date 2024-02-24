package com.dev.EmsBackend.emsuser;
//This class will expose the APIs for emsusers

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/user")
@CrossOrigin("*")
public class EmsUserController {

    private final EmsUserService userService;

    @Autowired
    public EmsUserController(EmsUserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String hello(){
        return "Hello from user.";
    }

    @GetMapping("/profile/{uuid}")
    public ResponseEntity<EmsUser> viewUserDetails(@PathVariable UUID uuid){
        return userService.viewUserDetails(uuid);
    }

    @PutMapping("/profile/{uuid}")
    public ResponseEntity<EmsUser> updateUserProfile(@PathVariable UUID uuid, @RequestBody EmsUser emsUserDetails){
        return userService.updateUserDetails(uuid, emsUserDetails);
    }

}