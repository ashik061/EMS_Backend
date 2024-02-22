package com.dev.EmsBackend.role;
// This interface will allow us to access the methods of CRUD operations offered by Spring Data JPA

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role,Integer > {
    Optional<Role> findByAuthority(String authority);

}
