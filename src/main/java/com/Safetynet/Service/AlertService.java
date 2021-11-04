package com.Safetynet.Service;

import com.Safetynet.Model.Person;
import com.Safetynet.Model.Specific.ChildAlert;
import com.Safetynet.Model.Specific.Fire;
import com.Safetynet.Model.Specific.Flood;
import com.Safetynet.Model.Specific.ListByFirestation;
import com.Safetynet.Model.Specific.utils.FullInfoPerson;
import com.Safetynet.Model.Specific.utils.PersonWithNameAdressPhone;
import com.Safetynet.Model.Specific.utils.PersonWithNameAge;
import com.Safetynet.Model.Specific.utils.PersonWithNameAgeMedRecs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AlertService implements IAlertService{

    @Autowired
    PersonService personService;

    @Autowired
    FirestationService firestationService;

    @Autowired
    MedicalRecordService medicalRecordService;


    @Override
    public ListByFirestation getPersonsListByFirestation(Integer firestation){
        List<PersonWithNameAdressPhone> personWithNameAddressPhoneList = new ArrayList<>();
        int childrenCounter = 0;
        int adultsCounter = 0;
        String firestationAddress = firestationService.findAddressByNumber(firestation);

        for(Person person : personService.findAll()){
            if (person.getAddress().equals(firestationAddress)){
                personWithNameAddressPhoneList.add(new PersonWithNameAdressPhone(person.getFirstName(), person.getLastName(), person.getAddress(), person.getPhone()));
                if (medicalRecordService.findAgeFromName(person.getFirstName(), person.getLastName()) < 18){
                    childrenCounter ++;
                }
                else if(medicalRecordService.findAgeFromName(person.getFirstName(), person.getLastName()) > 18){
                    adultsCounter ++;
                }
            }
        }
        return new ListByFirestation(personWithNameAddressPhoneList, adultsCounter, childrenCounter);
    }

    @Override
    public ChildAlert getChildsAndAdultsByAddress(String address){
        List<PersonWithNameAge> adultsList = new ArrayList<>();
        List<PersonWithNameAge> childrenList = new ArrayList<>();

        for(Person person : personService.findAll()){
            if(person.getAddress().equals(address)){
                PersonWithNameAge personToAdd = new PersonWithNameAge(person.getFirstName(), person.getLastName(), medicalRecordService.findAgeFromName(person.getFirstName(), person.getLastName()));
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

    @Override
    public List<String> getAllPhonesByFirestationNumber(Integer firestationNumber){
        String firestationAddress = firestationService.findAddressByNumber(firestationNumber);
        List<String> phoneNumberList = new ArrayList<>();

        for(Person person : personService.findAll()){
            if(person.getAddress().equals(firestationAddress)){
                phoneNumberList.add(person.getPhone());
            }
        }
        return phoneNumberList;
    }

    @Override
    public Fire getPersonByAddress(String address){
        Integer firestationNumber = firestationService.findNumberByAddress(address);
        List<PersonWithNameAgeMedRecs> personWithNameAgeMedRecsList = new ArrayList<>();

        for(Person person : personService.findAll()){
            if (person.getAddress().equals(address)){
                personWithNameAgeMedRecsList.add(new PersonWithNameAgeMedRecs(
                        person.getFirstName(),
                        person.getLastName(),
                        person.getPhone(),
                        medicalRecordService.findAgeFromName(person.getFirstName(), person.getLastName()),
                        medicalRecordService.findMedicationsByName(person.getFirstName(), person.getLastName()),
                        medicalRecordService.findAllergiesByName(person.getFirstName(), person.getLastName())
                ));
            }
        }
        return new Fire(firestationNumber,personWithNameAgeMedRecsList);
    }

    @Override
    public List<Flood> getPersonsAndAddressByFirestationNumber(List<Integer> firestationNumberList){
        List<Flood> floodList = new ArrayList<>();

        for(Integer firestationNumber : firestationNumberList){
            String firestationAddress = firestationService.findAddressByNumber(firestationNumber);
            List<PersonWithNameAgeMedRecs> personWithNameAgeMedRecsList = new ArrayList<>();

            for (Person person : personService.findAll()){
                if(person.getAddress().equals(firestationAddress)){
                    personWithNameAgeMedRecsList.add(new PersonWithNameAgeMedRecs(
                            person.getFirstName(),
                            person.getLastName(),
                            person.getPhone(),
                            medicalRecordService.findAgeFromName(person.getFirstName(), person.getLastName()),
                            medicalRecordService.findMedicationsByName(person.getFirstName(), person.getLastName()),
                            medicalRecordService.findAllergiesByName(person.getFirstName(), person.getLastName())
                    ));
                }
            }
            floodList.add(new Flood(firestationAddress,personWithNameAgeMedRecsList));
        }
        return floodList;
    }

    @Override
    public List<FullInfoPerson> getFullInfoPersonByName(String firstName, String lastName){
        List<FullInfoPerson> fullInfoPersonList = new ArrayList<>();

        for (Person person : personService.findAll()){
            if(person.getFirstName().equals(firstName)&&person.getLastName().equals(lastName)){
                fullInfoPersonList.add(new FullInfoPerson(
                        person.getFirstName(),
                        person.getLastName(),
                        person.getAddress(),
                        medicalRecordService.findAgeFromName(person.getFirstName(), person.getLastName()),
                        medicalRecordService.findMedicationsByName(person.getFirstName(), person.getLastName()),
                        medicalRecordService.findAllergiesByName(person.getFirstName(), person.getLastName())
                ));
            }
        }
        return fullInfoPersonList;
    }

    @Override
    public List<String> getEmailListByCity(String city){
        List<String> emailList = new ArrayList<>();

        for(Person person : personService.findAll()){
            if(person.getCity().equals(city)){
                emailList.add(person.getEmail());
            }
        }
        return emailList;
    }

}
