package algorithms;

/**
 * Write a method to replace all spaces in a string with '%20'.
 * You may assume that the string has sufficient space at the end to hold
 * the additional characters, and that you are given the "true"
 * length of the string. (Note: If implementing in java, please use a character
 * array so that you can perform this operation.)
 * 
 * O(n) Solution
 * @author Nick Pierre
 *
 */
public class URLify {
	public static void main(String[] args) throws InterruptedException {
		java.util.Scanner input = new java.util.Scanner(System.in);
		
		System.out.print("The String below will have its spaces replaced with '%20' "
				+ "\n*Note the true length is the length excluding the buffer spacing at the end of the string");
		String randomString = "my mom likes to eat        ";
		System.out.println(randomString);
		System.out.print("\n\nWhat is the \" True Length \" of the string? (Hint Enter 19)");
		int trueLength = input.nextInt();
		char[] charArray = randomString.toCharArray();
		
		System.out.print("URLify-ing");
		for (int i = 0; i < 3; i++) {
			Thread.sleep(1000);
			System.out.print(". ");
		}
		
		System.out.println("\nProcess Completed: ");
		charArray = magicStuff(charArray, trueLength);

		for (char x : charArray) {
			System.out.print(x);
		}
		input.close();
	}
	
	public static char[] magicStuff(char[] characterArray, int size) {
		if (characterArray[characterArray.length - 1] != ' ') return characterArray;
		
		int spaceCount = 0;
		int actualSize = size - 1;
		
		for (int index = actualSize; index >= 0; index--) {
			if (characterArray[index] == ' ') spaceCount++;
		}
		
		int amountToShift = spaceCount * 2; // we need for extra spacing to add '2' and '0'
		
		for (int index = actualSize; index >= 0; index--) {
			characterArray[index + amountToShift] = characterArray[index];
			if (characterArray[index] == ' ') amountToShift -= 2;
			if (amountToShift == 0) break;
			characterArray[index] = ' ';
		}
		
		for (int index = 0; index < characterArray.length; index++) {
			if (characterArray[index] == ' ') {
				characterArray[index] = '%';
				characterArray[index + 1] = '2';
				characterArray[index + 2] = '0';
				index += 3;
			}
		}
		
		return characterArray;
	}
}
