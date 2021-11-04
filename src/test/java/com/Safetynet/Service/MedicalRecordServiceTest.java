package com.Safetynet.Service;

import com.Safetynet.Data.GeneralData;
import com.Safetynet.Model.Data;
import com.Safetynet.Model.MedicalRecords;
import com.Safetynet.Model.Person;
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

}
