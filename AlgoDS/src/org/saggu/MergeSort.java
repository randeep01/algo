package org.saggu;

/**
 * Merge sort implementation 
 * @author randeepsaggu
 *
 */

public class MergeSort {
	
	static int aux[] = new int[10000];
	public static void sort(int arr[],int low, int high) {
		if(low==high)
			return;
		int mid = (low+high)/2;
		
		sort(arr,low,mid);
		sort(arr, mid+1,high);
		merge(arr,low, mid,high);
	}
	public static void merge(int arr[], int low, int mid, int high) {
		for(int i = low;i<=high;i++) {
			aux[i]= arr[i];
		}
		
		int pi = low;
		int lp = low;
		int rp = mid+1;
		while(lp<=mid && rp<= high) {
			if(aux[lp]<aux[rp]) {
				arr[pi++] = aux[lp++];
			}else {
				arr[pi++]= aux[rp++];
			}
		}
		while(lp<=mid) {
			arr[pi++] = aux[lp++];
		}
		while(rp<=high) {
			arr[pi++] =aux[rp++];
		}
	}
	
	public static void main(String args[]) {
		int arr[] = {32,2,43,4432,1};
		sort(arr,0,arr.length-1);
		for(int i =0;i<arr.length;i++) {
			System.out.println(arr[i]);
		}
	}
}
