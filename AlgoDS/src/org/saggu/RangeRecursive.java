package org.saggu;
/**
 * Program to find range using divide and conquer using recursion
 * @author randeepsaggu
 *
 */
public class RangeRecursive {

	public static void main(String[] args) {

		int arr[] = { 1, 2, 3, 4, 4, 4, 4, 5, 5, 5, 5, 6 };
		int val = 2;
		int high = arr.length - 1;
		int low = 0;
		int lIndex = lSearch(arr, val, high, low);
		if(lIndex==-1) {
			System.out.println("-1");
			return;
		}
		int rIndex = rSearch(arr,val,high,low);
		
		System.out.println(rIndex-lIndex+1);

	}

	
	private static int lSearch(int[] arr, int value, int high, int low) {
		int ret = -1;
		if (high >= low) {
			int mid = (low + high) / 2;
			if (arr[mid] == value) {
				ret = mid;
				return lSearch(arr,value,mid-1,low);
			} else if (arr[mid] < value) {
				return lSearch(arr, value, high, mid + 1);
			} else if (arr[mid] > value) {
				return lSearch(arr, value, mid - 1, low);
			}
		}
		return ret;
	}
	
	
	private static int rSearch(int[] arr, int value, int high, int low) {
		int ret = -1;
		if (high >= low) {
			int mid = (low + high) / 2;
			if (arr[mid] == value) {
				ret = mid;
				return rSearch(arr,value,high,mid+1);
			} else if (arr[mid] < value) {
				return rSearch(arr, value, high, mid + 1);
			} else if (arr[mid] > value) {
				return rSearch(arr, value, mid - 1, low);
			}
		}
		return ret;
	}

}


