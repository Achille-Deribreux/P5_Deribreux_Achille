package com.Safetynet.Service;

import com.Safetynet.Model.Specific.ChildAlert;
import com.Safetynet.Model.Specific.Fire;
import com.Safetynet.Model.Specific.Flood;
import com.Safetynet.Model.Specific.ListByFirestation;
import com.Safetynet.Model.Specific.utils.FullInfoPerson;

import java.util.List;

public interface IAlertService {

    /**
     * Method who search in the persons list the persons who are deserved by a specific firestation
     * @Param  number of the firestation (Integer)
     * @Return  a list with people's info and an adults + childrens counter (ListByFirestation)
     */
    ListByFirestation getPersonsListByFirestation(Integer firestation);


    /**
     * Method who search after the childrens and aldults of a specific address
     * @Param address of the alert (String)
     * @Return An adults & childrens list. Empty if no childs at this address (ChildAlert)
     */
    ChildAlert getChildsAndAdultsByAddress(String address);


    /**
     * Method who search into the PersonsList for phone number from people who are deserved by a specific firestation
     * @Param number of the firestation (Integer)
     * @Return list of phone number of people who are deserved by this firestation (List of String)
     */
    List<String> getAllPhonesByFirestationNumber(Integer firestationNumber);

    /**
     * Method who search persons into the PersonsList for a specific address
     * @Param the address (String)
     * @Return FirestationNumber and a list of persons who are deserved by this firestation (Fire)
     */
    Fire getPersonByAddress(String address);

    /**
     * Method who search for persons by firestationsNumber
     * @Param List of firestations numbers (List of Integer)
     * @Return List of Persons and firestation number grouped by firestation (List of Flood)
     */
    List<Flood> getPersonsAndAddressByFirestationNumber(List<Integer> firestationNumberList);

    /**
     * Method who search full info (medical records) of a person, if there is more than one person, with same first & last name, it returns them all
     * @Param firstname and lastname (String)
     * @Return List of persons with full info (medical records) (List of FullInfoPerson)
     */
    List<FullInfoPerson> getFullInfoPersonByName(String firstName, String lastName);

    /**
     * Method who search the emails of people for a given city
     * @Param City where we need emails (String)
     * @Return List of emails of people who lives in the given city (List of String)
     */
    List<String> getEmailListByCity(String city);
}
