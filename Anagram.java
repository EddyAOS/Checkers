package Anagram;

import java.util.Scanner;

public class Anagram {
	private String word, sWord, guess;
	private WordStreamIterator iter = new WordStreamIterator("words10000.txt");
	private Scanner scan = new Scanner(System.in);
	
	public Anagram() {
		word = (String) iter.get((int)(Math.random()*10000));
		scramble();
	}
	
	public Anagram(int size) {
		int num = (int)(Math.random()*10000);
		String a = (String)iter.get(num);
			while(a.length()!= size) {
				num = (int)(Math.random()*20);
				a = (String)iter.get(num);
			}
		word = a;
		scramble();
	}
	
	public void scramble() {
		for(int x = 0; x < 10; x++) {
			int randIndex = (int)(this.word.length()*Math.random());
			sWord = word.substring(randIndex)+word.substring(0, randIndex);
		}
		if(sWord.equals(word))scramble();
	}
	
	public boolean eval() {
		guess = scan.nextLine().toLowerCase();
		if(word.equals(guess))return true;
		return false;
	}
	
	
	public String toString() {
		return word +", "+this.sWord;
	}
	
	
}
