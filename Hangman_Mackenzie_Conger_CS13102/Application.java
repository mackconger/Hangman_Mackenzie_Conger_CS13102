import java.io.*;
public class Application {
	public static void main(String[] args) throws IOException{
		Hangman1 Game = new Hangman1();
		Game.loadWL();
		Game.playGame();
		Game.writeWL();
	}
}
