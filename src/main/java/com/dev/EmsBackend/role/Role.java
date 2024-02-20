package com.dev.EmsBackend.role;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
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

    @Override
    public String toString() {
        return "Role{" +
                "roleId='" + roleId + '\'' +
                ", role='" + role + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
