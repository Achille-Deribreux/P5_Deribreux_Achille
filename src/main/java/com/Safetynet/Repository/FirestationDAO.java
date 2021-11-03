package com.Safetynet.Repository;

import com.Safetynet.Model.Firestations;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
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
        Firestations firestationToUpdate = null;
        for(Firestations f : firestationsList) {
            if (f.getAddress().equals(firestations.getAddress())) {
                firestationToUpdate = f;
            }
        }
        if(firestationToUpdate != null){
            firestationsList.set(firestationsList.indexOf(firestationToUpdate),firestations);
            return firestations;
        }
        return null;
    }

    @Override
    public void deleteFirestations(Firestations firestations) {
        Firestations firestationToDelete = null;
        for(Firestations f : firestationsList) {
            if (f.getAddress().equals(firestations.getAddress())) {
                firestationToDelete = f;
            }
        }
        if(firestationToDelete != null){
            firestationsList.remove(firestationToDelete);
        }
    }
}
