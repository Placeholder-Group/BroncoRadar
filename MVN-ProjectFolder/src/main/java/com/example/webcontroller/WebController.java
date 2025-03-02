package com.example.webcontroller;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import org.apache.commons.math3.linear.DecompositionSolver;
import org.apache.commons.math3.linear.LUDecomposition;
import org.apache.commons.math3.linear.MatrixUtils;
import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.linear.RealVector;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import com.google.common.base.Strings;

import org.geotools.geometry.jts.JTSFactoryFinder;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.Point;

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

    // Endpoint to trigger solving of system of linear equations
    @GetMapping("/solveEquations")
    public String solveEquations() {
        // Define the system of equations:
        // 2x + 3y -  z = 1
        // 4x +  y + 2z = 2
        // -x + 5y + 3z = 3
        double[][] coefficients = {
            {2, 3, -1},
            {4, 1, 2},
            {-1, 5, 3}
        };

        // Define the constants vector
        double[] constants = {1, 2, 3};

        try{
        // Create a RealMatrix and RealVector for the system
        RealMatrix matrix = MatrixUtils.createRealMatrix(coefficients);
        RealVector vector = MatrixUtils.createRealVector(constants);

        // Solve the system using LU Decomposition
        DecompositionSolver solver = new LUDecomposition(matrix).getSolver();
        RealVector solution = solver.solve(vector);

        // Print and return the solution
        System.out.println("Solution: " + solution);
        return "Solution: " + solution;
        } catch (Exception e){
            e.printStackTrace();
            return("An error occured during the linear equation system solving.");
        }
    }
    
   // HTTP endpoint to calculate the distance between Cal Poly Pomona and Pomona
    @GetMapping("/calculate-distance")
    public String calculateDistance() {
        try {
            // Coordinates for Cal Poly Pomona and Pomona (hardcoded)
            double lat1 = 34.0656; // Cal Poly Pomona
            double lon1 = -117.7116; // Cal Poly Pomona
            double lat2 = 34.0550; // Pomona
            double lon2 = -117.7500; // Pomona

            // Create GeometryFactory for working with geometries
            GeometryFactory geometryFactory = JTSFactoryFinder.getGeometryFactory(null);

            // Create points for both coordinates (lat, lon)
            Point point1 = geometryFactory.createPoint(new Coordinate(lon1, lat1));
            Point point2 = geometryFactory.createPoint(new Coordinate(lon2, lat2));

            // Calculate the distance (in meters) between the two points
            double distance = point1.distance(point2);

            return "The distance between Cal Poly Pomona and Pomona is: " + distance + " meters.";
        } catch (Exception e) {
            e.printStackTrace();
            return "Error calculating distance.";
        }
    }

    //Example using Guava as a library dependency from Maven
    @GetMapping("/guavaExample")
    public String guavaExample() {
        String guavaMessage = Strings.padStart("Hello, Guava!", 30, '=');

        // Print and return the Guava-powered message
        System.out.println("Guava Output: " + guavaMessage);
        return "Guava Output: " + guavaMessage;
    }

     // Nested controller for the /map endpoint
    @Controller
    static class MapController {
        @GetMapping("/map")
        public String getMapPage() {
            // Redirect to "map.html" placed in src/main/resources/static/
            return "redirect:/map.html";
        }
    }
}
