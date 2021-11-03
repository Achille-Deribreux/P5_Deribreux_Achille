package com.Safetynet.Service;

import com.Safetynet.Model.Person;
import com.Safetynet.Model.Specific.ChildAlert;
import com.Safetynet.Model.Specific.ListByFirestation;
import com.Safetynet.Model.Specific.utils.PersonWithNameAdressPhone;
import com.Safetynet.Model.Specific.utils.PersonWithNameAge;
import com.Safetynet.Repository.FirestationDAO;
import com.Safetynet.Repository.MedicalRecordsDAO;
import com.Safetynet.Repository.PersonDAO;
import com.Safetynet.Utils.AgeCalculator;
import com.Safetynet.Utils.Util;
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

    AgeCalculator ageCalculator = new AgeCalculator();
    Util util = new Util();

    public ListByFirestation getPersonsListByFirestation(Integer firestation){
        List<PersonWithNameAdressPhone> personWithNameAddressPhoneList = new ArrayList<>();
        int childrenCounter = 0;
        int adultsCounter = 0;
        String firestationAddress = util.getAddressByFirestationNumber(firestation);

        for(Person person : personDAO.getPersonList()){
            if (person.getAddress().equals(firestationAddress)){
                personWithNameAddressPhoneList.add(new PersonWithNameAdressPhone(person.getFirstName(), person.getLastName(), person.getAddress(), person.getPhone()));
                if (ageCalculator.getAgeFromName(person.getFirstName(), person.getLastName()) < 18){
                    childrenCounter ++;
                }
                else if(ageCalculator.getAgeFromName(person.getFirstName(), person.getLastName()) > 18){
                    adultsCounter ++;
                }
            }
        }
        return new ListByFirestation(personWithNameAddressPhoneList, adultsCounter, childrenCounter);
    }

    public ChildAlert getChildsAndAdultsByAddress(String address){
        List<PersonWithNameAge> adultsList = new ArrayList<>();
        List<PersonWithNameAge> childrenList = new ArrayList<>();

        for(Person person : personDAO.getPersonList()){
            if(person.getAddress().equals(address)){
                PersonWithNameAge personToAdd = new PersonWithNameAge(person.getFirstName(), person.getLastName(), ageCalculator.getAgeFromName(person.getFirstName(), person.getLastName()));
                if(personToAdd.getAge() < 18){
                    childrenList.add(personToAdd);
                }else if(personToAdd.getAge() > 18){
                    adultsList.add(personToAdd);
                }
            }
        }
        //TODO : Retour vide si pas d'enfants
        return new ChildAlert(childrenList, adultsList);
    }

    public List<String> getAllPhonesByFirestationNumber(Integer firestationNumber){
        String firestationAddress = util.getAddressByFirestationNumber(firestationNumber);
        List<String> phoneNumberList = new ArrayList<>();

        for(Person person : personDAO.getPersonList()){
            if(person.getAddress().equals(firestationAddress)){
                phoneNumberList.add(person.getPhone());
            }
        }
        return phoneNumberList;
    }
    
}
