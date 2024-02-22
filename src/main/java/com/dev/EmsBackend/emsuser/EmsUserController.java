package com.dev.EmsBackend.emsuser;
//This class will expose the APIs for emsusers

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/user")
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

//    @GetMapping
//    public List<EmsUser> getAllUsers(){
//        return userService.getAllUsers();
//    }
//
//    @PostMapping
//    public void addNewUser(@RequestBody EmsUser emsUser){
//        userService.addNewUser(emsUser);
//    }

}