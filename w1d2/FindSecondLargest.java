package assignments.w1d2;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;

public class FindSecondLargest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] data = { 3, 2, 11, 4, 6, 7 };
		Arrays.sort(data);
		System.out.println("Sorted array:");
		for (int i = 0; i < data.length; i++){
			System.out.println("data[" + i + "]= " + data[i]);
		}
		int result = data.length;
		System.out.println("Second largest element in the array: " + data[result - 2]);
	}

}
