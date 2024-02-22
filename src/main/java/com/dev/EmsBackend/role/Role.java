package com.dev.EmsBackend.role;
// This is the class for role table of the database

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;

@Entity
@Table(name = "role")
public class Role implements GrantedAuthority {
    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "role_id")
    private Integer roleId;
    @Column(name = "role")
    private String authority;
    @Column(name = "description")
    private String description;

    public Role(Integer roleId, String authority, String description) {
        super();
        this.roleId = roleId;
        this.authority = authority;
        this.description = description;
    }

    public Role(String authority) {
        this.authority=authority;
    }

    public Role() {
        super();
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String getAuthority() {
        return this.authority;
    }

    public void setAuthority(){
        this.authority=authority;
    }

}
