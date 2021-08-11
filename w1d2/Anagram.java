package assignments.w1d2;

import java.util.Arrays;

public class Anagram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String str = "restful";
		String str1 = "fluster";

		if (str.length() == str1.length()) {
			char[] charArray = str.toLowerCase().toCharArray();
			char[] charArray1 = str1.toLowerCase().toCharArray();
			Arrays.sort(charArray);
			Arrays.sort(charArray1);
			boolean equals = Arrays.equals(charArray, charArray1);
			if (equals) {
				System.out.println(str + " and " + str1 + " are Anagrams");
			} else
				System.out.println(str + " and " + str1 + " are not Anagrams");
		} else
			System.out.println("The length of the words are not same, hence they can't be anagrams");
	}

}
