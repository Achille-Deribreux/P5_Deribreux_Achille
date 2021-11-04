package com.Safetynet.Service;

import com.Safetynet.Data.GeneralData;
import com.Safetynet.Model.Data;
import com.Safetynet.Model.Firestations;
import com.Safetynet.Model.Person;
import com.Safetynet.Utils.Dataloader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class FirestationServiceTest {

    @Autowired
    Dataloader dataloader;

    @Autowired
    FirestationService firestationService;

    @BeforeEach
    public void setup(){
        Data dataTest = new Data(GeneralData.getPersonList(),GeneralData.getFirestationsList(), GeneralData.getMedicalRecordsList());
        ((Dataloader) dataloader).setDataFile(dataTest);
    }

    @Test
    public void findAllTest(){
        //Given
        List<Firestations> expected = GeneralData.getFirestationsList();
        List<Firestations> result;
        //When
        result = firestationService.findAll();
        //Then
        assertEquals(expected,result);
    }

    @Test
    public void findAddressByNumberTest(){
        //Given
        Integer firestationNumber = 3;
        String expected = "1509 Culver St";
        String result;
        //When
        result = firestationService.findAddressByNumber(firestationNumber);
        //Then
        assertEquals(expected,result);
    }

    @Test
    public void findNumberByAddressTest(){
        //Given
        String address = "1509 Culver St";
        Integer expected = 3;
        Integer result;
        //When
        result = firestationService.findNumberByAddress(address);
        //Then
        assertEquals(expected,result);
    }
}
