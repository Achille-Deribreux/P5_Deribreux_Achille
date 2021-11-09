package com.Safetynet.Service;

import com.Safetynet.Model.Person;

import java.util.List;

public interface IPersonService {
    List<Person> findAll();
    Person findByName(String firstName, String lastName);
    Person addPerson(Person person);
    Person editPerson(Person person);
    void deletePerson(Person person);
}
