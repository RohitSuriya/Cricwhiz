package assignments.w1d2;

public class PalindromeUsingStringFunctions {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "madam";
		StringBuilder obj = new StringBuilder(str);
		obj.reverse();
		String rev = obj.toString();

		if (str.equalsIgnoreCase(rev)) {
			System.out.println(str + " is a palindrome");
		} else
			System.out.println(str + " is not a palindrome");

	}
}
