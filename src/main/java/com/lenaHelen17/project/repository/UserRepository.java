package com.lenaHelen17.project.repository;

import com.lenaHelen17.project.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Optional;

@Transactional(readOnly = true)
public interface UserRepository extends JpaRepository<User, Integer> {

//    @Query("SELECT u FROM User u WHERE u.email = LOWER(:email)")
//    Optional<User> findByEmailIgnoreCase(String email);

    List<User> findByLastNameContainingIgnoreCase(String lastName);
}
