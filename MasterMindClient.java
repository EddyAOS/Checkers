
public class MasterMindClient {


    public static void main(String[]args) {
        int num = 5;
        Mastermind game = new Mastermind(num);
        System.out.println("take a guess there are "+num+" numbers");
      //  game.play();
        MastermindSolver solver = new MastermindSolver(game);
        solver.solution();

    }
}