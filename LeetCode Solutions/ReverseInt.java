/**
 *  Difficulty: Easy
 * Reverse digits of an integer.
 * 
 * Example1: x = 123, return 321
 * Example2: x = -123, return -321
 * 
 * @author Nick Pierre
 *
 */
public class ReverseInt {
    public static void main(String[] args) {
    	
    }
    
    public static int reverse(int x) {
	    try {
	      String num = String.valueOf((int)Math.sqrt(Math.pow(x, 2)));
	      String reversed = "";
	      for (int i = num.length() - 1; i >= 0; --i) {
	        if (num.charAt(i) != '0' || reversed.length() > 0)
	          reversed += num.charAt(i);
	      }
	      if (x < 0) 
	        return Integer.valueOf(reversed) * -1;
	
	      return Integer.valueOf(reversed);
	    } catch (NumberFormatException ex) {
	    	return 0;
	    }
    }
}
