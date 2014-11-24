package com.tsystems.logiweb2.Repository;

import com.tsystems.logiweb2.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Class provided CRUD-operations for User entity
 * Operations implements by Spring Data JPA
 */
public interface UserRepository extends JpaRepository<User, Long> {
}
