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
        personList.add(person);
        return person;
    }

    @Override
    public Person editPerson(Person person) {
        Person personToUpdate = null;
        for (Person p : personList){
            if(p.getFirstName().equals(person.getFirstName())&&p.getLastName().equals(person.getLastName())){
                personToUpdate = p;
            }
        }
        if(personToUpdate != null){
            personList.set(personList.indexOf(personToUpdate), person);
            return person;
        }
        return null;
    }

    @Override
    public void deletePerson(Person person) {
        Person personToDelete = null;
        for(Person p : personList){
            if(p.getFirstName().equals(person.getFirstName())&&p.getLastName().equals(person.getLastName())){
                personToDelete = p;
            }
        }
        if(personToDelete != null){
            personList.remove(personToDelete);
        }
    }
}
