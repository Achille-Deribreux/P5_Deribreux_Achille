package com.Safetynet.Exceptions.CustomExceptions;

public class MedicalRecordsNotFoundException extends RuntimeException{
    String firstName;
    String lastName;

    public MedicalRecordsNotFoundException(String firstName, String lastName) {
        super("No medicalRecords found for name"+firstName+" "+lastName);
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
