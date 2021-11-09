package com.Safetynet.Repository;

import com.Safetynet.Model.Person;


public interface IPersonDAO {
    Person findByName(String firstName, String lastName);
    Person addPerson(Person person);
    Person editPerson(Person person);
    void deletePerson(Person person);
}
