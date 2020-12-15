package test.T2020_2.hyundaicard;

import java.util.Arrays;

public class Solution1 {
	static int[][] map;
	
	public static void main(String[] args) {
		int rows = 4;
		int columns = 3;
		int[][] swipes = { { 1, 1, 2, 4, 3 }, { 3, 2, 1, 2, 3 }, { 4, 1, 1, 4, 3 }, { 2, 2, 1, 3, 3 } };
		solution(rows, columns, swipes);
	}

	static int[] solution(int rows, int columns, int[][] swipes) {
		map = new int[rows][columns];
		int[] result = new int[swipes.length];
		int temp = 1;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				map[i][j] = temp++;
			}
		}

		for (int i = 0; i < swipes.length; i++) {
			result[i] = swipe(swipes[i][0], swipes[i][1] - 1, swipes[i][2] - 1, swipes[i][3] - 1, swipes[i][4] - 1);
		}
		
		System.out.println(Arrays.toString(result));
		return result;
	}

	static int swipe(int d, int r1, int c1, int r2, int c2) {
		int ans = 0;
		if (d == 3) {
			int[] input = new int[r2 - r1 + 1];
			int[] temp = new int[r2 - r1 + 1];
			for (int i = r1; i <= r2; i++) {
				input[i - r1] = map[i][c2];
				ans += input[i - r1];
			}

			for (int i = c1; i <= c2; i++) {
				for (int j = r1; j <= r2; j++) {
					temp[j - r1] = map[j][i];
					map[j][i] = input[j - r1];
					input[j - r1] = temp[j - r1];
				}
			}
		} else if (d == 4) {
			int[] input = new int[r2 - r1 + 1];
			int[] temp = new int[r2 - r1 + 1];
			for (int i = r1; i <= r2; i++) {
				input[i - r1] = map[i][c1];
				ans += input[i - r1];
			}

			for (int i = c2; i >= c1; i--) {
				for (int j = r1; j <= r2; j++) {
					temp[j - r1] = map[j][i];
					map[j][i] = input[j - r1];
					input[j - r1] = temp[j - r1];
				}
			}
		} else if (d == 1) {
			int[] input = new int[c2 - c1 + 1];
			int[] temp = new int[c2 - c1 + 1];
			for (int i = c1; i <= c2; i++) {
				input[i - c1] = map[r2][i];
				ans += input[i - c1];
			}

			for (int i = r1; i <= r2; i++) {
				for (int j = c1; j <= c2; j++) {
					temp[j - c1] = map[i][j];
					map[i][j] = input[j - c1];
					input[j - c1] = temp[j - c1];
				}
			}

		} else {
			int[] input = new int[c2 - c1 + 1];
			int[] temp = new int[c2 - c1 + 1];
			for (int i = c1; i <= c2; i++) {
				input[i - c1] = map[r1][i];
				ans += input[i - c1];
			}

			for (int i = r2; i >= r1; i--) {
				for (int j = c1; j <= c2; j++) {
					temp[j - c1] = map[i][j];
					map[i][j] = input[j - c1];
					input[j - c1] = temp[j - c1];
				}
			}
		}
		
		return ans;
	}
}
