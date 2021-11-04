package com.Safetynet.Service;

import com.Safetynet.Data.AlertServiceTestData;
import com.Safetynet.Data.GeneralData;
import com.Safetynet.Model.Data;
import com.Safetynet.Model.Specific.ListByFirestation;
import com.Safetynet.Utils.Dataloader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class AlertServiceTest {

    @Autowired
    Dataloader dataloader;

    @Autowired
    AlertService alertService;

    @BeforeEach
    public void setup(){
        Data dataTest = new Data(GeneralData.getPersonList(),GeneralData.getFirestationsList(), GeneralData.getMedicalRecordsList());
        ((Dataloader) dataloader).setDataFile(dataTest);
    }

    @Test
    public void getPersonsListByFirestationTest(){
        //Given
        Integer firestationNumber = 3;
        ListByFirestation expected = AlertServiceTestData.getPersonsListByFirestation();
        ListByFirestation result;
        //When
        result = alertService.getPersonsListByFirestation(firestationNumber);
        //Then
        assertEquals(expected,result);
    }


}
