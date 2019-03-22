package com.ashish.usermgmt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ashish.usermgmt.model.Person;
import com.ashish.usermgmt.repository.PersonRepository;


@Service("PersonDetailsService")
public class PersonDetailsService {

    @Autowired
    private PersonRepository personRepository;

    public Person getPersonById(int id) {
        return personRepository.getOne(id);
    }
}
