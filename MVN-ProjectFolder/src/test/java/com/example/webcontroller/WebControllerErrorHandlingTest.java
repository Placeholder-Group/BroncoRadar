package com.example.webcontroller;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class WebControllerErrorHandlingTest {

    @Autowired
    private TestRestTemplate restTemplate;

    private Path testFile;

    @BeforeEach
    public void setUp() throws Exception {
        // Create a temporary file to test file operations
        testFile = Files.createTempFile("testFile", ".txt");
        testFile.toFile().deleteOnExit();  // Ensures the file is deleted after the test
    }

    @Test
    public void testFileOperations() throws Exception {
        // Simulate the /fileOperations endpoint
        ResponseEntity<String> response = restTemplate.getForEntity("/fileOperations", String.class);

        // Debugging output
        System.out.println("Response body: " + response.getBody());

        // Assert response is as expected
        assertNotNull(response.getBody());
        assertTrue(response.getBody().contains("File operations completed successfully"));
    }

    @Test
    public void testSolveEquations() throws Exception {
        // Simulate the /solveEquations endpoint
        ResponseEntity<String> response = restTemplate.getForEntity("/solveEquations", String.class);

        // Debugging output
        System.out.println("Response body: " + response.getBody());

        // Assert the solution is returned as expected
        assertNotNull(response.getBody());
        assertTrue(response.getBody().contains("Solution:"));
    }

    @Test
    public void testGuavaExample() throws Exception {
        // Simulate the /guavaExample endpoint
        ResponseEntity<String> response = restTemplate.getForEntity("/guavaExample", String.class);

        // Debugging output
        System.out.println("Response body: " + response.getBody());

        // Assert the guava message is returned as expected
        assertNotNull(response.getBody());
        assertTrue(response.getBody().contains("Guava Output:"));
    }
}
