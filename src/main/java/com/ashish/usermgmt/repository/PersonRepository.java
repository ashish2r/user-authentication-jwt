package com.ashish.usermgmt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ashish.usermgmt.model.Person;
@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {
   
}