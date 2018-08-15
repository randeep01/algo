package org.saggu;

/**
 * Recursive Binary Search implementtion
 * 
 * @author randeepsaggu
 * 
 */
public class RecursiveBS {
	public static void main(String args[]) {

		int arr[] = { 1, 2, 3, 4, 4, 4, 4, 5, 5, 5, 5, 6 };
		int val = 4;
		int high = arr.length - 1;
		int low = 0;
		int index = rbs(arr, val, high, low);
		System.out.println(index);
	}

	private static int rbs(int[] arr, int value, int high, int low) {

		if (high >= low) {
			int mid = (low + high) / 2;
			if (arr[mid] == value) {
				return mid;
			} else if (arr[mid] < value) {
				return rbs(arr, value, high, mid + 1);
			} else if (arr[mid] > value) {
				return rbs(arr, value, mid - 1, low);
			}
		}
		return -1;
	}
}
