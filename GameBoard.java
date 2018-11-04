public class GameBoard extends Board {

    private int numsLeft;

    public GameBoard(Square[][] g, double x, double y, double size) {
        super(g, x, y, size);
        numsLeft = 0;
    }

    public void makePuzzle(String s) {
        int subtractNums = 0;
        switch (s) {
            case "beginner":
                subtractNums = (int) (51 + Math.random() * 9);
                break;
            case "easy":
                subtractNums = (int) (41 + Math.random() * 9);
                break;
            case "medium":
                subtractNums = (int) (31 + Math.random() * 9);
                break;
            case "hard":
                subtractNums = (int) (25 + Math.random() * 9);
                break;
            default:
                return;
        }
        while (subtractNums > 0) {
            int randX = (int) (Math.random() * 9);
            int randY = (int) (Math.random() * 9);
            super.grid[randX][randY].setValue(0);
            ;
            subtractNums--;
            numsLeft++;
        }
    }

    public int getNumsLeft() {
        return numsLeft;
    }

}

