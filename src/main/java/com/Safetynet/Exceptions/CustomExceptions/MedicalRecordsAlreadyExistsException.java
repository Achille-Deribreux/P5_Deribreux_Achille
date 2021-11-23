package com.Safetynet.Exceptions.CustomExceptions;

public class MedicalRecordsAlreadyExistsException extends RuntimeException{
    String firstName;
    String lastName;

    public MedicalRecordsAlreadyExistsException(String firstName, String lastName) {
        super("MedicalRecords already exists for the following firstname & lastname"+ firstName+" "+lastName);
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

}
