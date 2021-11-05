package com.Safetynet.Data;

import com.Safetynet.Model.Firestations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FirestationDAOTestData {

    public static Firestations firestationToAdd(){
        return new Firestations("test address", 4);
    }

    public static List<Firestations> getFirestationsListWithAddedStation() {
        return new ArrayList<>(Arrays.asList(
                new Firestations("1509 Culver St", 3),
                new Firestations("29 15th St", 2),
                new Firestations("test address", 4)
        ));
    }

    public static Firestations firestationToEdit(){
        return new Firestations("29 15th St", 8);
    }

    public static List<Firestations> getFirestationsListWithEditedStation() {
        return new ArrayList<>(Arrays.asList(
                new Firestations("1509 Culver St", 3),
                new Firestations("29 15th St", 8)
        ));
    }

    public static Firestations firestationToDelete(){
        return new Firestations("29 15th St", 2);
    }

    public static List<Firestations> getFirestationsListWithDeletedStation() {
        return new ArrayList<>(Arrays.asList(
                new Firestations("1509 Culver St", 3)
        ));
    }

}
