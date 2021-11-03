package com.Safetynet.Utils;

import com.Safetynet.Model.Firestations;
import com.Safetynet.Repository.FirestationDAO;
import org.springframework.beans.factory.annotation.Autowired;

public class Util {

    @Autowired
    FirestationDAO firestationDAO;

    public String getAddressByFirestationNumber(Integer firestationNumber){
        for(Firestations firestation : firestationDAO.getFirestationsList()){
            if(firestation.getStation() == firestationNumber){
                return firestation.getAddress();
            }
        }
        return null;
    }
}
