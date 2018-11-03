import objectdraw.*;
import java.util.*;

public class Board {

    private Square[][] grid;
    private DrawingCanvas canvas;
    private Location point;
    private ArrayList<Integer> vals = new ArrayList<Integer>();

    public Board(Square[][] g, double x, double y, double size) {

        grid = g;
        int value = 0;

        for (int j = 0; j < grid.length; j++) {
            for (int k = 0; k < grid[0].length; k++) {
                grid[j][k] = new Square(value, x + (size / 9 * k), y + (size / 9 * j), size / 9);
            }
        }
    }

    public void assignValues() {

        for (int row = 0; row < grid.length; row++) {

            for (int col = 0; col < grid[0].length; col++) {

                for (int k = vals.size()-1; k >= 0; k--){
                    vals.remove(k);
                }

                for (int v = 1; v <= 9; v++) {


                    if (!(boxContains(v, row, col )|| rowContains(v, row) || colContains(v, col))) vals.add(v);
                }
                int random = (int) (Math.random() * vals.size());
                System.out.println("random = "+random+" row = "+row+" col = "+col + " size = " + vals.size());

                grid[row][col].setValue(vals.get(random));
                vals.remove(random);
            }

        }
    }

    public void printValues(){
        for (int row = 0; row < grid.length; row++){
            for (int col = 0; col < grid[0].length; col++){
                System.out.print(grid[row][col].getValue() + "  ");
            }
            System.out.println();
        }
    }

    public boolean colContains(int v, int col){
        int count = 0;
        for (int r = 0; r < 9; r++){
            if (grid[r][col].getValue() == v){
                System.out.print(count);
                System.out.println();
                return true;
            }
        }
        System.out.print(count);
        return false;
    }

    public boolean rowContains(int v, int row){
        int count = 0;
        for (int c = 0; c < 9; c++){
            if (grid[row][c].getValue() == v){
                System.out.print(count);
                System.out.println();
                return true;
            }
            count++;
        }
        System.out.print(count);
        return false;
    }

    public boolean boxContains(int v, int r, int c){
        int count = 0;
        int rSet = r/3;
        int cSet = c/3;
        for (int row = rSet*3; row < rSet*3 + 3; row++){
            for (int col = cSet*3; col < cSet*3 + 3; col++){
                if (grid[row][col].getValue() == v){
                    System.out.print(count);
                    System.out.println();

                    return true;
                }
                count++;

            }
        }
        System.out.print(count);
        return false;
    }
}
