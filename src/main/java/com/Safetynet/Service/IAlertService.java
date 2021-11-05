package com.Safetynet.Service;

import com.Safetynet.Model.Specific.ChildAlert;
import com.Safetynet.Model.Specific.Fire;
import com.Safetynet.Model.Specific.Flood;
import com.Safetynet.Model.Specific.ListByFirestation;
import com.Safetynet.Model.Specific.utils.FullInfoPerson;

import java.util.List;

public interface IAlertService {
    ListByFirestation getPersonsListByFirestation(Integer firestation);
    ChildAlert getChildsAndAdultsByAddress(String address);
    List<String> getAllPhonesByFirestationNumber(Integer firestationNumber);
    Fire getPersonByAddress(String address);
    List<Flood> getPersonsAndAddressByFirestationNumber(List<Integer> firestationNumberList);
    List<FullInfoPerson> getFullInfoPersonByName(String firstName, String lastName);
    List<String> getEmailListByCity(String city);
}
