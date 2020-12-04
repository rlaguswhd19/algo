package baekjoon.SamSungTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main17779 {
	static int[][] map;
	static int n, x, y, ans;
	static boolean[][] visit;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		map = new int[n + 1][n + 1];
		ans = Integer.MAX_VALUE;

		StringTokenizer st;

		for (int i = 1; i < n + 1; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j < n + 1; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < n + 1; j++) {
				x = i;
				y = j;
				d1d2();
			}
		}

		System.out.println(ans);
	}

	static void d1d2() {
		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < n + 1; j++) {

				if (!isRange(i, j)) {
					continue;
				}
				five(i, j);
			}
		}
	}

	static void five(int d1, int d2) {
		int min = Integer.MAX_VALUE;
		int max = 0;

		int sum = 0;
		visit = new boolean[n + 1][n + 1];

		int ys = y;
		int ye = y;

		for (int i = 0; i < d1 + d2 + 1; i++) { // x
			if (i > d1) {
				ys += 1;
			} else {
				ys = y - i;
			}

			if (i > d2) {
				ye -= 1;
			} else {
				ye = y + i;
			}
			for (int j = ys; j <= ye; j++) { // y
				visit[x + i][j] = true;
				sum += map[x + i][j];
			}
		}
		
		min = Math.min(sum, min);
		max = Math.max(sum, max);
		// 1
		sum = 0;
		for (int i = 1; i < x + d1; i++) {
			for (int j = 1; j <= y; j++) {
				if (visit[i][j]) {
					continue;
				}
				sum += map[i][j];
			}
		}

		min = Math.min(sum, min);
		max = Math.max(sum, max);

		// 2
		sum = 0;
		for (int i = 1; i <= x + d2; i++) {
			for (int j = y + 1; j <= n; j++) {
				if (visit[i][j]) {
					continue;
				}
				sum += map[i][j];
			}
		}

		min = Math.min(sum, min);
		max = Math.max(sum, max);

		// 3
		sum = 0;
		for (int i = x + d1; i <= n; i++) {
			for (int j = 1; j < y - d1 + d2; j++) {
				if (visit[i][j]) {
					continue;
				}
				sum += map[i][j];
			}
		}

		min = Math.min(sum, min);
		max = Math.max(sum, max);

		// 4
		sum = 0;
		for (int i = x + d2 + 1; i <= n; i++) {
			for (int j = y - d1 + d2; j <= n; j++) {
				if (visit[i][j]) {
					continue;
				}
				sum += map[i][j];
			}
		}

		min = Math.min(sum, min);
		max = Math.max(sum, max);

		if (ans > max - min) {
			ans = max - min;
		}
	}

	static boolean isRange(int d1, int d2) {
		if (x + d1 + d2 <= n && 1 <= y - d1 && y + d2 <= n) {
			return true;
		} else {
			return false;
		}
	}
}
