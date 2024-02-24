package com.dev.EmsBackend.role;
//This class will expose the APIs for roles

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/role")
@CrossOrigin("*")
public class RoleController {

    private final RoleService roleService;
    @Autowired
    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping
    public List<Role> getRole(){
        return roleService.getRole();
    }

}
