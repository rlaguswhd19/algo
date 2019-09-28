package Test;

import java.util.ArrayList;

public class Test_2 {
	static int[][] arr;
	static int[][] set;
	static String[] bishops = { "D5", "E8", "G2" };
	static int cnt = 0;
	public static void main(String[] args) {
		arr = new int[8][8];
		set = new int[bishops.length][2];
		for (int i = 0; i < bishops.length; i++) {
			int x = bishops[i].charAt(0) - 'A';
			int y = bishops[i].charAt(1) - '0';
			arr[x][y - 1] = 1;
			set[i][0] = x;
			set[i][1] = y - 1;
		}
		for (int i = 0; i < bishops.length; i++) {
			dfs(set[i][0], set[i][1]);
//			for (int j = 0; j < 8; j++) {
//				for (int j2 = 0; j2 < 8; j2++) {
//					System.out.print(arr[j][j2] + " ");
//				}
//				System.out.println();
//			}
//			System.out.println();
		}
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if(arr[i][j] == 0) {
					cnt++;
				}
			}
		}
		System.out.println(cnt);
	}

	static void dfs(int x, int y) {
		int r = 7-y;
		int l = y;
		int index = 1;
		for (int i = 0; i < r; i++) {
			if (x + index < arr.length && y + index < arr.length) {
				arr[x + index][y + index] = 1;
			}
			if (x - index >= 0 && y + index < arr.length) {
				arr[x - index][y + index] = 1;
			}
			index++;
		}
		index = 1;
		for (int i = 0; i < l; i++) {
			if (x + index < arr.length && y - index >= 0) {
				arr[x + index][y - index] = 1;
			}
			if (x - index >= 0 && y - index >= 0) {
				arr[x - index][y - index] = 1;
			}
			index++;
		}
	}
}
