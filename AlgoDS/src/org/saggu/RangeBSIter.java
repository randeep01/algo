package org.saggu;

public class RangeBSIter {

	public static void main(String[] args) {

		int arr[] = { 1, 2, 3, 4, 4, 4, 4, 5, 5, 5, 5, 6 };
		int val = 2;
		int high = arr.length - 1;
		int low = 0;
		int lIndex = lSearch(arr, val, low, high);
		if(lIndex==-1) {
			System.out.println("-1");
			return;
		}
		int rIndex = rSearch(arr,val,low,high);
		
		System.out.println(rIndex-lIndex+1);

	}

	private static int lSearch(int arr[], int val, int low, int high) {
		int result = -1;
		
		
		while(low<=high) {
			int mid =(low+high)/2;
			
			if(val==arr[mid]) {
				result = mid;
				high =mid-1;
			}
			
			else if(val<arr[mid]){
				high = mid-1;
			}
			
			else 
			{
				low = mid +1;
			}
		}
		return result;
	}
	private static int rSearch(int arr[], int val, int low, int high) {
		int result = -1;
		
		
		while(low<=high) {
			int mid =(low+high)/2;
			
			if(val==arr[mid]) {
				result = mid;
				low =mid+1;
			}
			
			else if(val<arr[mid]){
				high = mid-1;
			}
			
			else 
			{
				low = mid +1;
			}
		}
		return result;
	}

}
