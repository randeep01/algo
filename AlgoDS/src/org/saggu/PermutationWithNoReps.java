package org.saggu;

public class PermutationWithNoReps {
	static int range[] = { 1, 2, 3, 4, 5 };
	static boolean[] visited = new boolean[range.length];
	static int limit = 3;

	public static void main(String[] args) {

		int index = 0;
		int[] value = new int[limit];
		solve(value, index);

	}

	public static void solve(int[] value, int index) {
		if (index == limit) {
			for (int i = 0; i < limit; i++) {
				System.out.print(value[i]);
			}
			System.out.println("");
			return;
		}

		for (int i = 0; i < range.length; i++) {
			if (visited[i] == false) {
				value[index] = range[i];
				visited[i] = true;
				solve(value, index + 1);
				visited[i] = false;
			}
		}

	}
}
