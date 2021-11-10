package com.Safetynet.Exceptions.CustomExceptions;

public class FirestationAlreadyExistsException extends RuntimeException{
    String firestationAddress;

    public FirestationAlreadyExistsException(String firestationAddress) {
        super("A Firestation already exist for this address :" + firestationAddress);
        this.firestationAddress = firestationAddress;
    }

    public String getFirestationAddress() {
        return firestationAddress;
    }
}
