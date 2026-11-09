package hu.david.rushhour;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    @Test
    void boardShouldBeCreated() {

        Board board = new Board(6, 12);

        assertNotNull(board);
    }
}