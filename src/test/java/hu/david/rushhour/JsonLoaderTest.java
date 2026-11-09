package hu.david.rushhour;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JsonLoaderTest {

    @Test
    void loadShouldReturnGameStateOrNull() {

        JsonLoader loader = new JsonLoader();

        GameState state = loader.load();

        assertTrue(
                state == null || state.getRows() > 0
        );
    }
}