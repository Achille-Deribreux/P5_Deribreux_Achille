package com.Safetynet.Exceptions.CustomExceptions;

public class FirestationNotFoundExceptions extends RuntimeException{
    Integer firestationNumber;

    public FirestationNotFoundExceptions(Integer firestationNumber) {
        super("No Firestation found for number "+firestationNumber+" !");
        this.firestationNumber = firestationNumber;
    }

    public Integer getFirestationNumber() {
        return firestationNumber;
    }
}
