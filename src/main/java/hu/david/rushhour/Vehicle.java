package hu.david.rushhour;

public class Vehicle {

    private String id;
    private int row;
    private int col;
    private int length;
    private Orientation orientation;

    public Vehicle() {
    }

    public Vehicle(String id, int row, int col,
                   int length, Orientation orientation) {
        this.id = id;
        this.row = row;
        this.col = col;
        this.length = length;
        this.orientation = orientation;
    }

    public String getId() {
        return id;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public int getLength() {
        return length;
    }

    public Orientation getOrientation() {
        return orientation;
    }
}