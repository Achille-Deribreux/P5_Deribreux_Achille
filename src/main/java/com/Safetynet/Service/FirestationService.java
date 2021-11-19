package com.Safetynet.Service;

import com.Safetynet.Exceptions.CustomExceptions.FirestationNotFoundByAddressException;
import com.Safetynet.Exceptions.CustomExceptions.FirestationNotFoundExceptions;
import com.Safetynet.Model.Firestations;
import com.Safetynet.Model.Specific.Fire;
import com.Safetynet.Repository.FirestationDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FirestationService implements IFirestationService {

    @Autowired
    FirestationDAO firestationDAO;

    public void setFirestationDAO(FirestationDAO firestationDAO) {
        this.firestationDAO = firestationDAO;
    }

    @Override
    public List<Firestations> findAll(){
        return firestationDAO.getFirestationsList();
    }

    @Override
    public Firestations findByNumber(Integer firestationNumber){
        return firestationDAO.findByNumber(firestationNumber);
    }

    @Override
    public String findAddressByNumber(Integer firestationNumber){
        return findAll().stream()
                .filter(f->f.getStation()==firestationNumber).findAny()
                .orElseThrow(()->new FirestationNotFoundExceptions(firestationNumber)).getAddress();
    }

    @Override
    public Integer findNumberByAddress(String address){
        return findAll().stream()
                .filter(f->f.getAddress().equals(address)).findAny()
                .orElseThrow(()->new FirestationNotFoundByAddressException(address)).getStation();
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
