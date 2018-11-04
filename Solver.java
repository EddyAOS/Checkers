import objectdraw.*;

import java.util.*;

public class Solver {

    private GameBoard board;
    private int[][] values;
    private boolean repeat,found;



    public Solver(GameBoard gBoard) {
        board = gBoard;
        values = board.getValues();


    }

    public GameBoard Solve() {
        while (found) {
            found = false;
            for (int v = 1; v <= 9; v++) {
                uniqueSolve(v);
            }
            for (int r = 0; r < 9; r++) {
                for (int c = 0; c < 9; c++) {
                    soleSolve(r, c);
                }
            }
        }
        return board;

    }

    //soleSolve checks the possible values of a given square by eliminating all values that are already present in the square's row, column, and box
    public void soleSolve(int row, int col) {
        ArrayList<Integer> posValues = board.getSquare(row, col).getPossibleValues();

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
                int rSet = row / 3;
                int cSet = col / 3;
                for (int r = rSet * 3; r < rSet * 3 + 3; r++) {
                    for (int c = cSet * 3; c < cSet * 3 + 3; c++) {
                        if (values[r][c] == posValues.get(v)) {
                            posValues.remove(v);
                        }

                    }
                }
            }


        }
        if (posValues.size() == 1) {
            values[row][col] = posValues.get(0);
            board.getSquare(row, col).setValue(posValues.get(0));
            found = true;
            System.out.println("found value");
        } else board.getSquare(row, col).setPossibleValues(posValues);


    }

    //Solves based on eliminating possible locations for a certain value in each row, column, and box
    public void uniqueSolve(int value) {
        repeat = false;
        //all possible squares on the Sudoku grid
        ArrayList<Square> posSquares = new ArrayList<Square>();

        //all squares which currently carry the given value
        ArrayList<Square> valSquares = valSquares(value);

        //sets posSquares to all squares on the board
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                if (board.getSquare(r, c).getValue() == 0)
                    posSquares.add(board.getSquare(r, c));
            }
        }

        for (Square k : valSquares) {
            for (int j = posSquares.size() - 1; j >= 0; j--) {
                Square s = posSquares.get(j);
                if (s.getRow() == k.getRow())
                    posSquares.remove(j);

                else if (s.getCol() == k.getCol())
                    posSquares.remove(j);

                else if (s.getBox() == k.getCol()) {
                    posSquares.remove(j);
                }

            }
            for (int j = posSquares.size() - 1; j >= 0; j--) {
                boolean rowSame = false;
                boolean colSame = false;
                boolean boxSame = false;
                for (int l = valSquares.size()-1; l >= 0; l--) {


                    if (posSquares.get(j).getRow() == valSquares.get(l).getRow())
                        rowSame = true;
                    if (posSquares.get(j).getCol() == valSquares.get(l).getCol())
                        colSame = true;
                    if (posSquares.get(j).getBox() == valSquares.get(l).getBox())
                        boxSame = true;
                }
                if (!(rowSame) || !(colSame) || !(boxSame)) {
                    System.out.println("found value");
                    repeat = true;
                    found = true;
                    board.getSquare(posSquares.get(j).getRow(), posSquares.get(j).getCol()).setValue(k.getValue());
                }

            }
        }
        if (repeat) {
            uniqueSolve(value);
        }


    }



    public void gridInteraction() {
        for (int b = 1; b <= 9; b++) {

        }
    }


    //Creates an array list of all squares in the Sudoku board with the given value
    public ArrayList<Square> valSquares(int value) {
        ArrayList<Square> squares = new ArrayList<Square>();
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                if (board.getSquare(r, c).getValue() == value) squares.add(board.getSquare(r, c));
            }
        }
        return squares;
    }

}
