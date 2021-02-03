import java.io.*;
import java.io.FileNotFoundException;
import java.io.Writer;
import java.util.Scanner;
public class Hangman1{
	private int wins, losses;
	private String currentWord;
	private int guesses;
	Scanner response=new Scanner(System.in);
	Hangman1(){
	}
	public void loadWL() {
		try {
			File WL=new File("winloss.txt");
			Scanner Read = new Scanner(WL);
			wins=Read.nextInt();
			losses=Read.nextInt();
			Read.close();
		}
		catch (FileNotFoundException e) {
			System.out.println("error!!");
			e.printStackTrace();
		}
    }   
	public void writeWL() throws IOException{
		try {
			File WL=new File("winloss.txt");
			Writer W =new FileWriter(WL);
			W.write(wins + "\n");
			W.write(losses + "\n");
			W.close();
		}
		catch (FileNotFoundException e) {
			System.out.println("error!!");
			e.printStackTrace();
		}
	}
	public void playGame() {
		guesses=5;
			Dictionary Webster=new Dictionary();
			Webster.readFile("randomwords.txt");
			currentWord = Webster.chooseWord();
		System.out.println("Would you like to play Hangman? Yes or No.");
		String pResponse=response.nextLine();
		char[] baseWord= this.currentWord.toCharArray();
		char[] correctAnswer= this.currentWord.toCharArray();
		char pInput;
		for(int i=0; i < currentWord.length(); i++) {
			baseWord[i]= '_';
		}
		if(pResponse.equals("No")) {
			System.out.println("Thanks for stopping by!");
		}
		if(pResponse.equals("Yes")) {
			System.out.println("You have "+ guesses + " incorrect guesses left.");
			System.out.println(baseWord);
			while(String.valueOf(baseWord).equals(currentWord)==false&&guesses>0) {
				System.out.println("What would you like to guess?");
				pResponse=response.nextLine();
				pInput=pResponse.charAt(0);
				boolean correct=false;
				for(int i=0; i < currentWord.length(); i++) {
					if(correctAnswer[i]==pInput) {
						baseWord[i]=pInput;
						System.out.println(baseWord);
						correct=true;
					}
				}
				if(correct) {
					System.out.println("You have "+ guesses+ " guesses left.");
				}
				else {
					guesses--;
					System.out.println("You have "+ guesses+ " guesses left.");
				}
			}
		}
	}
}
