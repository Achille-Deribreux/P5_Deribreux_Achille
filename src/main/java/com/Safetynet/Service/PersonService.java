package com.Safetynet.Service;

import com.Safetynet.Model.Person;
import com.Safetynet.Repository.PersonDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService implements IPersonService {

    @Autowired
    PersonDAO personDAO;

    private static final Logger LOGGER = LogManager.getLogger(PersonService.class);

    public void setPersonDAO(PersonDAO personDAO) {
        LOGGER.debug("personDAO setted");
        this.personDAO = personDAO;
    }

    @Override
    public List<Person> findAll(){
        LOGGER.debug("personDAO.getPersonList have been called");
        return personDAO.getPersonList();
    }

    @Override
    public Person findByName(String firstName, String lastName){
        LOGGER.debug("personDAO.findByName call with :"+firstName+" "+lastName);
        return personDAO.findByName(firstName,lastName);
    }

    @Override
    public Person addPerson(Person person) {
        LOGGER.debug("personDAO.addPerson call with :"+person);
        return personDAO.addPerson(person);
    }

    @Override
    public Person editPerson(Person person) {
        LOGGER.debug("personDAO.editPerson call with :"+person);
        return personDAO.editPerson(person);
    }

    @Override
    public void deletePerson(Person person) {
        LOGGER.debug("personDAO.deletePerson call with :"+person);
        personDAO.deletePerson(person);
    }
}
