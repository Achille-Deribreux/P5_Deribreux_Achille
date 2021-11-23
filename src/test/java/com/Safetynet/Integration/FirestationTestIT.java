package com.Safetynet.Integration;

import com.Safetynet.Controller.FirestationController;
import com.Safetynet.Data.FirestationTestITData;
import com.Safetynet.Data.GeneralData;
import com.Safetynet.Model.Firestations;
import com.Safetynet.Repository.FirestationDAO;
import com.Safetynet.Service.FirestationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class FirestationTestIT {

    FirestationController firestationController = new FirestationController();
    FirestationService firestationService = new FirestationService();
    FirestationDAO firestationDAO = new FirestationDAO();

    @BeforeEach
    public void setup(){
        firestationDAO.setFirestationsList(GeneralData.getFirestationsList());
        firestationService.setFirestationDAO(firestationDAO);
        firestationController.setFirestationService(firestationService);
    }

    @Test
    public void getAllFirestationsTest(){
        //Given
        List<Firestations> expected = GeneralData.getFirestationsList();
        List<Firestations> result;
        //When
        result = firestationController.getAllFirestations().getBody();
        //Then
        assertEquals(expected,result);
    }

    @Test
    public void getFirestationsByNumberTest(){
        //Given
        Integer firestationNumber = 3;
        Firestations expected = FirestationTestITData.getFirestationByNumber();
        Firestations result;
        //When
        result = firestationController.getFirestationsByNumber(firestationNumber).getBody();
        //Then
        assertEquals(expected,result);
    }

    @Test
    public void addFirestationTest(){
        //Given
        Firestations firestationsToAdd = FirestationTestITData.getFirestationToAdd();
        List<Firestations> expected = FirestationTestITData.getFirestationsListWithAddedFirestation();
        List<Firestations> result;
        //When
        firestationController.addFirestation(firestationsToAdd);
        //Then
        result = firestationDAO.getFirestationsList();
        assertEquals(expected,result);
    }

    @Test
    public void editFirestationTest(){
        //Given
        Firestations firestationsToEdit = FirestationTestITData.getFirestationToEdit();
        List<Firestations> expected = FirestationTestITData.getFirestationsListWithEditedFirestation();
        List<Firestations> result;
        //When
        firestationController.editFirestation(firestationsToEdit);
        //Then
        result = firestationDAO.getFirestationsList();
        assertEquals(expected,result);
    }

    @Test
    public void deleteFirestationTest(){
        //Given
        Firestations firestationsToDelete = FirestationTestITData.getFirestationToDelete();
        List<Firestations> expected = FirestationTestITData.getFirestationsListWithDeletedFirestation();
        List<Firestations> result;
        //When
        firestationController.deleteFirestation(firestationsToDelete);
        //Then
        result = firestationDAO.getFirestationsList();
        assertEquals(expected,result);
    }
}
