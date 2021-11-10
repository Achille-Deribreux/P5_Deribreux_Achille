package com.Safetynet.Exceptions.CustomExceptions;

public class PersonNotFoundException extends RuntimeException{
    String firstName;
    String lastName;

    public PersonNotFoundException(String firstName, String lastName) {
        super("No Person found for name"+firstName+" "+lastName);
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
