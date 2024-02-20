package com.dev.EmsBackend.emsuser;
// This interface will allow us to access the methods of CRUD operations offered by Spring Data JPA

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface EmsUserRepository extends JpaRepository<EmsUser, UUID> {

    Optional<EmsUser> findEmsUserByEmail(String email);

}
