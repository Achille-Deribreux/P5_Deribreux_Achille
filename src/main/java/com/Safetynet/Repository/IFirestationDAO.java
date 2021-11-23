package com.Safetynet.Repository;

import com.Safetynet.Model.Firestations;

public interface IFirestationDAO {

    /**
     *Method who search a specific firestation
     * @param  firestationNumber number of the wanted firestation
     * @return the wanted firestation (Firestation)
     */
    Firestations findByNumber(Integer firestationNumber);

    /**
     * Method who add a firestation in the list
     * @param firestations a firestation that we want to add
     * @return the added firestation
     */
    Firestations addFirestations(Firestations firestations);

    /**
     * Method who edit a firestation
     * @param firestations a firestation that we want to edit
     * @return the edited firestation
     */
    Firestations editFirestations(Firestations firestations);

    /**
     * Method who delete a given firestation from the list
     * @param firestations the firestation that we want to delete
     */
    void deleteFirestations(Firestations firestations);
}
