package com.dev.EmsBackend.emsuser;
// This is the class for EmsUser table of database

import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name = "emsuser")
public class EmsUser {
    @Id
    @SequenceGenerator(
            name = "emsuser_sequence",
            sequenceName = "emsuser_sequence",
            allocationSize = 1)
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "emsuser_sequence")

//    @GeneratedValue(strategy = GenerationType.AUTO)

    @Column(name = "user_id", updatable = false, nullable = false)
    private UUID userId;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column(name = "name")
    private String name;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "status", nullable = false)
    private boolean status = true; // User is active by default

    @Column(name = "role_id")
    private String roleId = "student"; // A default user is a student

    public EmsUser(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public EmsUser(String email, String phone, String name, String password) {
        this.email = email;
        this.phone = phone;
        this.name = name;
        this.password = password;
    }

    public EmsUser() {

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    @Override
    public String toString() {
        return "EmsUser{" +
                "email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", status=" + status +
                ", roleId='" + roleId + '\'' +
                '}';
    }
}
