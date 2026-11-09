package hu.david.rushhour;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VehicleTest {

    @Test
    void vehicleShouldStoreData() {

        Vehicle vehicle =
                new Vehicle(
                        "A",
                        2,
                        3,
                        2,
                        Orientation.HORIZONTAL);

        assertEquals("A", vehicle.getId());
        assertEquals(2, vehicle.getRow());
        assertEquals(3, vehicle.getCol());
        assertEquals(2, vehicle.getLength());
        assertEquals(
                Orientation.HORIZONTAL,
                vehicle.getOrientation());
    }
}