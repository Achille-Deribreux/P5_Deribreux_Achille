package com.Safetynet.Utils;

import com.Safetynet.Model.MedicalRecords;
import com.Safetynet.Repository.MedicalRecordsDAO;
import com.Safetynet.Service.MedicalRecordService;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class AgeCalculator {
    @Autowired
    MedicalRecordsDAO medicalRecordsDAO;

    public Integer getAgeFromName(String firstName, String lastName){
        for(MedicalRecords medicalRecords : medicalRecordsDAO.getMedicalRecordsList()){
            if(medicalRecords.getFirstName().equals(firstName)&&medicalRecords.getLastName().equals(lastName)){
                return getAgeFromBirthDate(medicalRecords.getBirthdate());
            }
        }
        return null;
    }

    public Integer getAgeFromBirthDate(String birthdate){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        Period period = LocalDate.parse(birthdate, formatter).until(LocalDate.now());
        return period.getYears();
    }
}
