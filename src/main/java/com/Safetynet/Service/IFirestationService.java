package com.Safetynet.Service;

import com.Safetynet.Model.Firestations;

public interface IFirestationService {

    public Firestations addFirestation(Firestations firestations);
    public Firestations editFirestation(Firestations firestations);
    public void deleteFirestation(Firestations firestations);
}
