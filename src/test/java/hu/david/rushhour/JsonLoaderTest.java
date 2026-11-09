package hu.david.rushhour;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JsonLoaderTest {

    @Test
    void loadShouldNotThrowException() {

        JsonLoader loader = new JsonLoader();

        assertDoesNotThrow(loader::load);
    }
}