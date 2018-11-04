import objectdraw.*;
import java.awt.*;

public class SudokuRunner extends WindowController {

    private static Square[][] sqArray = new Square[9][9];

    private boolean firstSelected;
    private int value, row, col;


    private static GameBoard sudoku;




    public void begin() {
        firstSelected = false;
        value = 0;
        row = 0;
        col = 0;


        sudoku = new GameBoard(sqArray, 50, 50, 450, canvas);

        System.out.println(sudoku);
        sudoku.makePuzzle("hard");


        System.out.println(sudoku);

        Solver solution = new Solver(sudoku);

        solution.Solve();
        System.out.println(sudoku);
        System.out.print("Test");
    }

    public void onMouseClick(Location point){
        if (!(firstSelected)) {
        boolean notFound = true;
        for (int r = 0; r < 9 && notFound; r++) {
            for (int c = 0; c < 9 && notFound; c++) {
                if (sudoku.getSquare(r, c).contains(point)) {
                    sudoku.getSquare(r, c).setColor(Color.BLUE);
                    notFound = false;
                    row = r;
                    col = c;
                }

            }
        }
        }
        else {
            boolean noFound = true;
            for (int v = 0; v < 9 && noFound; v++) {
                if (sudoku.getSolvent(v).contains(point)) {
                    value = v;
                    noFound = false;
                    sudoku.getSolvent(v).setColor(Color.BLUE);

                }
            }
            if ((firstSelected) && !(noFound) && sudoku.getSolution(row, col) == value) {
                sudoku.setText(row, col, value);


            }
        }



    }

}