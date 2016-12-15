package algorithms;

/**
 * Given two strings, write a method to decide if one is a permutation of another
 * @author Nick Pierre
 *
 */

import java.util.*;

public class CheckPermutations {
	public static void main(String[] args) throws InterruptedException {
		java.util.Scanner input = new java.util.Scanner(System.in);
		
		System.out.print("First String: ");
		String firstString = input.next();
		System.out.print("Second String: ");
		String secondString = input.next();
		
		System.out.print("Determining if permutation of another ");
		for (int i = 0; i < 3; i++) {
			Thread.sleep(1000);
			System.out.print(". ");
		}
		
		System.out.println("Is permutation of Another: " + checkPermutation(firstString, secondString));
		
		input.close();
	}
	
	public static boolean checkPermutation(String s1, String s2) {
		Hashtable<Integer, Character> characterSet = new Hashtable<>();
		HashSet<Character> secondarySet = new HashSet<>();
		
		
		if (s1.length() != s2.length()) return false;
		
		for(int i = 0; i <s1.length(); i++) {
			characterSet.put(i, s1.charAt(i));
		}
		
		for (int i = 0; i < s2.length(); i++) {
			secondarySet.add(s2.charAt(i));
		}
		
		for (int i = 0; i < characterSet.size(); i++) {
			if (!secondarySet.contains(characterSet.get(i))) {
				return false;
			}
		}
		
		return true;
	}
}
