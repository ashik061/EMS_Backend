package com.dev.EmsBackend.emsuser;
// This is the class for EmsUser table of database

import com.dev.EmsBackend.role.Role;
import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name = "emsuser")
public class EmsUser implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id", updatable = false, nullable = false)
    private UUID userId;
    @Column(name = "email", nullable = false, unique = true)
    private String email;
    private String phone;
    private String name;
    @Column(name = "password", nullable = false)
    private String password;
    private boolean status = true; // User is active by default

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_role_join",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id")}
    )
    private Set<Role> authorities;

    public EmsUser() {
        super();
        this.authorities = new HashSet<Role>();
    }

    public EmsUser(String email, String password) {
        super();
        this.email = email;
        this.password = password;
    }

    public EmsUser(String email, String password, Set<Role> authorities) {
        this.email = email;
        this.password = password;
        this.authorities = authorities;
    }

    public EmsUser(UUID userId, String email, String phone, String name, String password, boolean status, Set<Role> authorities) {
        this.userId = userId;
        this.email = email;
        this.phone = phone;
        this.name = name;
        this.password = password;
        this.status = status;
        this.authorities = authorities;
    }

    public EmsUser(String email, String phone, String name, String password) {
        super();
        this.email = email;
        this.phone = phone;
        this.name = name;
        this.password = password;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    public void setAuthorities(Set<Role> authorities){
        this.authorities = authorities;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
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

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }


}
