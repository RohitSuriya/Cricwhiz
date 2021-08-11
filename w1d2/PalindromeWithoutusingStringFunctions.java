package assignments.w1d2;

public class PalindromeWithoutusingStringFunctions {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "madam";
		
		if (palindrome(str) == "true") {
			System.out.println(str + " is a palindrome.");
		}else
			System.out.println(str + " is not a palindrome.");
		
				
	}

	public static String palindrome(String str) {
		int i = str.length() - 1, j=0;
		String var = null;
		while (i > 0) {
			char a = str.charAt(i);
			
			if (a == str.charAt(j)) {
				 var =  "true";
				j++;
				i--;
			}else {
				 var = "false";
				break;
			}
		}
		return var;

	}
}
