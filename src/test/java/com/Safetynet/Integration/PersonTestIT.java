package com.Safetynet.Integration;

import com.Safetynet.Controller.PersonController;
import com.Safetynet.Data.GeneralData;
import com.Safetynet.Data.PersonTestITData;
import com.Safetynet.Repository.PersonDAO;
import com.Safetynet.Service.PersonService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

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
    public void addPersonTest(){
        personController.addPerson(PersonTestITData.getPersonToAdd());
        assertEquals(personDAO.getPersonList(), PersonTestITData.getPersonListWithAddedPerson());
    }

    @Test
    public void editPersonTest(){
        personController.editPerson(PersonTestITData.getPersonToEdit());
        assertEquals(personDAO.getPersonList(), PersonTestITData.getPersonListWithEditedPerson());
    }

    @Test
    public void deletePersonTest(){
        personController.deletePerson(PersonTestITData.getPersonToDelete());
        assertEquals(personDAO.getPersonList(), PersonTestITData.getPersonListWithDeletedPerson());
    }

    @Test
    public void getAllPersonsTest(){
        assertEquals(GeneralData.getPersonList(),personController.getAllPersons().getBody());
    }

    @Test
    public void getPersonByNameTest(){
        assertEquals(personController.getPersonByName("John","Boyd").getBody(), PersonTestITData.getPersonToFindByName());
    }
}
