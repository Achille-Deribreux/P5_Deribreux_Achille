package com.Safetynet.Controller;

import com.Safetynet.Model.Firestations;
import com.Safetynet.Model.Person;
import com.Safetynet.Service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonController {

    @Autowired
    PersonService personService;

    @GetMapping(value="/persons")
    public ResponseEntity<List<Person>> getAllFirestations(){
        return new ResponseEntity<>(personService.findAll(), HttpStatus.OK);
    }
    
    @GetMapping(value="/person")
    public ResponseEntity<Person> getAllFirestations(@RequestParam String firstName,@RequestParam String lastName){
        if(personService.findByName(firstName,lastName) != null) {
            return new ResponseEntity<>(personService.findByName(firstName,lastName), HttpStatus.OK);
        }else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

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
