package com.Safetynet.Service;

import com.Safetynet.Model.Firestations;

import java.util.List;

public interface IFirestationService {
     List<Firestations> findAll();
    Firestations findByNumber(Integer firestationNumber);
    String findAddressByNumber(Integer firestationNumber);
    Integer findNumberByAddress(String address);
     Firestations addFirestation(Firestations firestations);
     Firestations editFirestation(Firestations firestations);
     void deleteFirestation(Firestations firestations);
}
