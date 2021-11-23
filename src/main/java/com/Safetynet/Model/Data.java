package com.Safetynet.Model;

import java.util.List;
import java.util.Objects;

public class Data {
    private List<Person> persons;
    private List<Firestations> firestations;
    private List<MedicalRecords> medicalrecords;

    public Data() {
    }

    public Data(List<Person> persons, List<Firestations> firestations, List<MedicalRecords> medicalrecords) {
        this.persons = persons;
        this.firestations = firestations;
        this.medicalrecords = medicalrecords;
    }

    public List<Person> getPersons() {
        return persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }

    public List<Firestations> getFirestations() {
        return firestations;
    }

    public void setFirestations(List<Firestations> firestations) {
        this.firestations = firestations;
    }

    public List<MedicalRecords> getMedicalrecords() {
        return medicalrecords;
    }

    public void setMedicalrecords(List<MedicalRecords> medicalrecords) {
        this.medicalrecords = medicalrecords;
    }

    @Override
    public String toString() {
        return "Data{" +
                "persons=" + persons +
                ", firestations=" + firestations +
                ", medicalrecords=" + medicalrecords +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Data)) return false;
        Data data = (Data) o;
        return Objects.equals(persons, data.persons) && Objects.equals(firestations, data.firestations) && Objects.equals(medicalrecords, data.medicalrecords);
    }

    @Override
    public int hashCode() {
        return Objects.hash(persons, firestations, medicalrecords);
    }
}
