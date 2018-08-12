package org.saggu;

public class PermutationWithReps {

	//static char[] range = { 'a', 'b', 'c' };
	
	static int limit = 3;

	public static void main(String[] args) {

		int index = 0;
		char[] result = new char[limit];
		solve(result, index);
	}

	static void solve(char[] result, int index) {
		if (index == limit) {
			System.out.println(new String(result));
			return;
		}
		for (int i = 0; i < 26; i++) {
			result[index] = (char)('a'+i);
			solve(result, index+1);
		}
	}
}
