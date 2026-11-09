package hu.david.rushhour;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DatabaseManagerTest {

    @Test
    void addWinShouldNotThrowException() {

        DatabaseManager manager =
                new DatabaseManager();

        assertDoesNotThrow(() ->
                manager.addWin("TESZT"));
    }

    @Test
    void showScoreboardShouldNotThrowException() {

        DatabaseManager manager =
                new DatabaseManager();

        assertDoesNotThrow(
                manager::showScoreboard);
    }
}