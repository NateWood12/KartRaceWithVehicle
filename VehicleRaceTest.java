import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class VehicleRaceTest {
    private Vehicle car1;
    private Vehicle car2;

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        // Initialize vehicles with specific speeds for testing
        car1 = new Vehicle("Toyota", 100);
        car2 = new Vehicle("Ford", 105);
        System.setOut(new PrintStream(outputStreamCaptor));
    }
    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }

    @Test
    void testGetBrand() {
        assertEquals("Toyota", car1.getBrand());
        assertEquals("Ford", car2.getBrand());
    }

    @Test
    void testGetSpeed() {
        assertEquals(100, car1.getSpeed());
        assertEquals(105, car2.getSpeed());
    }

    @Test
    void testGetDistanceTraveled() {
        assertEquals(0, car1.getDistanceTraveled());
        assertEquals(0, car2.getDistanceTraveled());
    }

    @Test
    void testUpdateDistance() {
        car1.updateDistance(50);
        car2.updateDistance(60);

        assertEquals(50, car1.getDistanceTraveled());
        assertEquals(60, car2.getDistanceTraveled());

        car1.updateDistance(20);
        car2.updateDistance(30);

        assertEquals(70, car1.getDistanceTraveled());
        assertEquals(90, car2.getDistanceTraveled());
    }

    @Test
    void testRaceCars() {
        // Simulate a race step with specific speeds
        VehicleRace.raceCars(car1, car2);

        assertTrue(car1.getDistanceTraveled() >= 0);
        assertTrue(car2.getDistanceTraveled() >= 0);
    }

    @Test
    void testRaceUntilFinish() {
        // Simulate a race step with specific speeds
        VehicleRace.raceUntilFinish(car1, car2);

        assertTrue(car1.getDistanceTraveled() >= 500 || car2.getDistanceTraveled() >= 500);
    }

    @Test
    void testDetermineWinner(){

        /*car1 = new Vehicle("Toyota", 100);
        car2 = new Vehicle("Ford", 105);
        */
        car1.updateDistance(500);
        car2.updateDistance(499);
        VehicleRace.determineWinner(car1, car2);
        assertTrue(outputStreamCaptor.toString().contains("Toyota won the race!"));
        outputStreamCaptor.reset();
        car1.updateDistance(20);
        car2.updateDistance(30);
        VehicleRace.determineWinner(car1, car2);
        assertTrue(outputStreamCaptor.toString().contains("Ford won the race!"));
        outputStreamCaptor.reset();
        car1.updateDistance(9);
        VehicleRace.determineWinner(car1, car2);
        assertTrue(outputStreamCaptor.toString().contains("It's a tie!"));

    }
}
