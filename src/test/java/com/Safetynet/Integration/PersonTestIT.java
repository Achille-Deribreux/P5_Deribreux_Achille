package com.Safetynet.Integration;

import com.Safetynet.Controller.PersonController;
import com.Safetynet.Data.GeneralData;
import com.Safetynet.Data.PersonTestITData;
import com.Safetynet.Model.Person;
import com.Safetynet.Repository.PersonDAO;
import com.Safetynet.Service.PersonService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class PersonTestIT {
    PersonController personController = new PersonController();
    PersonService personService = new PersonService();
    PersonDAO personDAO = new PersonDAO();

    @BeforeEach
    public void setup(){
        personDAO.setPersonList(GeneralData.getPersonList());
        personService.setPersonDAO(personDAO);
        personController.setPersonService(personService);
    }

    @Test
    public void getAllPersonsTest(){
        //Given
        List<Person> expected = GeneralData.getPersonList();
        List<Person> result;
        //When
        result = personController.getAllPersons().getBody();
        //Then
        assertEquals(expected, result);
    }

    @Test
    public void getPersonByNameTest(){
        //Given
        String firstName = "John";
        String lastName = "Boyd";
        Person expected = PersonTestITData.getPersonToFindByName();
        Person result;
        //When
        result = personController.getPersonByName(firstName,lastName).getBody();
        //Then
        assertEquals(expected, result);
    }

    @Test
    public void addPersonTest(){
        //Given
        Person personToAdd = PersonTestITData.getPersonToAdd();
        List<Person> expected = PersonTestITData.getPersonListWithAddedPerson();
        //When
        personController.addPerson(personToAdd);
        //Then
        List<Person> result = personDAO.getPersonList();
        assertEquals(expected, result);
    }

    @Test
    public void editPersonTest(){
        //Given
        Person personToEdit = PersonTestITData.getPersonToEdit();
        List<Person> expected = PersonTestITData.getPersonListWithEditedPerson();
        //When
        personController.editPerson(personToEdit);
        //Then
        List<Person> result = personDAO.getPersonList();
        assertEquals(expected, result);
    }

    @Test
    public void deletePersonTest(){
        //Given
        Person personToDelete = PersonTestITData.getPersonToDelete();
        List<Person> expected = PersonTestITData.getPersonListWithDeletedPerson();
        //When
        personController.deletePerson(personToDelete);
        //Then
        List<Person> result = personDAO.getPersonList();
        assertEquals(expected, result);
    }
}
