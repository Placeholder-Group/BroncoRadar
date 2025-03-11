package com.example.webcontroller;

import static org.junit.Assert.*;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class WebControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testSolveEquations() {
        ResponseEntity<String> response = restTemplate.getForEntity("/solveEquations", String.class);
        String responseBody = response.getBody();

        // Check that the response is not null and status is OK
        assertNotNull(responseBody);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        
        // Expected solution for the given system of equations
        String expectedSolution = "Solution: {1.0; -1.0; 2.0}";

        // Check if the response contains the expected solution
        assertTrue("Response should contain the correct solution", responseBody.contains(expectedSolution));
    }

    @Test
    public void testFileOperations() {
        ResponseEntity<String> response = restTemplate.getForEntity("/fileOperations", String.class);
        String responseBody = response.getBody();

        // Check response is not null and status is OK
        assertNotNull("Response body should not be null", responseBody);
        assertEquals("HTTP status should be OK", HttpStatus.OK, response.getStatusCode());

        // Verify the response contains expected operation results
        assertTrue("Response should indicate successful file operations", 
            responseBody.contains("File operations completed successfully"));
        assertTrue("Response should contain the written content", 
            responseBody.contains("Hello, Apache Commons IO"));
    }

    @Test
    public void testGuavaExample() {
        ResponseEntity<String> response = restTemplate.getForEntity("/guavaExample", String.class);
        String responseBody = response.getBody();

        // Check response is not null and status is OK
        assertNotNull("Response body should not be null", responseBody);
        assertEquals("HTTP status should be OK", HttpStatus.OK, response.getStatusCode());

        // Verify the response contains Guava-padded string
        assertTrue("Response should contain Guava output", responseBody.contains("Guava Output:"));
        assertTrue("Response should contain padded string", 
            responseBody.contains("===============Hello, Guava!"));
    }

    @Test
    public void testMapEndpoint() {
        ResponseEntity<String> response = restTemplate.getForEntity("/map", String.class);
        
        // Check status code is 3xx (redirect)
        assertTrue("Response should be a redirect", 
            response.getStatusCode().is3xxRedirection());
        
        // Check that it redirects to map.html
        String location = response.getHeaders().getLocation().getPath();
        assertEquals("Should redirect to map.html", "/map.html", location);
    }

    @Test
    public void testMapHtmlExists() {
        ResponseEntity<String> response = restTemplate.getForEntity("/map.html", String.class);
        
        // Check that the map.html file is accessible
        assertEquals("map.html should be accessible", 
            HttpStatus.OK, response.getStatusCode());
        
        // Verify the response contains essential map elements
        String responseBody = response.getBody();
        assertNotNull("Response body should not be null", responseBody);
        assertTrue("Should contain map div", responseBody.contains("<div id=\"map\">"));
        assertTrue("Should contain Leaflet script", 
            responseBody.contains("leaflet"));
    }
}
