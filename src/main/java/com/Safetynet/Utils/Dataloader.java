package com.Safetynet.Utils;

import com.Safetynet.Model.Data;
import com.Safetynet.Repository.FirestationDAO;
import com.Safetynet.Repository.MedicalRecordsDAO;
import com.Safetynet.Repository.PersonDAO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;

@Component
public class Dataloader {

    @Autowired
    PersonDAO personDAO;
    @Autowired
    MedicalRecordsDAO medicalRecordsDAO;
    @Autowired
    FirestationDAO firestationDAO;

    Data data;
    static ObjectMapper mapper = new ObjectMapper();

    public Data loadData(){
        try {
            data = mapper.readValue(new File("data.json"), Data.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }

    @PostConstruct
    private void postConstruct(){
        personDAO.setPersonList(loadData().getPersons());
        medicalRecordsDAO.setMedicalRecordsList(loadData().getMedicalrecords());
        firestationDAO.setFirestationsList(loadData().getFirestations());
    }
}
