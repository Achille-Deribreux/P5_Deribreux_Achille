package com.Safetynet.Service;

import com.Safetynet.Model.Person;

public interface IPersonService {
    public Person addPerson(Person person);
    public Person editPerson(Person person);
    public void deletePerson(Person person);
}
