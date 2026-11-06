package hu.david.rushhour;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.InputStream;

public class Game {

    public void start() {

        try {

            ObjectMapper mapper = new ObjectMapper();

            InputStream inputStream =
                    getClass().getClassLoader().getResourceAsStream("board.json");

            GameState gameState =
                    mapper.readValue(inputStream, GameState.class);

            System.out.println("Sorok: " + gameState.getRows());
            System.out.println("Oszlopok: " + gameState.getCols());

            for (Vehicle vehicle : gameState.getVehicles()) {
                System.out.println(
                        vehicle.getId() +
                                " (" +
                                vehicle.getRow() +
                                "," +
                                vehicle.getCol() +
                                ")"
                );
            }
            Board board =
                    new Board(
                            gameState.getRows(),
                            gameState.getCols());

            board.placeVehicles(gameState.getVehicles());

            System.out.println();
            board.printBoard();

        } catch (Exception e) {
            System.out.println("Hiba a pálya betöltésekor!");
            e.printStackTrace();
        }
    }
}