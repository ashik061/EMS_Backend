package com.dev.EmsBackend.admin;

import com.dev.EmsBackend.emsuser.EmsUser;
import com.dev.EmsBackend.role.Role;
import com.dev.EmsBackend.role.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/admin")
@CrossOrigin("*")
public class AdminController {

    @GetMapping("/")
    public String hello(){
        return "Hello from admin.";
    }

    @Autowired
    private final AdminService adminService;
    @Autowired
    private final RoleService roleService;

    public AdminController(AdminService adminService, RoleService roleService) {
        this.adminService = adminService;
        this.roleService = roleService;
    }

    @GetMapping("/users")
    public List<EmsUser> viewAllUsers() {
        return adminService.viewAllUsers();
    }
    @GetMapping("/roles")
    public List<Role> getRole(){
        return roleService.getRole();
    }

    @PostMapping("/user/new")
    public EmsUser createNewUser(@RequestBody EmsUser emsUser){
        return adminService.createNewUser(emsUser);
    }
    @GetMapping("user/profile/{uuid}")
    public ResponseEntity<EmsUser> viewUserDetails(@PathVariable UUID uuid){
        return adminService.viewUserDetails(uuid);
    }

    @PutMapping("/user/profile/{uuid}")
    public ResponseEntity<EmsUser> updateUserProfile(@PathVariable UUID uuid, @RequestBody EmsUser emsUserDetails){
        return adminService.updateUserDetails(uuid, emsUserDetails);
    }

    @DeleteMapping("/user/profile/{uuid}")
    public ResponseEntity<Map<String, Boolean>> deleteUser(@PathVariable UUID uuid){
        return adminService.deleteUser(uuid);
    }



}
