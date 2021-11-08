package com.Safetynet.Controller;

import com.Safetynet.Model.Person;
import com.Safetynet.Service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PersonController {

    @Autowired
    PersonService personService;

    @PostMapping(value="/person", consumes = "application/json", produces = "application/json")
    public ResponseEntity<String> addPerson(@RequestBody Person person) {
        if(person == null) {
            return new ResponseEntity<>("Content is empty", HttpStatus.NO_CONTENT);
        }else {
            personService.addPerson(person);
            return new ResponseEntity<>("Person added successfully", HttpStatus.CREATED);
        }
    }

    @PutMapping(value="/person", consumes = "application/json", produces = "application/json")
    public ResponseEntity<String> editPerson(@RequestBody Person person) {
        if(person == null) {
            return new ResponseEntity<>("Content is empty", HttpStatus.NO_CONTENT);
        }else {
            personService.editPerson(person);
            return new ResponseEntity<>("Person updated successfully", HttpStatus.OK);
        }
    }

    @DeleteMapping(value="/person", consumes = "application/json")
    public ResponseEntity<String> deletePerson(@RequestBody Person person) {
        if(person == null) {
            return new ResponseEntity<>("Content is empty", HttpStatus.NO_CONTENT);
        }else {
            personService.deletePerson(person);
            return new ResponseEntity<>("Person deleted successfully", HttpStatus.OK);
        }
    }
}
