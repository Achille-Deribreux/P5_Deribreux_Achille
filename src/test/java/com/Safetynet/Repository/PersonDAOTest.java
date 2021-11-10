package com.Safetynet.Repository;

import com.Safetynet.Data.GeneralData;
import com.Safetynet.Data.PersonDAOTestData;
import com.Safetynet.Model.Data;
import com.Safetynet.Model.Person;
import com.Safetynet.Utils.Dataloader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class PersonDAOTest {

    @Autowired
    Dataloader dataloader;

    @Autowired
    PersonDAO personDAO;

    @BeforeEach
    public void setup(){
        Data dataTest = new Data(GeneralData.getPersonList(),GeneralData.getFirestationsList(), GeneralData.getMedicalRecordsList());
        ((Dataloader) dataloader).setDataFile(dataTest);
    }

    @Test
    public void findByNameTest(){
        //Given
        String firstName = "John";
        String lastName = "Boyd";
        Person expected = new Person("John", "Boyd", "1509 Culver St", "Culver", "97451", "841-874-6512", "jaboyd@email.com");
        Person result;
        //When
        result = personDAO.findByName(firstName,lastName);
        //Then
        assertEquals(expected, result);
    }

    @Test
    public void addFirestationTest(){
        //Given
        Person personToAdd = PersonDAOTestData.personToAdd();
        List<Person> expected = PersonDAOTestData.getPersonListWithAddedPerson();
        //When
        personDAO.addPerson(personToAdd);
        //Then
        assertEquals(expected,personDAO.getPersonList());
    }

    @Test
    public void editFirestationTest(){
        //Given
        Person personToEdit = PersonDAOTestData.personToEdit();
        List<Person> expected = PersonDAOTestData.getPersonListWithEditedPerson();
        //When
        personDAO.editPerson(personToEdit);
        //Then
        assertEquals(expected,personDAO.getPersonList());
    }

    @Test
    public void deleteFirestationTest(){
        //Given
        Person personToDelete = PersonDAOTestData.personToDelete();
        List<Person> expected = PersonDAOTestData.getPersonListWithDeletedPerson();
        //When
        personDAO.deletePerson(personToDelete);
        //Then
        assertEquals(expected,personDAO.getPersonList());
    }
}
