package com.example.webcontroller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(WebController.class)
public class WebControllerErrorHandlingTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testFileOperations() throws Exception {
        MvcResult result = mockMvc.perform(get("/fileOperations"))
            .andExpect(status().isOk())
            .andReturn();
        System.out.println("File Operations Response: " + result.getResponse().getContentAsString());
    }

    @Test
    public void testSolveEquations() throws Exception {
        MvcResult result = mockMvc.perform(get("/solveEquations"))
            .andExpect(status().isOk())
            .andReturn();
        System.out.println("Solve Equations Response: " + result.getResponse().getContentAsString());
    }

    @Test
    public void testGuavaExample() throws Exception {
        MvcResult result = mockMvc.perform(get("/guavaExample"))
            .andExpect(status().isOk())
            .andReturn();
        System.out.println("Guava Example Response: " + result.getResponse().getContentAsString());
    }
}
