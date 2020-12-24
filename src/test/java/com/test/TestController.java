package com.test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.model.MeasurementsModel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
public class TestController {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetUserHistrory() throws Exception {
        String testUserName = "testUser1";
        this.mockMvc.perform(
                MockMvcRequestBuilders.get(
                        String.format("/measurements/history/%s", testUserName)
                )
        )
                .andExpect(MockMvcResultMatchers.status().isOk());

    }

    @Test
    public void testSubmitInformation() throws Exception {
        MeasurementsModel measurementsModel = new MeasurementsModel();

        measurementsModel.setUserName("testUser1");
        measurementsModel.setGas(0);
        measurementsModel.setColdWater(200);
        measurementsModel.setHotWater(300);

        String requestString = new ObjectMapper().writeValueAsString(measurementsModel);

        this.mockMvc.perform(
                MockMvcRequestBuilders.post("/measurements/submit")
                .content(requestString)
                .contentType(MediaType.APPLICATION_JSON)
        )
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

}
