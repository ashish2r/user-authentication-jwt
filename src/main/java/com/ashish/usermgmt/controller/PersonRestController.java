package com.ashish.usermgmt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ashish.usermgmt.model.Person;
import com.ashish.usermgmt.service.PersonDetailsService;

@RestController
@RequestMapping("/person")
public class PersonRestController {
	@Autowired
    @Qualifier("PersonDetailsService")
    private PersonDetailsService personDetailsService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Person getPersonDetails(@PathVariable("id") int id) {
       
        return personDetailsService.getPersonById(id);
        
    }
}
