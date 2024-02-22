package com.dev.EmsBackend.admin;

import com.dev.EmsBackend.role.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @GetMapping("/")
    public String hello(){
        return "Hello from admin.";
    }


//    private final AdminService adminService;
//
//    @Autowired
//    public AdminController(AdminService adminService) {
//        this.adminService = adminService;
//    }
//
//    @GetMapping("/teachers")
//    public void viewAllTeachers() {
//        adminService.viewAllTeachers();
//    }
//
//    @GetMapping("/students")
//    public void viewAllStudents() {
//        adminService.viewAllStudents();
//    }
//
//    @PostMapping("/addRole")
//    public void addRoleToUser(@RequestParam UUID userId, @RequestParam Role role) {
//        adminService.addRoleToUser(userId, role);
//    }
//
//    @PostMapping("/deactivate")
//    public void deactivateUser(@RequestParam UUID userId) {
//        adminService.deactivateUser(userId);
//    }
//
//    @PostMapping("/createDefaultAdmin")
//    public void createDefaultAdminAccount() {
//        adminService.createDefaultAdminAccount();
//    }
}
