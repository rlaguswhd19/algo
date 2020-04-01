package SamSungTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main17136 {
	static int[][] map;
	static int ans;
	static int[] list = { 0, 5, 5, 5, 5, 5 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		map = new int[10][10];
		ans = Integer.MAX_VALUE;

		StringTokenizer st;

		for (int i = 0; i < 10; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 10; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dfs(0, 0, 0);
		if(ans == Integer.MAX_VALUE) {
			System.out.println(-1);
		}else {
			System.out.println(ans);
		}
	}

	static void dfs(int x, int y, int cnt) {
		if (x == 10 && y == 0) {
			ans = Math.min(ans, cnt);
			return;
		}

		if (cnt >= ans) {
			return;
		}

		if (map[x][y] == 1) {
			for (int i = 5; i >= 1; i--) {
				if (list[i] > 0) {
					if (check(x, y, i)) {
						fill(x, y, i, 0);
						list[i]--;
						int nx, ny;

						if (y + 1 == 10) {
							ny = 0;
							nx = x + 1;
						} else {
							ny = y + 1;
							nx = x;
						}
						dfs(nx, ny, cnt + 1);

						list[i]++;
						fill(x, y, i, 1);
					}
				}
			}
		} else {
			int nx, ny;

			if (y + 1 == 10) {
				ny = 0;
				nx = x + 1;
			} else {
				ny = y + 1;
				nx = x;
			}
			dfs(nx, ny, cnt);
		}
	}

	static boolean isRange(int x, int y, int num) {
		if (x + num <= 10 && y + num <= 10) {
			return true;
		} else {
			return false;
		}
	}

	static void fill(int x, int y, int num, int state) {
		for (int i = x; i < x + num; i++) {
			for (int j = y; j < y + num; j++) {
				map[i][j] = state;
			}
		}
	}

	static boolean check(int x, int y, int num) {
		if (!isRange(x, y, num)) {
			return false;
		}

		for (int i = x; i < x + num; i++) {
			for (int j = y; j < y + num; j++) {
				if (map[i][j] != 1) {
					return false;
				}
			}
		}

		return true;
	}
}
