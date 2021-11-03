package com.Safetynet.Service;

import com.Safetynet.Model.Firestations;
import com.Safetynet.Repository.FirestationDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FirestationService implements IFirestationService {

    @Autowired
    FirestationDAO firestationDAO;

    @Override
    public List<Firestations> findAll(){
        return firestationDAO.getFirestationsList();
    }

    @Override
    public String findAddressByNumber(Integer firestationNumber){
        for(Firestations firestation : firestationDAO.getFirestationsList()){
            if(firestation.getStation() == firestationNumber){
                return firestation.getAddress();
            }
        }
        return null;
    }

    @Override
    public Integer findNumberByAddress(String address){
        for (Firestations firestation : firestationDAO.getFirestationsList()){
            if(firestation.getAddress().equals(address)){
                return firestation.getStation();
            }
        }
        return null;
    }

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
