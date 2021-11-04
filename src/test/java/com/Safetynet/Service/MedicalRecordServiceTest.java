package com.Safetynet.Service;

import com.Safetynet.Data.GeneralData;
import com.Safetynet.Model.Data;
import com.Safetynet.Model.MedicalRecords;
import com.Safetynet.Utils.Dataloader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class MedicalRecordServiceTest {
    @Autowired
    Dataloader dataloader;

    @Autowired
    MedicalRecordService medicalRecordService;

    @BeforeEach
    public void setup(){
        Data dataTest = new Data(GeneralData.getPersonList(),GeneralData.getFirestationsList(), GeneralData.getMedicalRecordsList());
        ((Dataloader) dataloader).setDataFile(dataTest);
    }

    @Test
    public void findAllTest(){
        //Given
        List<MedicalRecords> expected = GeneralData.getMedicalRecordsList();
        List<MedicalRecords> result;
        //When
        result = medicalRecordService.findAll();
        //Then
        assertEquals(expected,result);
    }

    @Test
    public void findAgeFromNameTest(){
        //Given
        String firstName = "John";
        String lastName = "Boyd";
        Integer expected = 37;
        Integer result;
        //When
        result = medicalRecordService.findAgeFromName(firstName,lastName);
        //Then
        assertEquals(expected,result);
    }

    @Test
    public void findAgeFromBirthdateTest(){
        //Given
        String birthdate = "02/18/2012";
        Integer expected = 9;
        Integer result;
        //When
        result = medicalRecordService.findAgeFromBirthdate(birthdate);
        //Then
        assertEquals(expected,result);
    }

    @Test
    public void findAllergiesByName(){
        //Given
        String firstName = "John";
        String lastName = "Boyd";
        List<String> expected = List.of("nillacilan");
        List<String> result;
        //When
        result = medicalRecordService.findAllergiesByName(firstName,lastName);
        //Then
        assertEquals(expected,result);
    }

    @Test
    public void findMedicationByName(){
        //Given
        String firstName = "John";
        String lastName = "Boyd";
        List<String> expected = List.of("aznol:350mg", "hydrapermazol:100mg");
        List<String> result;
        //When
        result = medicalRecordService.findMedicationsByName(firstName,lastName);
        //Then
        assertEquals(expected,result);
    }
}
