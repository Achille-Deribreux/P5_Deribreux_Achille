package com.Safetynet.Service;

import com.Safetynet.Model.Firestations;

public interface IFirestationService {

    public Firestations addFirestation(Firestations firestations);
    public Firestations editFirestations(Firestations firestations);
    public void deleteFirestations(Firestations firestations);
}
