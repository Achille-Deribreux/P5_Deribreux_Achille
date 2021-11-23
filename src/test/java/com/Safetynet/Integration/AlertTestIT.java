package com.Safetynet.Integration;

import com.Safetynet.Controller.AlertsController;
import com.Safetynet.Data.AlertServiceTestData;
import com.Safetynet.Data.GeneralData;
import com.Safetynet.Model.Specific.ChildAlert;
import com.Safetynet.Model.Specific.Flood;
import com.Safetynet.Model.Specific.ListByFirestation;
import com.Safetynet.Model.Specific.utils.FullInfoPerson;
import com.Safetynet.Repository.FirestationDAO;
import com.Safetynet.Repository.MedicalRecordsDAO;
import com.Safetynet.Repository.PersonDAO;
import com.Safetynet.Service.AlertService;
import com.Safetynet.Service.FirestationService;
import com.Safetynet.Service.MedicalRecordService;
import com.Safetynet.Service.PersonService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class AlertTestIT {
    FirestationDAO firestationDAO = new FirestationDAO();
    PersonDAO personDAO = new PersonDAO();
    MedicalRecordsDAO medicalRecordsDAO = new MedicalRecordsDAO();

    FirestationService firestationService = new FirestationService();
    PersonService personService = new PersonService();
    MedicalRecordService medicalRecordService = new MedicalRecordService();

    AlertService alertService = new AlertService();
    AlertsController alertsController = new AlertsController();

    @BeforeEach
    public void setup(){
        firestationDAO.setFirestationsList(GeneralData.getFirestationsList());
        personDAO.setPersonList(GeneralData.getPersonList());
        medicalRecordsDAO.setMedicalRecordsList(GeneralData.getMedicalRecordsList());

        firestationService.setFirestationDAO(firestationDAO);
        personService.setPersonDAO(personDAO);
        medicalRecordService.setMedicalRecordsDAO(medicalRecordsDAO);

        alertService.setFirestationService(firestationService);
        alertService.setPersonService(personService);
        alertService.setMedicalRecordService(medicalRecordService);

        alertsController.setAlertService(alertService);
    }

    @Test
    public void showEmailsByCityTestIT(){
        //Given
        String city = "Culver";
        List<String> expected = AlertServiceTestData.getEmailsFromCityList();
        List<String> result;
        //When
        result = alertsController.showEmailsByCity(city).getBody();
        //Then
        assertEquals(expected,result);
    }

    @Test
    public void showPhoneByFirestationNumberTestIT(){
        //Given
        Integer firestationNumber = 3;
        List<String> expected = AlertServiceTestData.getPhoneListFromFirestationNumber();
        List<String> result;
        //When
        result = alertsController.showPhoneByFirestationNumber(firestationNumber).getBody();
        //Then
        assertEquals(expected,result);
    }

    @Test
    public void showPersonInfoByNameAndLastNameTestIT(){
        //Given
        String firstName = "John";
        String lastName =  "Boyd";
        List<FullInfoPerson> expected = AlertServiceTestData.getFullInfoPersonByNameList();
        List<FullInfoPerson> result;
        //When
        result = alertsController.showPersonInfoByNameAndLastName(firstName,lastName).getBody();
        //Then
        assertEquals(expected,result);
    }

    @Test
    public void showPersonsListByFirestationTestIT(){
        //Given
        Integer firestationNumber = 3;
        ListByFirestation expected = AlertServiceTestData.getPersonsListByFirestation();
        ListByFirestation result;
        //When
        result = alertsController.showPersonsListByFirestation(firestationNumber).getBody();
        //Then
        assertEquals(expected,result);
    }

    @Test
    public void showChildrensAndAdultsByAdressTestIT(){
        //Given
        String address = "1509 Culver St";
        ChildAlert expected = AlertServiceTestData.getChildAlertData();
        ChildAlert result;
        //When
        result = alertsController.showChildrensAndAdultsByAdress(address).getBody();
        //Then
        assertEquals(expected,result);
    }

    @Test
    public void showPersonsListAndFirestationNumberByAdressTestIT(){
        //Given
        String address = "1509 Culver St";
        ChildAlert expected = AlertServiceTestData.getChildAlertData();
        ChildAlert result;
        //When
        result = alertsController.showChildrensAndAdultsByAdress(address).getBody();
        //Then
        assertEquals(expected,result);
    }

    @Test
    public void showPersonsAndAddressByFireStationNumberTestIT(){
        //Given
        List<Integer> firestationNumberList = new ArrayList<>(Arrays.asList(2,3));
        List<Flood> expected = AlertServiceTestData.getFloodDataList();
        List<Flood> result;
        //When
        result = alertsController.showPersonsAndAddressByFireStationNumber(firestationNumberList).getBody();
        //Then
        assertEquals(expected,result);
    }
}
