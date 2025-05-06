package com.example.webcontroller;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, properties = {
    "server.ssl.enabled=false"
})
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
        String expectedSolution = "Solution: {0.1818181818; 0.3636363636; 0.4545454545}";

        // Check if the response contains the expected solution
        assertTrue(responseBody.contains(expectedSolution), "Response should contain the correct solution");
    }

    @Test
    public void testFileOperations() {
        ResponseEntity<String> response = restTemplate.getForEntity("/fileOperations", String.class);
        String responseBody = response.getBody();

        // Check response is not null and status is OK
        assertNotNull(responseBody, "Response body should not be null");
        assertEquals(HttpStatus.OK, response.getStatusCode(), "HTTP status should be OK");

        // Verify the response contains expected operation results
        assertTrue(responseBody.contains("File operations completed successfully"), 
            "Response should indicate successful file operations");
        assertTrue(responseBody.contains("Hello, Apache Commons IO"), 
            "Response should contain the written content");
    }

    @Test
    public void testGuavaExample() {
        ResponseEntity<String> response = restTemplate.getForEntity("/guavaExample", String.class);
        String responseBody = response.getBody();

        // Check response is not null and status is OK
        assertNotNull(responseBody, "Response body should not be null");
        assertEquals(HttpStatus.OK, response.getStatusCode(), "HTTP status should be OK");

        // Verify the response contains Guava-padded string
        assertTrue(responseBody.contains("Guava Output:"), "Response should contain Guava output");
        assertTrue(responseBody.contains("===============Hello, Guava!"), 
            "Response should contain padded string");
    }

    @Test
    public void testMapEndpoint() {
        ResponseEntity<String> response = restTemplate.getForEntity("/map", String.class);
        
        // Check that the response is OK and contains map content
        assertEquals(HttpStatus.OK, response.getStatusCode(), "Response should be OK");
        String responseBody = response.getBody();
        assertNotNull(responseBody, "Response body should not be null");
        assertTrue(responseBody.contains("<div id=\"map\">"), "Should contain map div");
    }

    @Test
    public void testMapHtmlExists() {
        ResponseEntity<String> response = restTemplate.getForEntity("/map.html", String.class);
        
        // Check that the map.html file is accessible
        assertEquals(HttpStatus.OK, response.getStatusCode(), 
            "map.html should be accessible");
        
        // Verify the response contains essential map elements
        String responseBody = response.getBody();
        assertNotNull(responseBody, "Response body should not be null");
        assertTrue(responseBody.contains("<div id=\"map\">"), "Should contain map div");
        assertTrue(responseBody.contains("leaflet"), "Should contain Leaflet script");
    }
}
