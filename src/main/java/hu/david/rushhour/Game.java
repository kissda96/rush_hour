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

                                    vehicle.setCol(newCol);

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
                }
            }

        } catch (Exception e) {
            System.out.println("Hiba a pálya betöltésekor!");
            e.printStackTrace();
        }
    }
}