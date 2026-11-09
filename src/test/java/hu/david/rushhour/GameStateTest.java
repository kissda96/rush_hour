package hu.david.rushhour;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class GameStateTest {

    @Test
    void gameStateShouldStoreValues() {

        GameState state = new GameState();

        state.setRows(6);
        state.setCols(12);
        state.setVehicles(new ArrayList<>());

        assertEquals(6, state.getRows());
        assertEquals(12, state.getCols());
        assertNotNull(state.getVehicles());
    }
}