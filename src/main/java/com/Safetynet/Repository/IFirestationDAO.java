package com.Safetynet.Repository;

import com.Safetynet.Model.Firestations;

public interface IFirestationDAO {
    Firestations findByNumber(Integer firestationNumber);
    Firestations addFirestations(Firestations firestations);
    Firestations editFirestations(Firestations firestations);
    void deleteFirestations(Firestations firestations);
}
