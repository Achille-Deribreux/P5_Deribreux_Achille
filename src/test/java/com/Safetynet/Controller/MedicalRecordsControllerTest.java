package com.Safetynet.Controller;

import com.Safetynet.Model.MedicalRecords;
import com.Safetynet.Model.Person;
import com.Safetynet.Service.MedicalRecordService;
import com.Safetynet.Service.PersonService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = MedicalRecordsController.class)
public class MedicalRecordsControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MedicalRecordService medicalRecordService;

    MedicalRecords medicalRecords = new MedicalRecords("John", "Boyd", "03/06/1984", List.of("aznol:350mg", "hydrapermazol:100mg"), List.of("nillacilan"));

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void addMedicalRecordTest() throws Exception {
        mockMvc.perform(post("/medicalRecord").contentType(MediaType.APPLICATION_JSON).content(asJsonString(medicalRecords))).andExpect(status().isCreated());
    }

    @Test
    public void editMedicalRecordTest() throws Exception {
        mockMvc.perform(put("/medicalRecord").contentType(MediaType.APPLICATION_JSON).content(asJsonString(medicalRecords))).andExpect(status().isOk());
    }

    @Test
    public void deleteMedicalRecordTest() throws Exception {
        mockMvc.perform(delete("/medicalRecord").contentType(MediaType.APPLICATION_JSON).content(asJsonString(medicalRecords))).andExpect(status().isOk());
    }
}
