package hu.david.rushhour;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class JsonSaverTest {

    @Test
    void saveShouldNotThrowException() {

        GameState state = new GameState();
        state.setRows(6);
        state.setCols(12);
        state.setVehicles(new ArrayList<>());

        JsonSaver saver = new JsonSaver();

        assertDoesNotThrow(() ->
                saver.save(state));
    }
}