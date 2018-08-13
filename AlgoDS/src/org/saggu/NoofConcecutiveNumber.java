/**
 * 
 */
package org.saggu;

/**
 * @author randeepsaggu Find number of occurrences of a consecutive number from
 *         a sorted array
 */
public class NoofConcecutiveNumber {

	public static void main(String args[]) {

		int arr[] = { 1, 2, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 6 };

		int freq = findOccurence(arr, 4);
		System.out.println("Frequency "+freq);
	}

	public static int findOccurence(int arr[], int value) {
		int lIndex = lSolve(arr, value);
		if(lIndex==-1) {
			return -1;
		}
		int rIndex = rSolve(arr, value);
		
		return rIndex-lIndex+1;
		
	}

	private static int lSolve(int arr[], int value) {

		int high = arr.length - 1;
		int low = 0;
		int ret = -1;
		while (high >= low) {
			int mid = (high + low) / 2;

			if (arr[mid] == value) {
				ret = mid;
				high = mid - 1;
			} else if (arr[mid] < value) {
				low = mid + 1;
			} else if (arr[mid] > value) {
				high = mid - 1;
			}

		}

		return ret;
	}
	
	private static int rSolve(int arr[], int value) {

		int high = arr.length - 1;
		int low = 0;
		int ret = -1;
		while (high >= low) {
			int mid = (high + low) / 2;

			if (arr[mid] == value) {
				ret = mid;
				low = mid + 1;
			} else if (arr[mid] < value) {
				low = mid + 1;
			} else if (arr[mid] > value) {
				high = mid - 1;
			}

		}

		return ret;
	}

}
