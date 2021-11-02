package com.Safetynet.Repository;

import com.Safetynet.Model.Person;


public interface IPersonDAO {
    public Person addPerson(Person person);
    public Person editPerson(Person person);
    public void deletePerson(Person person);
}
