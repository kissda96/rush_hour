package hu.david.rushhour;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DatabaseManagerTest {

    @Test
    void addWinShouldWork() {

        DatabaseManager manager =
                new DatabaseManager();

        assertDoesNotThrow(
                () -> manager.addWin("TESZT")
        );
    }

    @Test
    void showScoreboardShouldWork() {

        DatabaseManager manager =
                new DatabaseManager();

        assertDoesNotThrow(
                manager::showScoreboard
        );
    }

    @Test
    void constructorShouldWork() {

        assertDoesNotThrow(
                DatabaseManager::new
        );
    }
}