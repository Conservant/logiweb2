package com.tsystems.logiweb2.Repository;

import com.tsystems.logiweb2.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by StarKiller on 22.11.2014.
 */
public interface UserRepository extends JpaRepository<User, Long> {
}
