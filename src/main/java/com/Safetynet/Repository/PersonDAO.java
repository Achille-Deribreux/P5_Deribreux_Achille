package com.Safetynet.Repository;

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

    public Person findByName(String firstName, String lastName){
        return  personList.stream()
                .filter(person -> person.getFirstName().equals(firstName) && person.getLastName().equals(lastName))
                .findAny().orElse(null);
    }

    @Override
    public Person addPerson(Person person) {
        try {
            if (person == null) {
                LOGGER.error("argument null");
                throw new NullPointerException();
            }else {
                personList.add(person);
                LOGGER.info("personne bien ajouté");
                return person;
            }
        }catch(Exception e){
            LOGGER.error("impossible d'ajouter une personne", e);
        }
        return null;//TODO : change return statement
    }

    @Override
    public Person editPerson(Person person) {
        try{
            if (person == null) {
                LOGGER.error("argument null");
                throw new NullPointerException();
            }else {
                Person personToUpdate = null;
                for (Person p : personList){
                    if(p.getFirstName().equals(person.getFirstName())&&p.getLastName().equals(person.getLastName())){
                        personToUpdate = p;
                    }
                }
                if(personToUpdate == null){
                    LOGGER.error("person non trouvée");
                    throw new NullPointerException();
                }else {
                    personList.set(personList.indexOf(personToUpdate), person);
                    LOGGER.info("person bien modifiée");
                    return person;
                }
            }
        }catch(Exception e){
            LOGGER.error("impossible de modifier une personne", e);
        }
        return null;//TODO : change return statement
    }

    @Override
    public void deletePerson(Person person) {
        try{
            if (person == null) {
                LOGGER.error("argument null");
                throw new NullPointerException();
            }else {
                Person personToDelete = null;
                for(Person p : personList){
                    if(p.getFirstName().equals(person.getFirstName())&&p.getLastName().equals(person.getLastName())){
                        personToDelete = p;
                    }
                }
                if(personToDelete == null){
                    LOGGER.error("person non trouvée");
                    throw new NullPointerException();
                }else {
                    personList.remove(personToDelete);
                    LOGGER.info("Person bien supprimée");
                }
            }
        }catch(Exception e){
            LOGGER.error("impossible de modifier une personne", e);
        }
    }
}
