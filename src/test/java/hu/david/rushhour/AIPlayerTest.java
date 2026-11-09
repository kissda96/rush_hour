package hu.david.rushhour;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AIPlayerTest {

    @Test
    void aiShouldMakeMove() {

        List<Vehicle> vehicles = new ArrayList<>();

        vehicles.add(
                new Vehicle(
                        "A",
                        2,
                        2,
                        2,
                        Orientation.HORIZONTAL)
        );

        GameState gameState = new GameState();
        gameState.setRows(6);
        gameState.setCols(12);
        gameState.setVehicles(vehicles);

        AIPlayer aiPlayer = new AIPlayer();

        assertDoesNotThrow(() ->
                aiPlayer.makeMove(vehicles, gameState));
    }
}