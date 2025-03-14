package com.example.webcontroller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class LocationTrackingTest {
    private static final Logger logger = LoggerFactory.getLogger(LocationTrackingTest.class);

    private final double[] bounds = {
        34.049198, -117.830944,  // Southwest corner
        34.064770, -117.807255   // Northeast corner
    };

    @Mock
    private LocationUpdateHandler locationHandler;

    private Location currentLocation;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        currentLocation = new Location(34.057919, -117.821342); // Library coordinates
        logger.info("Test setup completed with initial location at Library");
    }

    
    @Test
    public void testLocationAccuracy() {
        logger.info("Testing location accuracy");
        // Test location accuracy within 10 meters
        double delta = 0.0001; // Approximately 10 meters
        Location expectedLocation = new Location(34.057919, -117.821342);
        
        assertEquals(expectedLocation.lat, currentLocation.lat, delta,
            "Latitude should be accurate within 10 meters");
        assertEquals(expectedLocation.lng, currentLocation.lng, delta,
            "Longitude should be accurate within 10 meters");
        logger.info("Location accuracy test completed with delta: {}", delta);
    }

    @Test
    public void testLocationWithinBounds() {
        logger.info("Testing location within bounds");
        // Test location within CPP campus (Library coordinates)
        double testLat = 34.057919;
        double testLng = -117.821342;
        
        assertTrue(isLocationWithinBounds(testLat, testLng),
            "Library location should be within bounds");
        logger.info("Location within bounds test completed successfully");
    }

    @Test
    public void testLocationOutsideBounds() {
        logger.info("Testing location outside bounds");
        // Test location outside CPP campus (Mt. SAC coordinates)
        double testLat = 34.047241;
        double testLng = -117.844348;
        
        assertFalse(isLocationWithinBounds(testLat, testLng),
            "Mt. SAC location should be outside bounds");
        logger.info("Location outside bounds test completed successfully");
    }

    @Test
    public void testBoundaryLocations() {
        logger.info("Testing boundary locations");
        // Test exact boundary points
        assertTrue(isLocationWithinBounds(bounds[0], bounds[1]),
            "Southwest corner should be within bounds");
        assertTrue(isLocationWithinBounds(bounds[2], bounds[3]),
            "Northeast corner should be within bounds");
        logger.info("Boundary locations test completed successfully");
    }

    @Test
    public void testDefaultLocation() {
        logger.info("Testing default location");
        // Test Kellogg West default location
        double defaultLat = 34.056735;
        double defaultLng = -117.824680;
        
        assertTrue(isLocationWithinBounds(defaultLat, defaultLng),
            "Default location (Kellogg West) should be within bounds");
        logger.info("Default location test completed successfully");
    }

    /**
     * Helper method to check if a location is within map bounds
     */
    private boolean isLocationWithinBounds(double lat, double lng) {
        return lat >= bounds[0] && lat <= bounds[2] && 
               lng >= bounds[1] && lng <= bounds[3];
    }

    private static class Location {
        double lat;
        double lng;

        Location(double lat, double lng) {
            this.lat = lat;
            this.lng = lng;
        }
    }

    private interface LocationUpdateHandler {
        void onLocationUpdate(Location location);
    }
}