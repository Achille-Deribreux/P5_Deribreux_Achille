package com.Safetynet.Data;

import com.Safetynet.Model.MedicalRecords;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MedicalRecordsDAOTestData {

    public static MedicalRecords medicalRecordsToAdd(){
        return new MedicalRecords("Ach", "Der", "03/06/1984", List.of("aznol:350mg", "hydrapermazol:100mg"), List.of("nillacilan"));
    }

    public static List<MedicalRecords> getMedicalRecordsListWithAddedMedicalRecord() {
        return new ArrayList<>(Arrays.asList(
                new MedicalRecords("John", "Boyd", "03/06/1984", List.of("aznol:350mg", "hydrapermazol:100mg"), List.of("nillacilan")),
                new MedicalRecords("Jacob", "Boyd", "03/06/1989", List.of("pharmacol:5000mg", "terazine:10mg", "noznazol:250mg"), List.of()),
                new MedicalRecords("Tenley", "Boyd", "02/18/2012", List.of(), List.of("peanut")),
                new MedicalRecords("Roger", "Boyd", "09/06/2017", List.of(), List.of()),
                new MedicalRecords("Felicia", "Boyd", "01/08/1986", List.of("tetracyclaz:650mg"), List.of("xilliathal")),
                new MedicalRecords("Ach", "Der", "03/06/1984", List.of("aznol:350mg", "hydrapermazol:100mg"), List.of("nillacilan"))
        ));
    }

    public static MedicalRecords medicalRecordsToEdit(){
        return new MedicalRecords("John", "Boyd", "03/06/1990", List.of("aznol:350mg", "hydrapermazol:100mg"), List.of("nillacilan"));
    }

    public static List<MedicalRecords> getMedicalRecordsListWithEditedMedicalRecord() {
        return new ArrayList<>(Arrays.asList(
                new MedicalRecords("John", "Boyd", "03/06/1990", List.of("aznol:350mg", "hydrapermazol:100mg"), List.of("nillacilan")),
                new MedicalRecords("Jacob", "Boyd", "03/06/1989", List.of("pharmacol:5000mg", "terazine:10mg", "noznazol:250mg"), List.of()),
                new MedicalRecords("Tenley", "Boyd", "02/18/2012", List.of(), List.of("peanut")),
                new MedicalRecords("Roger", "Boyd", "09/06/2017", List.of(), List.of()),
                new MedicalRecords("Felicia", "Boyd", "01/08/1986", List.of("tetracyclaz:650mg"), List.of("xilliathal"))
        ));
    }

    public static MedicalRecords medicalRecordsToDelete(){
        return new MedicalRecords("John", "Boyd", "03/06/1984", List.of("aznol:350mg", "hydrapermazol:100mg"), List.of("nillacilan"));
    }

    public static List<MedicalRecords> getMedicalRecordsListWithDeletedMedicalRecord() {
        return new ArrayList<>(Arrays.asList(
                new MedicalRecords("Jacob", "Boyd", "03/06/1989", List.of("pharmacol:5000mg", "terazine:10mg", "noznazol:250mg"), List.of()),
                new MedicalRecords("Tenley", "Boyd", "02/18/2012", List.of(), List.of("peanut")),
                new MedicalRecords("Roger", "Boyd", "09/06/2017", List.of(), List.of()),
                new MedicalRecords("Felicia", "Boyd", "01/08/1986", List.of("tetracyclaz:650mg"), List.of("xilliathal"))
        ));
    }
}
