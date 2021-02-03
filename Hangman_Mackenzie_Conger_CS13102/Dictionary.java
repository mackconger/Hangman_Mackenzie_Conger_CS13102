import java.io.*;
import java.util.Random;
import java.util.Scanner;
public class Dictionary {
	private String[] wordList = new String[200];
	private int randomNum;
	public void readFile(String fileName) {
		try {
			File Words = new File(fileName);
			Scanner Read = new Scanner(Words);
			for(int i=0; i<200; i++) {
				wordList[i]=Read.nextLine();
			}
			Read.close();
		}
		catch(FileNotFoundException e) {
			System.out.println("error!!");
			e.printStackTrace();
		}
	}
	public String chooseWord() {
		Random randomNumbers = new Random();
		randomNum=randomNumbers.nextInt(200);
		return wordList[randomNum];
	}
}
