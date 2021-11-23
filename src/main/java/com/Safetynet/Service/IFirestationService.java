package com.Safetynet.Service;

import com.Safetynet.Model.Firestations;

import java.util.List;

public interface IFirestationService {

    /**
     * Method who search all the firestations in the list
     * @return list of all the firestatoins (List of Firestation)
     */
     List<Firestations> findAll();

    /**
     *Method who search a specific firestation
     * @param  firestationNumber number of the wanted firestation
     * @return the wanted firestation (Firestation)
     */
    Firestations findByNumber(Integer firestationNumber);

    /**
     *Method who search the address of a firestation, based on its number
     * @param firestationNumber number of the firestation from which we want the address
     * @return address of the firestation (String)
     */
    String findAddressByNumber(Integer firestationNumber);

    /**
     *Method who search the number of the firestation, based on its address
     * @param address address of the firestation from which we want the number
     * @return number of the firestation
     */
    Integer findNumberByAddress(String address);

    /**
     * Method who add a firestation in the list
     * @param firestations a firestation that we want to add
     * @return the added firestation
     */
     Firestations addFirestation(Firestations firestations);

    /**
     * Method who edit a firestation
     * @param firestations a firestation that we want to edit
     * @return the edited firestation
     */
     Firestations editFirestation(Firestations firestations);

    /**
     * Method who delete a given firestation from the list
     * @param firestations the firestation that we want to delete
     */
    void deleteFirestation(Firestations firestations);
}
