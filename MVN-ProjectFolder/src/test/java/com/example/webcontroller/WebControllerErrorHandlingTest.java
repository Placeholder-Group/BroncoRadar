package com.example.webcontroller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.web.client.RestTemplate;

@SpringBootTest
@Import(TestConfig.class)
public class WebControllerErrorHandlingTest {

    @Autowired
    private RestTemplate restTemplate;

    @Test
    public void testFileOperations() {
        String response = restTemplate.getForObject("https://localhost:8443/fileOperations", String.class);
        System.out.println("File Operations Response: " + response);
    }

    @Test
    public void testSolveEquations() {
        String response = restTemplate.getForObject("https://localhost:8443/solveEquations", String.class);
        System.out.println("Solve Equations Response: " + response);
    }

    @Test
    public void testGuavaExample() {
        String response = restTemplate.getForObject("https://localhost:8443/guavaExample", String.class);
        System.out.println("Guava Example Response: " + response);
    }
}
