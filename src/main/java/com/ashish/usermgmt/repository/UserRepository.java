package com.ashish.usermgmt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ashish.usermgmt.model.User;


public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
