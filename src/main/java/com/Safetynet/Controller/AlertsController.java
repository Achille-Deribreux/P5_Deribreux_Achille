package com.Safetynet.Controller;

import com.Safetynet.Model.Specific.ChildAlert;
import com.Safetynet.Model.Specific.Fire;
import com.Safetynet.Model.Specific.Flood;
import com.Safetynet.Model.Specific.ListByFirestation;
import com.Safetynet.Model.Specific.utils.FullInfoPerson;
import com.Safetynet.Service.AlertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AlertsController {

    @Autowired
    AlertService alertService;

    @GetMapping(value = "/communityEmail")
    public ResponseEntity<List<String>> showEmailsByCity(@RequestParam(value = "city") String city){
          return new ResponseEntity<>(alertService.getEmailListByCity(city), HttpStatus.OK);
    }

    @GetMapping(value = "/phoneAlert")
    public ResponseEntity<List<String>> showPhoneByFirestationNumber(@RequestParam(value = "firestation") Integer firestationNumber){
        return new ResponseEntity<>(alertService.getAllPhonesByFirestationNumber(firestationNumber), HttpStatus.OK);
    }

    @GetMapping(value = "/personInfo")
    public ResponseEntity<List<FullInfoPerson>> showPersonInfoByNameAndLastName(@RequestParam(value = "firstName") String firstName, @RequestParam(value = "lastName") String lastName){
        return new ResponseEntity<>(alertService.getFullInfoPersonByName(firstName,lastName), HttpStatus.OK);
    }

    @GetMapping(value="/firestation")
    public ResponseEntity<ListByFirestation> showPersonsListByFirestation(@RequestParam(value = "stationNumber") Integer stationNumber){
        return new ResponseEntity<>(alertService.getPersonsListByFirestation(stationNumber), HttpStatus.OK);
    }

    @GetMapping(value="/childAlert")
    public ResponseEntity<ChildAlert> showChildrensAndAdultsByAdress(@RequestParam(value="address") String address){
        return new ResponseEntity<>(alertService.getChildsAndAdultsByAddress(address), HttpStatus.OK);
    }

    @GetMapping(value = "/fire")
    public ResponseEntity<Fire> showPersonsListAndFirestationNumberByAdress(@RequestParam(value="address")String address){
        return new ResponseEntity<>(alertService.getPersonByAddress(address), HttpStatus.OK);
    }

    @GetMapping(value="/flood/stations")
    public ResponseEntity<List<Flood>> showPersonsAndAddressByFireStationNumber(@RequestParam(value="station_numbers") List<Integer> stationsNumberList){
        return new ResponseEntity<>(alertService.getPersonsAndAddressByFirestationNumber(stationsNumberList), HttpStatus.OK);
    }
}
