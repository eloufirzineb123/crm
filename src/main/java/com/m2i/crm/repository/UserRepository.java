package com.m2i.crm.repository;


import com.m2i.crm.model.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author elouf
 */
public interface UserRepository  extends JpaRepository<User, Long> {
    
   Optional <User> findByUsername(String username);

    
}
