package assignments.w1d2;

public class FindTypes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String test = "$$ Welcome to 2nd Class of Automation $$ ";
		int  letter = 0, space = 0, num = 0, specialChar = 0;
		
		char[] charArray = test.toCharArray();
		
		for (int i = 0; i < charArray.length; i++) {
			if (Character.isLetter(charArray[i])) {
				letter++;
			}else if (Character.isSpaceChar(charArray[i])) {
				space++;
			}else if (Character.isDigit(charArray[i])) {
				num++;
			}else 
				specialChar++;
			}
		System.out.println("Count of letters: " + letter);
		System.out.println("Count of spaces: " + space);
		System.out.println("Count of digits/numbers: " + num);
		System.out.println("Count of special characters: " + specialChar);
			
		}
				
	}

