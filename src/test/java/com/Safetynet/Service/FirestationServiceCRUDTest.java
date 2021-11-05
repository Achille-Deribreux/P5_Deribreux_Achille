package com.Safetynet.Service;

import com.Safetynet.Model.Firestations;
import com.Safetynet.Model.MedicalRecords;
import com.Safetynet.Repository.FirestationDAO;
import com.Safetynet.Repository.MedicalRecordsDAO;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
public class FirestationServiceCRUDTest {
    @MockBean
    FirestationDAO firestationDAO;

    @Autowired
    FirestationService firestationService;

    @Test
    public void addFirestationTest(){
        //Given
        Firestations firestations = new Firestations("1509 Culver St", 3);
        //When
        when(firestationDAO.addFirestations(firestations)).thenReturn(firestations);
        //Then
        assertEquals(firestationDAO.addFirestations(firestations),firestationService.addFirestation(firestations));
    }

    @Test
    public void addFirestationCallTest(){
        //Given
        Firestations firestations = new Firestations("1509 Culver St", 3);
        //When
        firestationService.addFirestation(firestations);
        //Then
        verify(firestationDAO, Mockito.times(1)).addFirestations(firestations);
    }

    @Test
    public void editFirestationTest(){
        //Given
        Firestations firestations = new Firestations("1509 Culver St", 3);
        //When
        when(firestationDAO.editFirestations(firestations)).thenReturn(firestations);
        //Then
        assertEquals(firestationDAO.editFirestations(firestations),firestationService.editFirestation(firestations));
    }

    @Test
    public void editFirestationCallTest(){
        //Given
        Firestations firestations = new Firestations("1509 Culver St", 3);
        //When
        firestationService.editFirestation(firestations);
        //Then
        verify(firestationDAO, Mockito.times(1)).editFirestations(firestations);
    }

    @Test
    public void deleteFirestationCallTest(){
        //Given
        Firestations firestations = new Firestations("1509 Culver St", 3);
        //When
        firestationService.deleteFirestation(firestations);
        //Then
        verify(firestationDAO, Mockito.times(1)).deleteFirestations(firestations);
    }
}
