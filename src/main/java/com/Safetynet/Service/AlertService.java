package com.Safetynet.Service;

import com.Safetynet.Controller.AlertsController;
import com.Safetynet.Model.Person;
import com.Safetynet.Model.Specific.ChildAlert;
import com.Safetynet.Model.Specific.Fire;
import com.Safetynet.Model.Specific.Flood;
import com.Safetynet.Model.Specific.ListByFirestation;
import com.Safetynet.Model.Specific.utils.FullInfoPerson;
import com.Safetynet.Model.Specific.utils.PersonWithNameAdressPhone;
import com.Safetynet.Model.Specific.utils.PersonWithNameAge;
import com.Safetynet.Model.Specific.utils.PersonWithNameAgeMedRecs;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class AlertService implements IAlertService{

    private static final Logger LOGGER = LogManager.getLogger(AlertService.class);

    @Autowired
    PersonService personService;

    @Autowired
    FirestationService firestationService;

    @Autowired
    MedicalRecordService medicalRecordService;

    public void setPersonService(PersonService personService) {
        this.personService = personService;
    }

    public void setFirestationService(FirestationService firestationService) {
        this.firestationService = firestationService;
    }

    public void setMedicalRecordService(MedicalRecordService medicalRecordService) {
        this.medicalRecordService = medicalRecordService;
    }

    @Override
    public ListByFirestation getPersonsListByFirestation(Integer firestation){
        List<PersonWithNameAdressPhone> personWithNameAddressPhoneList = new ArrayList<>();
        int childrenCounter = 0;
        int adultsCounter = 0;
        LOGGER.debug("Array+childrenCounter+AdultsCounter initialized on empty/0");
        String firestationAddress = firestationService.findAddressByNumber(firestation);

        for(Person person : personService.findAll()){
            LOGGER.debug("Start stream personService.findAll()");
            if (person.getAddress().equals(firestationAddress)){
                LOGGER.debug("Person address is matching !");
                personWithNameAddressPhoneList.add(new PersonWithNameAdressPhone(person.getFirstName(), person.getLastName(), person.getAddress(), person.getPhone()));
                if (medicalRecordService.findAgeFromName(person.getFirstName(), person.getLastName()) < 18){
                    childrenCounter ++;
                    LOGGER.debug("ChildrenCounter incremented");
                }
                else if(medicalRecordService.findAgeFromName(person.getFirstName(), person.getLastName()) > 18){
                    adultsCounter ++;
                    LOGGER.debug("adultsCounter incremented");
                }
            }
        }
        LOGGER.debug("end for, return arrayList & counters");
        return new ListByFirestation(personWithNameAddressPhoneList, adultsCounter, childrenCounter);
    }

    @Override
    public ChildAlert getChildsAndAdultsByAddress(String address){
        LOGGER.debug("Initialize adults & Childrenlists");
        List<PersonWithNameAge> adultsList = new ArrayList<>();
        List<PersonWithNameAge> childrenList = new ArrayList<>();

        for(Person person : personService.findAll()){
            LOGGER.debug("start loop on personService.findAll()");
            if(person.getAddress().equals(address)){
                LOGGER.debug("Person address" + person.getAddress()+ "is matching");
                PersonWithNameAge personToAdd = new PersonWithNameAge(person.getFirstName(), person.getLastName(), medicalRecordService.findAgeFromName(person.getFirstName(), person.getLastName()));
                if(personToAdd.getAge() < 18){
                    LOGGER.debug("Add person to childrenList beacause age is "+ personToAdd.getAge());
                    childrenList.add(personToAdd);
                }else if(personToAdd.getAge() > 18){
                    LOGGER.debug("Add person to adultsList beacause age is "+ personToAdd.getAge());
                    adultsList.add(personToAdd);
                }
            }
        }
        if (childrenList.size() != 0) {
            LOGGER.debug("return ChildAlert");
            return new ChildAlert(childrenList, adultsList);
        }else {
            LOGGER.debug("no childrens in the list, return empty ChildAlert");
            return new ChildAlert();
        }
    }

    @Override
    public List<String> getAllPhonesByFirestationNumber(Integer firestationNumber){
        String firestationAddress = firestationService.findAddressByNumber(firestationNumber);
        List<String> phoneNumberList = new ArrayList<>();

        for(Person person : personService.findAll()){
            LOGGER.debug("start loop on personService.findAll()");
            if(person.getAddress().equals(firestationAddress)){
                LOGGER.debug("Person address is matching :"+person.getAddress());
                phoneNumberList.add(person.getPhone());
            }
        }
        return phoneNumberList;
    }

    @Override
    public Fire getPersonByAddress(String address){
        Integer firestationNumber = firestationService.findNumberByAddress(address);
        LOGGER.debug("get firestation number : "+firestationNumber);
        List<PersonWithNameAgeMedRecs> personWithNameAgeMedRecsList = new ArrayList<>();

        for(Person person : personService.findAll()){
            if (person.getAddress().equals(address)){
                LOGGER.debug("person address : "+person.getAddress()+" matches with firestationAddress "+ address);
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
            LOGGER.debug("FirestationAddress is " +firestationAddress);
            List<PersonWithNameAgeMedRecs> personWithNameAgeMedRecsList = new ArrayList<>();

            for (Person person : personService.findAll()){
                if(person.getAddress().equals(firestationAddress)){
                    LOGGER.debug("Person address match ! "+ person.getAddress());
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
            LOGGER.debug("Flood : "+new Flood(firestationAddress,personWithNameAgeMedRecsList)+" added to floodList");
        }
        return floodList;
    }

    @Override
    public List<FullInfoPerson> getFullInfoPersonByName(String firstName, String lastName){
        List<FullInfoPerson> fullInfoPersonList = new ArrayList<>();

        for (Person person : personService.findAll()){
            LOGGER.debug("Loop started on personService.findAll()");
            if(person.getFirstName().equals(firstName)&&person.getLastName().equals(lastName)){
                LOGGER.debug("Name :" +firstName+" "+lastName+" is equal to "+person.getFirstName()+" "+person.getLastName());
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
        LOGGER.debug("Return fullinfoPersonList "+fullInfoPersonList);
        return fullInfoPersonList;
    }

    @Override
    public List<String> getEmailListByCity(String city){
        List<String> emailList = new ArrayList<>();

        for(Person person : personService.findAll()){
            LOGGER.debug("Loop started on personService.findAll()");
            if(person.getCity().equals(city)){
                LOGGER.debug("personCity :" +city+" matches "+person.getCity());
                emailList.add(person.getEmail());
            }
        }
        LOGGER.debug("Return emailList "+emailList);
        return emailList;
    }

}
