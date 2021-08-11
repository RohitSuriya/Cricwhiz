package assignments.w1d2;

public class CharOccurrence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "He is defenceless";
		int count = 0;
		char[] charArray = s1.toCharArray();
		int length = charArray.length;
		
		for (int i = 0; i < length; i++) {
			if (charArray[i] == 'e') {
				count++;
			}
		}
		System.out.println("There are " + count + " instances of the letter 'e' in the given string" );
	}

}
