package com.Safetynet.Service;

import com.Safetynet.Model.MedicalRecords;

import java.util.List;

public interface IMedicalRecordService {

    /**
     * Method who search all the MedicalRecords in the list
     * @return list of all the MedicalRecords (List of MedicalRecords)
     */
    List<MedicalRecords> findAll();

    /**
     * Method who find allergies of someone by his name
     * @param firstName firstname of the person which we want his allergies
     * @param lastName lastName of the person which we want his allergies
     * @return
     */
    List<String>findAllergiesByName(String firstName, String lastName);

    /**
     * Method who find medication of someone by his name
     * @param firstName firstName of the person which we want his medication
     * @param lastName lastName of the person which we want his medication
     * @return
     */
    List<String>findMedicationsByName(String firstName, String lastName);

    /**
     * Method who add a medicalrecord, based on firstname & name
     * @param medicalRecords medicalrecord that we want to add
     * @return added medicalrecord
     */
    MedicalRecords addMedicalRecords(MedicalRecords medicalRecords);

    /**
     * Method who edit a medicalrecord, based on firstname & name
     * @param medicalRecords medicalrecord that we want to edit
     * @return edited medicalrecord
     */
    MedicalRecords editMedicalRecords(MedicalRecords medicalRecords);

    /**
     * Method who delete a medicalrecord
     * @param medicalRecords medicalrecord that we want to delete
     */
    void deleteMedicalRecords(MedicalRecords medicalRecords);
}
