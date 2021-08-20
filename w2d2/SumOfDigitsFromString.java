package assignments.w2d2;

public class SumOfDigitsFromString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String text = "Tes12Le79af65";
		int sum = 0;
		String newText = text.replaceAll("\\D", "");
		System.out.println("Text after replacing letters: " + newText);

		char[] charArray = newText.toCharArray();
		for (int i = 0; i < charArray.length; i++) {
			int digit = Character.getNumericValue(charArray[i]);
			sum += digit;
		}
		System.out.println("The sum of digits is: " + sum);

	}

}
