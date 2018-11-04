package HangMan;

public class HangManClient {
	
	public static void main(String[] args) {
		HangMan game = new HangMan(5);
		System.out.println(game);
		game.play();
	}

}
