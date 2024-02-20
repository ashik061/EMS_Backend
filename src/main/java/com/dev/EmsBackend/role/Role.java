package com.dev.EmsBackend.role;
// This is the class for role table of the database

import jakarta.persistence.Entity;
import jakarta.persistence.*;

@Entity
@Table(name = "role")
public class Role {
    @Id
//    @SequenceGenerator(
//            name = "role_sequence",
//            sequenceName = "role_sequence",
//            allocationSize = 1)
//    @GeneratedValue(
//            strategy = GenerationType.SEQUENCE,
//            generator = "role_sequence")
    @Column(name = "role_id")
    private String roleId;
    @Column(name = "role")
    private String role;
    @Column(name = "description")
    private String description;

    public Role(String roleId, String role, String description) {
        this.roleId = roleId;
        this.role = role;
        this.description = description;
    }

    public Role() {

    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Role{" +
                "roleId='" + roleId + '\'' +
                ", role='" + role + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
