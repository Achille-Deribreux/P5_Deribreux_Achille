package com.Safetynet.Repository;

import com.Safetynet.Model.Person;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PersonDAO implements IPersonDAO{
    private List<Person> personList;

    public List<Person> getPersonList() {
        return personList;
    }

    public void setPersonList(List<Person> personList) {
        this.personList = personList;
    }

    @Override
    public Person addPerson(Person person) {
        return null;
    }

    @Override
    public Person editPerson(Person person) {
        return null;
    }

    @Override
    public void deletePerson(Person person) {

    }
}
