package assignments.w3d2;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class RemoveDuplicatesUsingSet {

	public static void main(String[] args) {

		String str = "PayPal India";
		System.out.println(str);
		char[] charArray = str.toCharArray();
		Set<Character> charSet = new LinkedHashSet<Character>();
		//Set<Character> dupCharSet = new LinkedHashSet<Character>();

		for (int i = 0; i < charArray.length; i++) {
			charSet.add(charArray[i]);
		}
		System.out.print("After removing duplicates: ");
		for (Character a : charSet) {
			System.out.print(a);
		}
		/*
		 * for (int i = 0; i < charArray.length; i++) { if
		 * (charSet.contains(charArray[i])) { dupCharSet.add(charArray[i]); } else {
		 * charSet.add(charArray[i]); } } for (Character a : charSet) {
		 * System.out.print(a); } System.out.println('\n'); for (Character b :
		 * dupCharSet) { System.out.print(b); }
		 */
	}

}
