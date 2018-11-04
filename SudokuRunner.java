import objectdraw.*;

public class SudokuRunner extends WindowController {

    private static Square[][] sqArray = new Square[9][9];


    private static GameBoard sudoku = new GameBoard(sqArray, 50, 50, 180);


    public static void main(String[] args){

 //       sudoku.printValues();
        System.out.println(sudoku);
        sudoku.makePuzzle("easy");
        System.out.println(sudoku);
        sudoku.play();
        
    }

    public void begin() {


        System.out.print("Test");
        new FilledRect(5,5,5,5, canvas);
    }

}