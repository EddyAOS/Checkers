import objectdraw.*;

public class SudokuRunner extends WindowController {

    private static Square[][] sqArray = new Square[9][9];


    private static Board sudoku = new Board(sqArray, 50, 50, 180);


    public static void main(String[] args){


        sudoku.assignValues();
        sudoku.printValues();

    }

    public void begin() {


        System.out.print("Test");
        new FilledRect(5,5,5,5, canvas);
    }

}
