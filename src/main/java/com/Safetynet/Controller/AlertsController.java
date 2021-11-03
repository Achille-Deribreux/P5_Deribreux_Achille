package com.Safetynet.Controller;

import com.Safetynet.Model.Specific.ChildAlert;
import com.Safetynet.Model.Specific.Fire;
import com.Safetynet.Model.Specific.Flood;
import com.Safetynet.Model.Specific.ListByFirestation;
import com.Safetynet.Model.Specific.utils.FullInfoPerson;
import com.Safetynet.Service.AlertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AlertsController {

    @Autowired
    AlertService alertService;

    @GetMapping(value = "/communityEmail")
    public List<String> showEmailsByCity(@RequestParam(value = "city") String city){
        return alertService.getEmailListByCity(city);
    }

    @GetMapping(value = "/phoneAlert")
    public List<String>showPhoneByFirestationNumber(@RequestParam(value = "firestation") Integer firestationNumber){
        return alertService.getAllPhonesByFirestationNumber(firestationNumber);
    }

    @GetMapping(value = "/personInfo")
    public List<FullInfoPerson> showPersonInfoByNameAndLastName(@RequestParam(value = "firstName") String firstName, @RequestParam(value = "lastName") String lastName){
        return alertService.getFullInfoPersonByName(firstName,lastName);
    }

    @GetMapping(value="/firestation")
    public ListByFirestation showPersonsListByFirestation(@RequestParam(value = "stationNumber") Integer stationNumber){
        return alertService.getPersonsListByFirestation(stationNumber);
    }

    @GetMapping(value="/childAlert")
    public ChildAlert showChildrensAndAdultsByAdress(@RequestParam(value="address") String address){
        return alertService.getChildsAndAdultsByAddress(address);
    }

    @GetMapping(value = "/fire")
    public Fire showPersonsListAndFirestationNumberByAdress(@RequestParam(value="address")String address){
        return alertService.getPersonByAddress(address);
    }

    @GetMapping(value="/flood/stations")
    public List<Flood> showPersonsAndAddressByFireStationNumber(@RequestParam(value="station_numbers") List<Integer> stationsNumberList){
        return alertService.getPersonsAndAddressByFirestationNumber(stationsNumberList);
    }
}
