package baekjoon.DFS;
import java.util.Scanner;

public class Main2468 {
	static int[][] arr;
	static int[][] copy;
	static int min, max;
	static int result;
	static int n;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int count;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		arr = new int[n][n];
		min = Integer.MAX_VALUE;
		max = 0;
		result = 1;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				arr[i][j] = sc.nextInt();
				min = Math.min(arr[i][j], min);
				max = Math.max(arr[i][j], max);
			}
		}
		for (int i = min; i < max; i++) {
			copy();
			rain(i);
			count = 0;
			for (int a = 0; a < n; a++) {
				for (int b = 0; b < n; b++) {
					if (copy[a][b] != 0) {
						dfs(a, b);
						count++;
					}
				}
			}
			result = Math.max(count, result);
		}
		System.out.println(result);
//		for (int i = 0; i < n; i++) {
//			for (int j = 0; j < n; j++) {
//				System.out.print(copy[i][j]+" ");
//			}System.out.println();
//		}
	}

	static int[][] copy() {
		copy = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				copy[i][j] = arr[i][j];
			}
		}
		return copy;
	}

	static void rain(int high) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (copy[i][j] <= high) {
					copy[i][j] = 0;
				}
			}
		}
	}

	static void dfs(int a, int b) {
		copy[a][b] = 0;
		for (int i = 0; i < 4; i++) {
			if(a+dx[i]>=0 && b+dy[i]>=0 && a+dx[i] < n && b+dy[i] < n) {
				if(copy[a+dx[i]][b+dy[i]] != 0) {
					dfs(a+dx[i], b+dy[i]);
				}
			}
		}
	}
}
