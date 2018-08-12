package org.saggu;

public class CombinationWithoutRep {
	static int[] range = {1,2,3,4};
	static int limit  = 2;
	
	public static void main(String args[]) {
		int index = 0;
		int start = 0;
		int [] result = new int[limit];
		solve(result,index,start);
		
		
	}
	public static void solve(int[] result, int index, int start) {
		if(index==limit) {
			for(int i = 0;i<limit;i++) {
				System.out.print(result[i]);
			}
			System.out.println("");
			return;
		}
		for(int i = start;i<range.length;i++) {
			result[index] = range[i];
			solve(result,index+1,i+1);
		}
		
		
	}

}
