import objectdraw.*;
import java.util.*;

public class Board {

    protected Square[][] grid;
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
        assignValues();
    }

    public void assignValues() {

        for (int row = 0; row < grid.length; row++) {

            for (int col = 0; col < grid[0].length; col++) {

                vals.clear();

                for (int v = 1; v <= 9; v++) {


                    if (!(boxContains(v, row, col )|| colContains(v, col) || rowContains(v, row) )) vals.add(v);
                }
                if (vals.size() == 0){
                    clearRow(row, col);
                    col = -1;
                }
                /*if (vals.size() == 0){
                    if (col > 1) col = col-2;
                    else {
                        row--;
                        col = 7;
                    }
                }*/
                else {
                    int random = (int) (Math.random() * vals.size());
                    System.out.println("random = " + random + " row = " + row + " col = " + col + " size = " + vals.size());

                    grid[row][col].setValue(vals.get(random));
                }
            }

        }
    }

  /*  public void printValues(){
        for (int row = 0; row < grid.length; row++){
            for (int col = 0; col < grid[0].length; col++){
                System.out.print(grid[row][col].getValue() + "  ");
            }
            System.out.println();
        }
    }
    */

    public boolean colContains(int v, int col){
        for (int r = 0; r < 9; r++){
            if (grid[r][col].getValue() == v){
                return true;
            }
        }
        return false;
    }

    public boolean rowContains(int v, int row){
        for (int c = 0; c < 9; c++){
            if (grid[row][c].getValue() == v){
                return true;
            }
        }
        return false;
    }

    public void clearRow(int r, int c){
        for (int col = 0; col < c; col++){
            grid[r][col].setValue(0);
        }
    }

    public boolean boxContains(int v, int r, int c){
        int rSet = r/3;
        int cSet = c/3;
        for (int row = rSet*3; row < rSet*3 + 3; row++){
            for (int col = cSet*3; col < cSet*3 + 3; col++){
                if (grid[row][col].getValue() == v){
                    return true;
                }

            }
        }
        return false;
    }

    public String toString() {
        String result = "";
        for (Square[] sq: grid) {
            result+="|";
            for(Square a: sq) {
                result+= a.toString()+", ";
            }
            result+="|\n";
        }
        return result;
    }

    public int[][] getValues(){
        int[][] values = new int[9][9];
        for (int j = 0; j < 9; j++){
            for (int k = 0; k <9; k++){
                values[j][k] = grid[j][k].getValue();

            }
        }
        return values;
    }

    public Square getSquare(int row, int col){
        return grid[row][col];
    }



}
