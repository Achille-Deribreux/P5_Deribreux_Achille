package com.Safetynet.Repository;

import com.Safetynet.Model.Firestations;

public interface IFirestationDAO {
    public Firestations addFirestations(Firestations firestations);
    public Firestations editFirestations(Firestations firestations);
    public void deleteFirestations(Firestations firestations);
}
