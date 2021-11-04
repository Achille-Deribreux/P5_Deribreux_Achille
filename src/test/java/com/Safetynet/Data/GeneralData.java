package com.Safetynet.Data;

import com.Safetynet.Model.Firestations;
import com.Safetynet.Model.MedicalRecords;
import com.Safetynet.Model.Person;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GeneralData {
    public static List<Person> getPersonList() {
        return new ArrayList<>(Arrays.asList(
                new Person("John", "Boyd", "1509 Culver St", "Culver", "97451", "841-874-6512", "jaboyd@email.com"),
                new Person("Jacob", "Boyd", "1509 Culver St", "Culver", "97451", "841-874-6513", "drk@email.com"),
                new Person("Tenley", "Boyd", "1509 Culver St", "Culver", "97451", "841-874-6512", "tenz@email.com"),
                new Person("Roger", "Boyd", "29 15th St", "Culver", "97451", "841-874-6512", "jaboyd@email.com"),
                new Person("Felicia", "Boyd", "29 15th St", "Culver", "97451", "841-874-6544", "jaboyd@email.com")
        ));
    }

    public static List<Firestations> getFirestationsList() {
        return new ArrayList<>(Arrays.asList(
                new Firestations("1509 Culver St", 3),
                new Firestations("29 15th St", 2)
        ));
    }

    public static List<MedicalRecords> getMedicalRecordsList() {
        return new ArrayList<>(Arrays.asList(
                new MedicalRecords("John", "Boyd", "03/06/1984", List.of("aznol:350mg", "hydrapermazol:100mg"), List.of("nillacilan")),
                new MedicalRecords("Jacob", "Boyd", "03/06/1989", List.of("pharmacol:5000mg", "terazine:10mg", "noznazol:250mg"), List.of()),
                new MedicalRecords("Tenley", "Boyd", "02/18/2012", List.of(), List.of("peanut")),
                new MedicalRecords("Roger", "Boyd", "09/06/2017", List.of(), List.of()),
                new MedicalRecords("Felicia", "Boyd", "01/08/1986", List.of("tetracyclaz:650mg"), List.of("xilliathal"))
        ));
    }
}
