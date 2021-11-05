package com.Safetynet.Service;

import com.Safetynet.Model.MedicalRecords;
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
public class MedicalRecordServiceCRUDTest {
    @MockBean
    MedicalRecordsDAO medicalRecordsDAO;

    @Autowired
    MedicalRecordService medicalRecordService;

    @Test
    public void addMedicalRecordsTest(){
        //Given
        MedicalRecords medicalRecord = new MedicalRecords("John", "Boyd", "03/06/1984", List.of("aznol:350mg", "hydrapermazol:100mg"), List.of("nillacilan"));
        //When
        when(medicalRecordsDAO.addMedicalRecords(medicalRecord)).thenReturn(medicalRecord);
        //Then
        assertEquals(medicalRecordsDAO.addMedicalRecords(medicalRecord),medicalRecordService.addMedicalRecords(medicalRecord));
    }

    @Test
    public void addMedicalRecordsCallTest(){
        //Given
        MedicalRecords medicalRecord = new MedicalRecords("John", "Boyd", "03/06/1984", List.of("aznol:350mg", "hydrapermazol:100mg"), List.of("nillacilan"));
        //When
        medicalRecordService.addMedicalRecords(medicalRecord);
        //Then
        verify(medicalRecordsDAO, Mockito.times(1)).addMedicalRecords(medicalRecord);
    }

    @Test
    public void editMedicalRecordsTest(){
        //Given
        MedicalRecords medicalRecord = new MedicalRecords("John", "Boyd", "03/06/1984", List.of("aznol:350mg", "hydrapermazol:100mg"), List.of("nillacilan"));
        //When
        when(medicalRecordsDAO.editMedicalRecords(medicalRecord)).thenReturn(medicalRecord);
        //Then
        assertEquals(medicalRecordsDAO.editMedicalRecords(medicalRecord),medicalRecordService.editMedicalRecords(medicalRecord));
    }

    @Test
    public void editMedicalRecordsCallTest(){
        //Given
        MedicalRecords medicalRecord = new MedicalRecords("John", "Boyd", "03/06/1984", List.of("aznol:350mg", "hydrapermazol:100mg"), List.of("nillacilan"));
        //When
        medicalRecordService.editMedicalRecords(medicalRecord);
        //Then
        verify(medicalRecordsDAO, Mockito.times(1)).editMedicalRecords(medicalRecord);
    }

    @Test
    public void deleteMedicalRecordsCallTest(){
        //Given
        MedicalRecords medicalRecord = new MedicalRecords("John", "Boyd", "03/06/1984", List.of("aznol:350mg", "hydrapermazol:100mg"), List.of("nillacilan"));
        //When
        medicalRecordService.deleteMedicalRecords(medicalRecord);
        //Then
        verify(medicalRecordsDAO, Mockito.times(1)).deleteMedicalRecords(medicalRecord);
    }
}
