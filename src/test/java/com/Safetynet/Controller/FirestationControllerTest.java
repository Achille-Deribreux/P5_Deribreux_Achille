package com.Safetynet.Controller;

import com.Safetynet.Model.Firestations;
import com.Safetynet.Model.Specific.Fire;
import com.Safetynet.Service.FirestationService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = FirestationController.class)
public class FirestationControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private FirestationService firestationService;

    Firestations firestations = new Firestations("29 15th St", 2);
    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void addFirestationTest() throws Exception {
        mockMvc.perform(post("/firestation").contentType(MediaType.APPLICATION_JSON).content(asJsonString(firestations))).andExpect(status().isCreated());
    }

    @Test
    public void editFirestationTest() throws Exception {
        mockMvc.perform(put("/firestation").contentType(MediaType.APPLICATION_JSON).content(asJsonString(firestations))).andExpect(status().isOk());
    }

    @Test
    public void deleteFirestationTest() throws Exception {
        mockMvc.perform(delete("/firestation").contentType(MediaType.APPLICATION_JSON).content(asJsonString(firestations))).andExpect(status().isOk());
    }
}
