package com.Safetynet.Service;

import com.Safetynet.Model.Person;
import com.Safetynet.Repository.PersonDAO;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
public class PersonServiceCRUDTest {


    @MockBean
    PersonDAO personDAO;

    @Autowired
    PersonService personService;

    @Test
    public void addPersonTest(){
        //Given
        Person person = new Person("John", "Boyd", "1509 Culver St", "Culver", "97451", "841-874-6512", "jaboyd@email.com");
        //When
        when(personDAO.addPerson(person)).thenReturn(person);
        //Then
        assertEquals(personDAO.addPerson(person),personService.addPerson(person));
    }

    @Test
    public void addPersonCallTest(){
        //Given
        Person person = new Person("John", "Boyd", "1509 Culver St", "Culver", "97451", "841-874-6512", "jaboyd@email.com");
        //When
        personService.addPerson(person);
        //Then
        verify(personDAO, Mockito.times(1)).addPerson(person);
    }

    @Test
    public void editPersonTest(){
        //Given
        Person person = new Person("John", "Boyd", "1509 Culver St", "Culver", "97451", "841-874-6512", "jaboyd@email.com");
        //When
        when(personDAO.editPerson(person)).thenReturn(person);
        //Then
        assertEquals(personDAO.editPerson(person),personService.editPerson(person));
    }

    @Test
    public void editPersonCallTest(){
        //Given
        Person person = new Person("John", "Boyd", "1509 Culver St", "Culver", "97451", "841-874-6512", "jaboyd@email.com");
        //When
        personService.editPerson(person);
        //Then
        verify(personDAO, Mockito.times(1)).editPerson(person);
    }

    @Test
    public void deletePersonCallTest(){
        //Given
        Person person = new Person("John", "Boyd", "1509 Culver St", "Culver", "97451", "841-874-6512", "jaboyd@email.com");
        //When
        personService.deletePerson(person);
        //Then
        verify(personDAO, Mockito.times(1)).deletePerson(person);
    }
}
