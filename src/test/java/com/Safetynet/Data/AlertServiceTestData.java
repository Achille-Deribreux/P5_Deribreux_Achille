package com.Safetynet.Data;

import com.Safetynet.Model.Person;
import com.Safetynet.Model.Specific.ChildAlert;
import com.Safetynet.Model.Specific.Fire;
import com.Safetynet.Model.Specific.Flood;
import com.Safetynet.Model.Specific.ListByFirestation;
import com.Safetynet.Model.Specific.utils.FullInfoPerson;
import com.Safetynet.Model.Specific.utils.PersonWithNameAdressPhone;
import com.Safetynet.Model.Specific.utils.PersonWithNameAge;
import com.Safetynet.Model.Specific.utils.PersonWithNameAgeMedRecs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AlertServiceTestData {
    public static ListByFirestation getPersonsListByFirestation(){
        List<PersonWithNameAdressPhone> personList = new ArrayList<>(Arrays.asList(
            new PersonWithNameAdressPhone("John", "Boyd", "1509 Culver St", "841-874-6512"),
            new PersonWithNameAdressPhone("Jacob", "Boyd", "1509 Culver St", "841-874-6513"),
            new PersonWithNameAdressPhone("Tenley", "Boyd", "1509 Culver St", "841-874-6512")
        ));
        return new ListByFirestation(personList,2,1);
    }

    public static ChildAlert getChildAlertData(){
        List<PersonWithNameAge> adultsList = new ArrayList<>(Arrays.asList(
            new PersonWithNameAge("John", "Boyd", 37),
            new PersonWithNameAge("Jacob", "Boyd", 32)
        ));
        List<PersonWithNameAge> childList = new ArrayList<>(Arrays.asList(
                new PersonWithNameAge("Tenley", "Boyd", 9)
        ));
        return new ChildAlert(childList, adultsList);
    }

    public static List<String> getPhoneListFromFirestationNumber() {
        return new ArrayList<>(Arrays.asList("841-874-6512", "841-874-6513", "841-874-6512"));
    }

    public static Fire getFiredAlertData(){
        List<PersonWithNameAgeMedRecs> personsList = new ArrayList<>(Arrays.asList(
                new PersonWithNameAgeMedRecs("John", "Boyd", "841-874-6512",37 , List.of("aznol:350mg", "hydrapermazol:100mg"), List.of("nillacilan")),
                new PersonWithNameAgeMedRecs("Jacob", "Boyd","841-874-6513", 32,  List.of("pharmacol:5000mg", "terazine:10mg", "noznazol:250mg"), List.of()),
                new PersonWithNameAgeMedRecs("Tenley", "Boyd", "841-874-6512",9,  List.of(), List.of("peanut"))
        ));
        return new Fire(3, personsList);
    }

    public static List<Flood> getFloodDataList(){

        List<PersonWithNameAgeMedRecs> firstList = new ArrayList<>(Arrays.asList(
                new PersonWithNameAgeMedRecs("John", "Boyd", "841-874-6512",37, List.of("aznol:350mg", "hydrapermazol:100mg"), List.of("nillacilan")),
                new PersonWithNameAgeMedRecs("Jacob", "Boyd", "841-874-6513",32, List.of("pharmacol:5000mg", "terazine:10mg", "noznazol:250mg"), List.of() ),
                new PersonWithNameAgeMedRecs("Tenley", "Boyd", "841-874-6512", 9, List.of(), List.of("peanut"))));

        List<PersonWithNameAgeMedRecs> secondList = new ArrayList<>(Arrays.asList(
                new PersonWithNameAgeMedRecs("Roger", "Boyd", "841-874-6512", 4,  List.of(), List.of()),
                new PersonWithNameAgeMedRecs("Felicia", "Boyd", "841-874-6544",35,  List.of("tetracyclaz:650mg"), List.of("xilliathal"))));

        return new ArrayList<>(Arrays.asList(
                new Flood("1509 Culver St",firstList),
                new Flood("29 15th St",secondList)
        ));
    }

    public static List<FullInfoPerson> getFullInfoPersonByNameList() {
        return new ArrayList<>(Arrays.asList(
                new FullInfoPerson("John", "Boyd", "1509 Culver St", 37, List.of("aznol:350mg", "hydrapermazol:100mg"), List.of("nillacilan"))
        ));
    }

    public static List<String> getEmailsFromCityList() {
        return new ArrayList<>(Arrays.asList("jaboyd@email.com", "drk@email.com", "tenz@email.com", "jaboyd@email.com", "jaboyd@email.com"));
    }

}
