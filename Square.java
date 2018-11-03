import objectdraw.*;
import java.util.*;

public class Square {

    private int value;
    private FramedRect box;
    private DrawingCanvas canvas;
    private double size;
    private Location point;

    private ArrayList<Integer> posVals = new ArrayList<Integer>();


    public Square(int value, double x, double y, double s){
        size = s;
        //canvas = c;
        point = new Location(x,y);
        this.value = value;
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

}
