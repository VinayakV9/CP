package codechef.practice.euron;
/* package codechef; // don't place package name! */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.TreeSet;
/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
		String s = br.readLine();
		
		String str[] = br.readLine().split(" ");
		
		long cost = 0;
		int[] arr = new int[str.length];
		int i = 0;
		for(String sNum : str) {
			int num = Integer.valueOf(sNum);
			arr[i++]  = num;
		}
		
		cost = mergeSort(arr);
		System.out.println(cost);
        
	}

	private static long mergeSort(int[] arr) {
		
		if( arr.length == 1 ) {
			return 0;
		}
		
		int mid = arr.length/2;
		
		int[] left = Arrays.copyOfRange(arr, 0, mid);
		int[] right = Arrays.copyOfRange(arr, mid, arr.length);
		
		return mergeSort(left)+mergeSort(right)+merge(arr, left, right);
	}
	
	private static long merge(int[] arr, int[] left, int[] right) {
		int i = 0;
		int j = 0;
		long count = 0;
		while(i < left.length || j < right.length) {
			if( i == left.length ) {
				arr[i+j] = right[j];
				j++;
			} else if ( j == right.length) {
				arr[i+j] = left[i];
				i++;
			} else if ( left[i] <= right[j]) {
				arr[i+j] = left[i];
				i++;
			} else {
				arr[i+j] = right[j];
				count += left.length - i;
				j++;
			}
		}
		
		return count;
	}
}
