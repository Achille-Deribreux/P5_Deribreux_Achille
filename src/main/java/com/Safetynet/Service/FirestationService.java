package com.Safetynet.Service;

import com.Safetynet.Exceptions.CustomExceptions.FirestationNotFoundByAddressException;
import com.Safetynet.Exceptions.CustomExceptions.FirestationNotFoundExceptions;
import com.Safetynet.Model.Firestations;
import com.Safetynet.Model.Specific.Fire;
import com.Safetynet.Repository.FirestationDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FirestationService implements IFirestationService {

    @Autowired
    FirestationDAO firestationDAO;

    private static final Logger LOGGER = LogManager.getLogger(FirestationService.class);

    public void setFirestationDAO(FirestationDAO firestationDAO) {
        LOGGER.debug("firestationDAO setted");
        this.firestationDAO = firestationDAO;
    }

    @Override
    public List<Firestations> findAll(){
        LOGGER.debug("firestationDAO.getFirestationsList have been called");
        return firestationDAO.getFirestationsList();
    }

    @Override
    public Firestations findByNumber(Integer firestationNumber){
        LOGGER.debug("firestationDAO.findByNumber call with :"+firestationNumber);
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
        LOGGER.debug("firestationDAO.addFirestations call with :"+firestations);
        return firestationDAO.addFirestations(firestations);
    }

    @Override
    public Firestations editFirestation(Firestations firestations) {
        LOGGER.debug("firestationDAO.editFirestations call with :"+firestations);
        return firestationDAO.editFirestations(firestations);
    }

    @Override
    public void deleteFirestation(Firestations firestations) {
        LOGGER.debug("firestationDAO.deleteFirestations call with :"+firestations);
        firestationDAO.deleteFirestations(firestations);
    }
}
