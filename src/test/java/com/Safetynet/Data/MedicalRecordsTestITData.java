package com.Safetynet.Data;

import com.Safetynet.Model.MedicalRecords;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MedicalRecordsTestITData {

    public static MedicalRecords findMedicalRecordsByName(){
        return new MedicalRecords("John", "Boyd", "03/06/1984", List.of("aznol:350mg", "hydrapermazol:100mg"), List.of("nillacilan"));
    }

    public static MedicalRecords getMedicalRecordToAdd() {
        return new MedicalRecords("Achille", "Deribreux", "11/03/2000", List.of("aznol:350mg", "hydrapermazol:100mg"), List.of("nillacilan"));
    }

    public static List<MedicalRecords> getMedicalRecordsListWithAddedMedicalRecords() {
        return new ArrayList<>(Arrays.asList(
                new MedicalRecords("John", "Boyd", "03/06/1984", List.of("aznol:350mg", "hydrapermazol:100mg"), List.of("nillacilan")),
                new MedicalRecords("Jacob", "Boyd", "03/06/1989", List.of("pharmacol:5000mg", "terazine:10mg", "noznazol:250mg"), List.of()),
                new MedicalRecords("Tenley", "Boyd", "02/18/2012", List.of(), List.of("peanut")),
                new MedicalRecords("Roger", "Boyd", "09/06/2017", List.of(), List.of()),
                new MedicalRecords("Felicia", "Boyd", "01/08/1986", List.of("tetracyclaz:650mg"), List.of("xilliathal")),
                new MedicalRecords("Achille", "Deribreux", "11/03/2000", List.of("aznol:350mg", "hydrapermazol:100mg"), List.of("nillacilan"))
        ));
    }

    public static MedicalRecords getMedicalRecordToEdit(){
        return new MedicalRecords("John", "Boyd", "03/06/2000", List.of("aznol:350mg", "hydrapermazol:100mg"), List.of("nillacilan"));
    }

    public static List<MedicalRecords> getMedicalRecordsListWithEditedMedicalRecords() {
        return new ArrayList<>(Arrays.asList(
                new MedicalRecords("John", "Boyd", "03/06/2000", List.of("aznol:350mg", "hydrapermazol:100mg"), List.of("nillacilan")),
                new MedicalRecords("Jacob", "Boyd", "03/06/1989", List.of("pharmacol:5000mg", "terazine:10mg", "noznazol:250mg"), List.of()),
                new MedicalRecords("Tenley", "Boyd", "02/18/2012", List.of(), List.of("peanut")),
                new MedicalRecords("Roger", "Boyd", "09/06/2017", List.of(), List.of()),
                new MedicalRecords("Felicia", "Boyd", "01/08/1986", List.of("tetracyclaz:650mg"), List.of("xilliathal"))
        ));
    }

    public static MedicalRecords getMedicalRecordsToDelete(){
        return new MedicalRecords("John", "Boyd", "03/06/1984", List.of("aznol:350mg", "hydrapermazol:100mg"), List.of("nillacilan"));
    }

    public static List<MedicalRecords> getMedicalRecordsListWithDeletedMedicalRecords() {
        return new ArrayList<>(Arrays.asList(
                new MedicalRecords("Jacob", "Boyd", "03/06/1989", List.of("pharmacol:5000mg", "terazine:10mg", "noznazol:250mg"), List.of()),
                new MedicalRecords("Tenley", "Boyd", "02/18/2012", List.of(), List.of("peanut")),
                new MedicalRecords("Roger", "Boyd", "09/06/2017", List.of(), List.of()),
                new MedicalRecords("Felicia", "Boyd", "01/08/1986", List.of("tetracyclaz:650mg"), List.of("xilliathal"))
        ));
    }
}
