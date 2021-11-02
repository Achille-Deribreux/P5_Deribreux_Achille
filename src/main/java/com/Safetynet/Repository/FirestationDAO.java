package com.Safetynet.Repository;

import com.Safetynet.Model.Firestations;

import java.util.List;

public class FirestationDAO implements IFirestationDAO{
    private List<Firestations> firestationsList;

    public List<Firestations> getFirestationsList() {
        return firestationsList;
    }

    public void setFirestationsList(List<Firestations> firestationsList) {
        this.firestationsList = firestationsList;
    }

    @Override
    public Firestations addFirestations(Firestations firestations) {
        firestationsList.add(firestations);
        return firestations;
    }

    @Override
    public Firestations editFirestations(Firestations firestations) {
        return null;
    }

    @Override
    public void deleteFirestations(Firestations firestations) {

    }
}
