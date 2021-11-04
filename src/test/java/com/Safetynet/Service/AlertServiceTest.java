package com.Safetynet.Service;

import com.Safetynet.Data.AlertServiceTestData;
import com.Safetynet.Data.GeneralData;
import com.Safetynet.Model.Data;
import com.Safetynet.Model.Specific.ChildAlert;
import com.Safetynet.Model.Specific.Fire;
import com.Safetynet.Model.Specific.Flood;
import com.Safetynet.Model.Specific.ListByFirestation;
import com.Safetynet.Model.Specific.utils.FullInfoPerson;
import com.Safetynet.Utils.Dataloader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    @Test
    public void getChildsAndAdultsByAddressTest(){
        //Given
        String address = "1509 Culver St";
        ChildAlert expected = AlertServiceTestData.getChildAlertData();
        ChildAlert result;
        //When
        result = alertService.getChildsAndAdultsByAddress(address);
        //Then
        assertEquals(expected,result);
    }

    @Test
    public void getAllPhonesByFirestationNumberTest(){
        //Given
        Integer firestationNumber = 3;
        List<String> expected = AlertServiceTestData.getPhoneListFromFirestationNumber();
        List<String> result;
        //When
        result = alertService.getAllPhonesByFirestationNumber(firestationNumber);
        //Then
        assertEquals(expected,result);
    }

    @Test
    public void getPersonByAddressTest(){
        //Given
        String address = "1509 Culver St";
        Fire expected = AlertServiceTestData.getFiredAlertData();
        Fire result;
        //When
        result = alertService.getPersonByAddress(address);
        //Then
        assertEquals(expected,result);
    }

    @Test
    public void getPersonsAndAddressByFirestationNumberTest(){
        //Given
        List<Integer> firestationNumberList = new ArrayList<>(Arrays.asList(2,3));
        List<Flood> expected = AlertServiceTestData.getFloodDataList();
        List<Flood> result;
        //When
        result = alertService.getPersonsAndAddressByFirestationNumber(firestationNumberList);
        //Then
        assertEquals(expected,result);
    }

    @Test
    public void getFullInfoPersonByName(){
        //Given
        String firstName = "John";
        String lastName =  "Boyd";
        List<FullInfoPerson> expected = AlertServiceTestData.getFullInfoPersonByNameList();
        List<FullInfoPerson> result;
        //When
        result = alertService.getFullInfoPersonByName(firstName,lastName);
        //Then
        assertEquals(expected,result);
    }

    @Test
    public void getEmailListByCity(){
        //Given
        String city = "Culver";
        List<String> expected = AlertServiceTestData.getEmailsFromCityList();
        List<String> result;
        //When
        result = alertService.getEmailListByCity(city);
        //Then
        assertEquals(expected,result);
    }
}
