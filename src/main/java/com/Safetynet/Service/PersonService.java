package com.Safetynet.Service;

import com.Safetynet.Model.Person;
import com.Safetynet.Repository.PersonDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService implements IPersonService {

    @Autowired
    PersonDAO personDAO;

    @Override
    public List<Person> findAll(){
        return personDAO.getPersonList();
    }

    public Person findByName(String firstName, String lastName){
        return personDAO.findByName(firstName,lastName);
    }

    @Override
    public Person addPerson(Person person) {
        return personDAO.addPerson(person);
    }

    @Override
    public Person editPerson(Person person) {
        return personDAO.editPerson(person);
    }

    @Override
    public void deletePerson(Person person) {
        personDAO.deletePerson(person);
    }
}
