package com.example.spring_demo.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class HeadphoneControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetAllHeadphones() throws Exception {
        mockMvc.perform(get("/headphones")).andExpect(status().isOk());
    }
}
