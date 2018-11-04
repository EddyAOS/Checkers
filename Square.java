import objectdraw.*;
import java.util.*;

public class Square {

    private int value;
    private int row;
    private int col;


    private FramedRect box;
    private DrawingCanvas canvas;
    private double size;
    private Location point;

    private ArrayList<Integer> posVals = new ArrayList<Integer>();



    public Square(int v, int c, int r, double x, double y, double s){
        value = v;
        row = r;
        col = c;

        size = s;
        //canvas = c;
        point = new Location(x,y);



        //box = new FramedRect(point, size, size, canvas);
    }

    public Square(int value, Location point, double s) {

        size = s;
        //canvas = c;
        this.point = new Location(point.getX(), point.getY());
        this.value = value;
        // box = new FramedRect(point, size, size, canvas);
    }

    public void setValue(int v){
        value = v;
        posVals.clear();
    }

    public int getValue(){
        return value;
    }


    public ArrayList<Integer> getPossibleValues(){
        return posVals;
    }

    public void setPossibleValues(ArrayList<Integer> posValues){
        this.posVals = posValues;
    }


    public String toString(){
        return Integer.toString(this.value);
    }

    public int getRow(){
        return row;
    }

    public int getCol(){
        return col;
    }

    public int getBox(){
        int rSet = row/3;
        int cSet = col/3;
        if (rSet == 0){
            if (cSet == 0) return 1;
            if (cSet == 1) return 2;
            return 3;
        }
        if (rSet == 1){
            if (cSet == 0) return 4;
            if (cSet == 1) return 5;
            return 6;
        }
        else {
            if (cSet == 0) return 7;
            if (cSet == 1) return 8;
            return 9;
        }
    }


    public boolean compareTo(Square sq) {
        return (this.row == sq.getRow() && this.col == sq.getCol());
    }
}
