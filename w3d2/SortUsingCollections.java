package assignments.w3d2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SortUsingCollections {

	public static void main(String[] args) {
		
		String arr[] = {"Google", "Microsoft","TestLeaf","Maverick"};
		List<String> arrList = new ArrayList<String>(Arrays.asList(arr));
		
		int size = arrList.size();
		System.out.println("Size of the list:" + size);
		System.out.println("********************************************");
		System.out.println("List before sorting: " + arrList);
		System.out.println("********************************************");
		Collections.sort(arrList);
		System.out.println("Sorted list:" + arrList);
		System.out.println("********************************************");
		Collections.reverse(arrList);
		System.out.println("Reversed list: " + arrList);
		
		
	}

}
