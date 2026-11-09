package hu.david.rushhour;

import java.util.List;
import java.util.Random;

public class AIPlayer {

    private final Random random = new Random();

    public void makeMove(List<Vehicle> vehicles,
                         GameState gameState) {

        Vehicle vehicle =
                vehicles.get(random.nextInt(vehicles.size()));

        int distance;

        if (random.nextBoolean()) {
            distance = 1;
        } else {
            distance = -1;
        }

        if (vehicle.getOrientation() == Orientation.HORIZONTAL) {

            int newCol = vehicle.getCol() + distance;

            if (newCol >= 0 &&
                    newCol + vehicle.getLength()
                            <= gameState.getCols()) {

                vehicle.setCol(newCol);
            }

        } else {

            int newRow = vehicle.getRow() + distance;

            if (newRow >= 0 &&
                    newRow + vehicle.getLength()
                            <= gameState.getRows()) {

                vehicle.setRow(newRow);
            }
        }

        System.out.println(
                "AI lepett: "
                        + vehicle.getId()
                        + " "
                        + distance);
    }
}