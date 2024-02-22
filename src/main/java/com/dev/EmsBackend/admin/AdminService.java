package com.dev.EmsBackend.admin;

import com.dev.EmsBackend.emsuser.EmsUser;
import com.dev.EmsBackend.emsuser.EmsUserService;
import com.dev.EmsBackend.role.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AdminService {

    private final EmsUserService userService;

    @Autowired
    public AdminService(EmsUserService userService) {
        this.userService = userService;
    }

    public void viewAllTeachers() {
        // Logic to view all teachers
    }

    public void viewAllStudents() {
        // Logic to view all students
    }

    public void addRoleToUser(UUID userId, Role role) {
        // Logic to add roles to users (TEACHER or STUDENT)
    }

    public void deactivateUser(UUID userId) {
        // Logic to deactivate a user
    }

    public void createDefaultAdminAccount() {
        // Logic to create a default admin account
        // Ensure ADMIN role is assigned
    }
}
