package com.Safetynet.Exceptions.CustomExceptions;

public class PersonAlreadyExistsException extends RuntimeException{
    String firstName;
    String lastName;

    public PersonAlreadyExistsException(String firstName, String lastName) {
        super("A person with the following firstname & lastname already exists "+ firstName+" "+lastName);
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
