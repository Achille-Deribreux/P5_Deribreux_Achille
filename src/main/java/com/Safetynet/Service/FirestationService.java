package com.Safetynet.Service;

import com.Safetynet.Model.Firestations;
import com.Safetynet.Repository.FirestationDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FirestationService implements IFirestationService {

    @Autowired
    FirestationDAO firestationDAO;

    @Override
    public Firestations addFirestation(Firestations firestations) {
        return firestationDAO.addFirestations(firestations);
    }

    @Override
    public Firestations editFirestation(Firestations firestations) {
        return firestationDAO.editFirestations(firestations);
    }

    @Override
    public void deleteFirestation(Firestations firestations) {
        firestationDAO.deleteFirestations(firestations);
    }
}
