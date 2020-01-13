package DFS;

import java.util.Scanner;

public class Main1389 {
	static int n, m;
	static int[][] arr;
	static int[] countarr;
	static int count;
	static int sum;
	static int result;
	static boolean[] visit;
	static int people;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		result = Integer.MAX_VALUE;
		arr = new int[n + 1][n + 1];
		for (int i = 0; i < m; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			arr[x][y] = 1;
			arr[y][x] = 1;
		}

		for (int i = 1; i < n + 1; i++) {
			countarr = new int[n+1];
			for (int j = 1; j < countarr.length; j++) {
				countarr[j] = Integer.MAX_VALUE;
			}
			visit = new boolean[n+1];
			dfs(i, 0);
			sum = 0;
			sum();
			if(result > sum) {
				result = sum;
				people = i;
			}
		}
		System.out.println(people);

	}

	static void dfs(int me, int c) {
		visit[me] = true;
		if(countarr[me] > c) {
			countarr[me] = c;
		}
		for (int i = 1; i < n + 1; i++) {
			if (i == me) {
				continue;
			}
			if (arr[me][i] == 1 && !visit[i]) {
				dfs(i, c+1);
			}
		}
		visit[me] = false;
	}

	static void sum() {
		for (int i = 1; i < countarr.length; i++) {
			if(countarr[i] != Integer.MAX_VALUE)
			sum += countarr[i];
		}
	}
}
