package com.dev.EmsBackend.role;
// This interface will allow us to access the methods of CRUD operations offered by Spring Data JPA

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role,String > {

}
