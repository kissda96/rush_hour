package hu.david.rushhour;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.InputStream;
import java.util.Scanner;

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

            Scanner scanner = new Scanner(System.in);
            AIPlayer aiPlayer = new AIPlayer();

            while (true) {

                System.out.println();
                System.out.print("Parancs: ");

                String command = scanner.nextLine();

                if (command.equalsIgnoreCase("exit")) {
                    break;
                }

                String[] parts = command.split(" ");

                if (parts.length == 3 &&
                        parts[0].equalsIgnoreCase("move")) {

                    String vehicleId = parts[1];
                    int distance = Integer.parseInt(parts[2]);

                    for (Vehicle vehicle : gameState.getVehicles()) {

                        if (vehicle.getId().equalsIgnoreCase(vehicleId)) {

                            if (vehicle.getOrientation() == Orientation.HORIZONTAL) {

                                int newCol = vehicle.getCol() + distance;

                                if (newCol >= 0 &&
                                        newCol + vehicle.getLength() <= gameState.getCols()) {

                                    boolean collision = false;

                                    for (Vehicle other : gameState.getVehicles()) {

                                        if (other == vehicle) {
                                            continue;
                                        }

                                        if (other.getOrientation() == Orientation.HORIZONTAL) {

                                            for (int i = 0; i < vehicle.getLength(); i++) {

                                                int targetCol = newCol + i;

                                                if (vehicle.getRow() == other.getRow()) {

                                                    for (int j = 0; j < other.getLength(); j++) {

                                                        if (targetCol == other.getCol() + j) {
                                                            collision = true;
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }

                                    if (!collision) {
                                        vehicle.setCol(newCol);
                                    } else {
                                        System.out.println("Masik jarmube utkozne!");
                                    }

                                } else {
                                    System.out.println("Ervenytelen lepes!");
                                }

                            } else {

                                int newRow = vehicle.getRow() + distance;

                                if (newRow >= 0 &&
                                        newRow + vehicle.getLength() <= gameState.getRows()) {

                                    vehicle.setRow(newRow);

                                } else {
                                    System.out.println("Ervenytelen lepes!");
                                }
                            }

                            break;
                        }
                    }

                    board.clearBoard();
                    board.placeVehicles(gameState.getVehicles());

                    System.out.println();
                    board.printBoard();
                    aiPlayer.makeMove(
                            gameState.getVehicles(),
                            gameState);

                    board.clearBoard();
                    board.placeVehicles(gameState.getVehicles());

                    System.out.println();
                    board.printBoard();
                    for (Vehicle vehicle : gameState.getVehicles()) {

                        if (vehicle.getId().equals("A")) {

                            if (vehicle.getCol() + vehicle.getLength()
                                    == gameState.getCols()) {

                                System.out.println();
                                System.out.println("A jatekos nyert!");
                                return;
                            }
                        }
                    }
                }
            }

        } catch (Exception e) {
            System.out.println("Hiba a pálya betöltésekor!");
            e.printStackTrace();
        }
    }
}