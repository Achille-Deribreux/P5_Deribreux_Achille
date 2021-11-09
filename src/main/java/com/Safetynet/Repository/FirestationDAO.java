package com.Safetynet.Repository;

import com.Safetynet.Model.Firestations;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FirestationDAO implements IFirestationDAO{
    private List<Firestations> firestationsList;
    private static final Logger LOGGER = LogManager.getLogger(FirestationDAO.class);
    public List<Firestations> getFirestationsList() {
        return firestationsList;
    }

    public void setFirestationsList(List<Firestations> firestationsList) {
        this.firestationsList = firestationsList;
    }

    @Override
    public Firestations findByNumber(Integer firestationNumber){
        return  firestationsList.stream()
            .filter(f -> f.getStation() == firestationNumber)
            .findAny().orElse(null);
    }

    @Override
    public Firestations addFirestations(Firestations firestations) {
        try{
            if(firestations == null){
                LOGGER.error("argument null");
                throw new NullPointerException();
            }else {
                firestationsList.add(firestations);
                LOGGER.info("ressource bien ajoutée");
                return firestations;
            }
        }catch(Exception e){
            LOGGER.error("impossible d'ajouter la ressource", e);
        }
        return null;//TODO : change return statement
    }

    @Override
    public Firestations editFirestations(Firestations firestations) {
        try{
            if (firestations == null) {
                LOGGER.error("argument null");
                throw new NullPointerException();
            }else {
                Firestations firestationToUpdate = firestationsList.stream()
                        .filter(f -> f.getAddress().equals(firestations.getAddress()))
                        .findAny().orElse(null);
                if(firestationToUpdate == null){
                    LOGGER.error("Firestation non trouvée");
                    throw new NullPointerException();
                }else {
                    firestationsList.set(firestationsList.indexOf(firestationToUpdate),firestations);
                    LOGGER.info("Firestation bien modifiée");
                    return firestations;
                }
            }
        }catch(Exception e){
            LOGGER.error("impossible de modifier un medicalRecord", e);
        }
        return null;//TODO : change return statement
    }

    @Override
    public void deleteFirestations(Firestations firestations) {
        try{
            if (firestations == null) {
                LOGGER.error("argument null");
                throw new NullPointerException();
            }else {
                Firestations firestationToDelete = firestationsList.stream()
                        .filter(f -> f.getAddress().equals(firestations.getAddress()))
                        .findAny().orElse(null);
                if(firestationToDelete == null){
                    LOGGER.error("ressource non trouvée");
                    throw new NullPointerException();
                }else {
                    firestationsList.remove(firestationToDelete);
                    LOGGER.info("Firestation bien supprimée");
                }
            }
        }catch(Exception e){
            LOGGER.error("impossible de supprimer une Firestation", e);
        }
    }
}
