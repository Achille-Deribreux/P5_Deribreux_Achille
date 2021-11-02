package com.Safetynet.Controller;

import com.Safetynet.Model.Person;
import com.Safetynet.Service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
public class PersonController {

    @Autowired
    PersonService personService;

    //TODO: Get some responses & codes
    @PostMapping(value="/person", consumes = "application/json", produces = "application/json")
    public void addPerson(@RequestBody Person person) {
        personService.addPerson(person);
    }

    @PutMapping(value="/person", consumes = "application/json", produces = "application/json")
    public void editPerson(@RequestBody Person person) {
        personService.editPerson(person);
    }

    @DeleteMapping(value="/person", consumes = "application/json")
    public void deletePerson(@RequestBody Person person) {
        personService.deletePerson(person);
    }
}
