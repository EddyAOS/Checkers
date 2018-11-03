import objectdraw.*;

import java.util.*;

public class Solver {

    private GameBoard board;
    private int[][] values;

    public Solver(GameBoard gBoard) {
        board = gBoard;


    }

    public void Solve() {
        values = board.getValues();
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {

            }
        }

    }

    public void soleSolve(int row, int col) {
        ArrayList<Integer> posValues = board.getSquare(row,col).getPossibleValues();
        for (int v = 0; v < 9; v++) {
            posValues.add(v + 1);
        }
        for (int v = 8; v >= 0; v--) {
            boolean removed = false;
            for (int c = 0; c < 9; c++) {
                if (posValues.get(v) == values[row][c]) {
                    posValues.remove(v);
                    removed = true;
                }
            }
            if (!(removed))
                for (int r = 0; r < 9; r++) {
                    if (posValues.get(v) == values[r][col]) {
                        posValues.remove(v);
                        removed = true;
                    }
                }
            if (!(removed)) {
                int rSet = row/3;
                int cSet = col/3;
                for (int r = rSet * 3; r < rSet * 3 + 3; r++) {
                    for (int c = cSet * 3; c < cSet * 3 + 3; c++) {
                        if (values[r][c] == posValues.get(v)) {
                            posValues.remove(v);
                        }

                    }
                }
            }


        }
        if (posValues.size() == 1){
            values[row][col] = posValues.get(0);
        }
        else board.getSquare(row,col).setPossibleValues(posValues);


    }

    public void uniqueSolve(int value){
        
    }

}
