package hu.david.rushhour;

import java.util.List;

public class Board {

    private int rows;
    private int cols;
    private char[][] board;

    public Board(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.board = new char[rows][cols];

        initializeBoard();
    }

    private void initializeBoard() {

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                board[r][c] = '.';
            }
        }
    }

    public void placeVehicles(List<Vehicle> vehicles) {

        for (Vehicle vehicle : vehicles) {

            char symbol = vehicle.getId().charAt(0);

            if (vehicle.getOrientation() == Orientation.HORIZONTAL) {

                for (int i = 0; i < vehicle.getLength(); i++) {
                    board[vehicle.getRow()][vehicle.getCol() + i] = symbol;
                }

            } else {

                for (int i = 0; i < vehicle.getLength(); i++) {
                    board[vehicle.getRow() + i][vehicle.getCol()] = symbol;
                }
            }
        }
    }

    public void printBoard() {

        for (int r = 0; r < rows; r++) {

            for (int c = 0; c < cols; c++) {
                System.out.print(board[r][c] + " ");
            }

            System.out.println();
        }
    }

    public void clearBoard() {

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                board[r][c] = '.';
            }
        }
    }
}