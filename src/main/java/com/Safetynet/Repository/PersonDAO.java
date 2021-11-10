package com.Safetynet.Repository;

import com.Safetynet.Exceptions.CustomExceptions.PersonAlreadyExistsException;
import com.Safetynet.Exceptions.CustomExceptions.PersonNotFoundException;
import com.Safetynet.Model.Person;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PersonDAO implements IPersonDAO{
    private List<Person> personList;

    private static final Logger LOGGER = LogManager.getLogger(PersonDAO.class);


    public List<Person> getPersonList() {
        return personList;
    }

    public void setPersonList(List<Person> personList) {
        this.personList = personList;
    }

    @Override
    public Person findByName(String firstName, String lastName){
        return  personList.stream()
                .filter(person -> person.getFirstName().equals(firstName) && person.getLastName().equals(lastName))
                .findAny().orElseThrow(()->new PersonNotFoundException(firstName, lastName));
    }

    @Override
    public Person addPerson(Person person) {
        if (personList.stream().anyMatch(p->p.getFirstName().equals(person.getFirstName())&&p.getLastName().equals(person.getLastName()))) {
            throw new PersonAlreadyExistsException(person.getFirstName(),person.getLastName());
        }else {
            personList.add(person);
            LOGGER.info("personne bien ajouté");
            return person;
        }
    }

    @Override
    public Person editPerson(Person person) {
        Person personToUpdate = personList.stream()
                .filter(p -> p.getFirstName().equals(person.getFirstName()) && p.getLastName().equals(person.getLastName()))
                .findAny().orElseThrow(()-> new PersonNotFoundException(person.getFirstName(),person.getLastName()));
        personList.set(personList.indexOf(personToUpdate), person);
        LOGGER.info("person bien modifiée");
        return person;
    }

    @Override
    public void deletePerson(Person person) {
        Person personToDelete = personList.stream()
                .filter(p -> p.getFirstName().equals(person.getFirstName()) && p.getLastName().equals(person.getLastName()))
                .findAny().orElseThrow(()-> new PersonNotFoundException(person.getFirstName(),person.getLastName()));
            personList.remove(personToDelete);
            LOGGER.info("Person bien supprimée");
    }
}
