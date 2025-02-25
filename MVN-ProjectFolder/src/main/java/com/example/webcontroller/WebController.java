package com.example.webcontroller;

import org.apache.commons.io.FileUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@RestController
public class WebController {

    // Endpoint to trigger file operations
    @GetMapping("/fileOperations")
    public String performFileOperations() {
        File file = new File("example.txt");

        try {
            // 1. Write a string to the file using Commons IO
            String content = "Hello, Apache Commons IO!";
            FileUtils.writeStringToFile(file, content, StandardCharsets.UTF_8);
            System.out.println("File written successfully!");

            // 2. Read the content of the file using Commons IO
            String fileContent = FileUtils.readFileToString(file, StandardCharsets.UTF_8);
            System.out.println("File content: " + fileContent);

            // 3. Delete the file using Commons IO
            FileUtils.forceDelete(file);
            System.out.println("File deleted successfully!");

            return "File operations completed successfully: " + fileContent;

        } catch (IOException e) {
            e.printStackTrace();
            return "An error occurred during file operations.";
        }
    }
}
