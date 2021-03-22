package variants;

import java.util.Scanner;
// @license MIT license
// @author Seth Herendeen
// 2021
public class VariantHelper {
	
	public final static String ALPHABET = 
			"abcdefghijklmnopqrstuvwxyz";
	public static Scanner scanner = new Scanner(System.in);
	
	public static String getInput() {
		String inputText = "";
		
		System.out.print("Enter a phrase or name: ");
		inputText = scanner.nextLine();
		
		//scanner.close();
		
		return inputText;
	}
	
	public static int getNumber(int limit) {
		int result = 1;
		
		do {
			System.out.println("Enter number of letters to change: ");
			while(!scanner.hasNextInt() || result > limit) {
				System.out.println("That is not a number!");
				scanner.next();
			}
			result = scanner.nextInt();
		}
		while(result<1 || result >= limit);
		
		scanner.close();
		
		return result;
	}
	
	public static String changeLetters(String input, int numberOfLetters) {
		
		input = input.trim();
		
		if (numberOfLetters < 1) {
			throw new IllegalArgumentException("Number of letters must"
					+ " be greater than zero.");
		}
		
		if ( input == null || input == "") {
			throw new IllegalArgumentException("Input cannot be null or empty.");
		} 
		
		int[] indicies = new int[numberOfLetters];
		
		for (int i = 0 ; i < indicies.length; i++ ) {
			
			int index = (int)(Math.random() * input.length());
			
			if ( !Character.isWhitespace(input.charAt(index))) {
				indicies[i] = index;
			} else {
				index = (int)(Math.random() * input.length());
			}
		}
		
		for (int i : indicies) {
			
			int index = (int)(Math.random() * ALPHABET.length());
			
			boolean wasUpper = Character.isUpperCase(input.charAt(i));
			
			char randomLetter = (wasUpper) ? Character.toUpperCase( ALPHABET.charAt(index)):  ALPHABET.charAt(index);
			
			input = input.replace(input.charAt(i), randomLetter);
			
		}
		
		return input;
	}
	
	public static void main(String[] args) {
		
		String[] strings = new String[ALPHABET.length()];
		
		var str = getInput();
		int n = getNumber(str.length());
		
		for (int i = 0 ; i < strings.length; i++) {
			strings[i] = changeLetters(str, n);
		}
		
		for(String s : strings) {
			System.out.println(s);
		}
		
	}
}
