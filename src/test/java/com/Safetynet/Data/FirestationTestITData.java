package com.Safetynet.Data;

import com.Safetynet.Model.Firestations;
import com.Safetynet.Model.Specific.Fire;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FirestationTestITData {

    public static Firestations getFirestationByNumber(){
        return new Firestations("1509 Culver St", 3);
    }

    public static Firestations getFirestationToAdd(){
        return new Firestations("address", 1);
    }

    public static List<Firestations> getFirestationsListWithAddedFirestation() {
            return new ArrayList<>(Arrays.asList(
                    new Firestations("1509 Culver St", 3),
                    new Firestations("29 15th St", 2),
                    new Firestations("address", 1)
        ));
    }

    public static Firestations getFirestationToEdit(){
        return new Firestations("1509 Culver St", 8);
    }

    public static List<Firestations> getFirestationsListWithEditedFirestation() {
        return new ArrayList<>(Arrays.asList(
                new Firestations("1509 Culver St", 8),
                new Firestations("29 15th St", 2)
        ));
    }

    public static Firestations getFirestationToDelete(){
        return new Firestations("29 15th St", 2);
    }

    public static List<Firestations> getFirestationsListWithDeletedFirestation() {
        return new ArrayList<>(Arrays.asList(
                new Firestations("1509 Culver St", 3)
        ));
    }


}
