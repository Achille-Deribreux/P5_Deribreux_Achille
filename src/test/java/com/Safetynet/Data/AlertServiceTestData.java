package com.Safetynet.Data;

import com.Safetynet.Model.Person;
import com.Safetynet.Model.Specific.ListByFirestation;
import com.Safetynet.Model.Specific.utils.PersonWithNameAdressPhone;

import java.util.ArrayList;
import java.util.List;

public class AlertServiceTestData {
    public static ListByFirestation getPersonsListByFirestation(){
        List<PersonWithNameAdressPhone> personList = new ArrayList<>();
        personList.add(new PersonWithNameAdressPhone("John", "Boyd", "1509 Culver St", "841-874-6512"));
        personList.add(new PersonWithNameAdressPhone("Jacob", "Boyd", "1509 Culver St", "841-874-6513"));
        personList.add(new PersonWithNameAdressPhone("Tenley", "Boyd", "1509 Culver St", "841-874-6512"));
        return new ListByFirestation(personList,2,1);
    }

}
