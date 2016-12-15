package algorithms;

import java.util.HashSet;

/**
 * Implement an algorithm to determine if a string has all unique characters.
 * @author Nick Pierre
 */

public class IsUnique {
	public static void main(String[] args) throws InterruptedException {
		java.util.Scanner input = new java.util.Scanner(System.in);
		
		System.out.print("Enter a string: ");
		String userString = input.nextLine();
		
		System.out.print("Determining if all characters are unique ");
		for (int i = 0; i < 3; i++) {
			Thread.sleep(1000);
			System.out.print(". ");
		}
		
		System.out.println("Duplicate Characters: " + checkForDuplicates(userString));
		
		input.close();
	}
	public static boolean checkForDuplicates(String userString) {
		
		HashSet<Character> characterSet = new HashSet<>();
		
		for (int i = 0; i < userString.length(); i++) {
			char currentCharacter = userString.charAt(i);
			if (characterSet.contains(currentCharacter))
				return true;
			characterSet.add(currentCharacter);
		}
		return false;
		
	}
}
