package com.TP.TEST.repository;


import com.TP.TEST.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User,Long> {

    @Query(""" 
            SELECT u FROM User u WHERE u.username = :username
            """)
    Optional<User> findByUsername(String username);

}
