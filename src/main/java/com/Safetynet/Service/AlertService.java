package com.Safetynet.Service;

import com.Safetynet.Model.Person;
import com.Safetynet.Model.Specific.FirestationZone;
import com.Safetynet.Repository.FirestationDAO;
import com.Safetynet.Repository.MedicalRecordsDAO;
import com.Safetynet.Repository.PersonDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AlertService {

    @Autowired
    PersonDAO personDAO;

    @Autowired
    FirestationDAO firestationDAO;

    @Autowired
    MedicalRecordsDAO medicalRecordsDAO;

    public FirestationZone getPersonsListByFirestation(Integer firestationNumber) {
        List<Person> personsList = new ArrayList<>();
        Integer childrenCounter = 0;
        Integer adultsCounter = 0;

        return null;
    }
}
