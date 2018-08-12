package org.saggu;

public class binarySearchInter {

	public static void main(String[] args) {

		int arr[] = { 1, 2, 3, 4, 5, 6, 6, 7 };

		int toFind = 5;

		int index = bs(arr, toFind);
		System.out.println(index);

	}

	private static int bs(int[] arr, int toFind) {
		int low = 0;
		int high = arr.length - 1;
		while (low <= high) {
			int mid = (high + low) / 2;
			if (arr[mid] > toFind) {
				high = mid - 1;
			} else if (arr[mid] < toFind) {
				low = mid + 1;
			} else if (arr[mid] == toFind) {
				return mid;
			}

		}

		return -1;
	}

}
