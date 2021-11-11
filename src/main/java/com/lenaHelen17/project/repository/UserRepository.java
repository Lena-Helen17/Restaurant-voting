package com.lenaHelen17.project.repository;

import com.lenaHelen17.project.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
