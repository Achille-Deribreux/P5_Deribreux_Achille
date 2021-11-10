package com.Safetynet.Repository;

import com.Safetynet.Data.FirestationDAOTestData;
import com.Safetynet.Data.GeneralData;
import com.Safetynet.Model.Data;
import com.Safetynet.Model.Firestations;
import com.Safetynet.Model.Specific.Fire;
import com.Safetynet.Utils.Dataloader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class FirestationDAOTest {

    @Autowired
    Dataloader dataloader;

    @Autowired
    FirestationDAO firestationDAO;

    @BeforeEach
    public void setup(){
        Data dataTest = new Data(GeneralData.getPersonList(),GeneralData.getFirestationsList(), GeneralData.getMedicalRecordsList());
        ((Dataloader) dataloader).setDataFile(dataTest);
    }

    @Test
    public void findByNumberTest(){
        //Given
        Integer number = 3;
        Firestations expected = new Firestations("1509 Culver St", 3);
        Firestations result;
        //When
        result = firestationDAO.findByNumber(number);
        //Then
        assertEquals(expected,result);
    }

    @Test
    public void addFirestationTest(){
        //Given
        Firestations firestationToAdd = FirestationDAOTestData.firestationToAdd();
        List<Firestations> expected = FirestationDAOTestData.getFirestationsListWithAddedStation();
        //When
        firestationDAO.addFirestations(firestationToAdd);
        //Then
        assertEquals(expected,firestationDAO.getFirestationsList());
    }

    @Test
    public void editFirestationTest(){
        //Given
        Firestations firestationToEdit = FirestationDAOTestData.firestationToEdit();
        List<Firestations> expected = FirestationDAOTestData.getFirestationsListWithEditedStation();
        //When
        firestationDAO.editFirestations(firestationToEdit);
        //Then
        assertEquals(expected,firestationDAO.getFirestationsList());
    }

    @Test
    public void deleteFirestationTest(){
        //Given
        Firestations firestationToDelete = FirestationDAOTestData.firestationToDelete();
        List<Firestations> expected = FirestationDAOTestData.getFirestationsListWithDeletedStation();
        //When
        firestationDAO.deleteFirestations(firestationToDelete);
        //Then
        assertEquals(expected,firestationDAO.getFirestationsList());
    }

}
