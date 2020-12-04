package baekjoon.DFS;

import java.util.Scanner;

public class Main1405 {
	static double[] arr;
	static double ans = 0;
	static int n;
	static int[] dx = { 1, -1, 0, 0 }; // 동 서 남 북
	static int[] dy = { 0, 0, 1, -1 };
	static boolean[][] visit;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		arr = new double[4];
		visit = new boolean[30][30];

		for (int i = 0; i < 4; i++) {
			arr[i] = sc.nextInt() / 100.0;
		}
		dfs(15, 15, 1, 0);
		
		System.out.println(ans);
	}

	static void dfs(int x, int y, double sum, int count) {
		visit[x][y] = true;

		if (count == n) {
			ans += sum;
			visit[x][y] = false;
			return;
		}

		for (int i = 0; i < 4; i++) {
			if (!visit[x + dx[i]][y + dy[i]]) {
				dfs(x + dx[i], y + dy[i], sum * arr[i], count + 1);
			}
		}
		visit[x][y] = false;
	}
}
