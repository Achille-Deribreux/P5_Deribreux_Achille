package com.Safetynet.Controller;

import com.Safetynet.Service.AlertService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = AlertsController.class)
public class AlertsControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AlertService alertService;

    @Test
    public void getEmailListByCityTest() throws Exception {
        String city = "Culver";
        mockMvc.perform(get("/communityEmail").param("city", city)).andExpect(status().isOk());
    }

    @Test
    public void showPhoneByFirestationNumberTest() throws Exception {
        Integer firestation = 3;
        mockMvc.perform(get("/phoneAlert").param("firestation", String.valueOf(firestation))).andExpect(status().isOk());
    }

    @Test
    public void showPersonInfoByNameAndLastNameTest() throws Exception {
        String firstName = "John";
        String lastName = "Boyd";
        mockMvc.perform(get("/personInfo").param("firstName", firstName)
                .param("lastName", lastName)).andExpect(status().isOk());
    }

    @Test
    public void showPersonsListByFirestationTest() throws Exception {
        Integer stationNumber = 1;
        mockMvc.perform(get("/firestation").param("stationNumber", String.valueOf(stationNumber))).andExpect(status().isOk());
    }

    @Test
    public void showChildrensAndAdultsByAdressTest() throws Exception {
        String address = "29 15th St";
        mockMvc.perform(get("/childAlert").param("address", address)).andExpect(status().isOk());
    }

    @Test
    public void showPersonsListAndFirestationNumberByAdressTest() throws Exception {
        String address = "1509 Culver St";
        mockMvc.perform(get("/fire").param("address", address)).andExpect(status().isOk());
    }

    @Test
    public void showPersonsAndAddressByFireStationNumberTest() throws Exception {
        String stationsNumberList = "1";
        mockMvc.perform(get("/flood/stations").param("station_numbers", stationsNumberList)).andExpect(status().isOk());
    }


}
