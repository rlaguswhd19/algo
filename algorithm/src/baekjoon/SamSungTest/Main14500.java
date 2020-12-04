package baekjoon.SamSungTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main14500 {
	static int n, m, ans;
	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		ans = 0;
		map = new int[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				tec(i, j);
			}
		}

		System.out.println(ans);
	}

	static void tec(int x, int y) {
		stick(x, y);
		square(x, y);
		L(x, y);
		z(x, y);
		last(x, y);
	}

	static void stick(int x, int y) {
		int[] dir = { 0, 1, 2, 3 };

		for (int i = 0; i < 2; i++) {
			int nx;
			int ny;
			int sum = 0;

			for (int j = 0; j < 4; j++) {
				if (i == 0) {
					nx = x + dir[j];
					ny = y;
				} else {
					nx = x;
					ny = y + dir[j];
				}

				if (!isRange(nx, ny)) {
					sum = 0;
					break;
				}

				sum += map[nx][ny];
			}

			ans = Math.max(ans, sum);
		}
	}

	static void square(int x, int y) {
		int[] dx = { 0, 1, 0, 1 };
		int[] dy = { 0, 0, 1, 1 };
		int nx;
		int ny;
		int sum = 0;

		for (int i = 0; i < 4; i++) {
			nx = x + dx[i];
			ny = y + dy[i];

			if (!isRange(nx, ny)) {
				sum = 0;
				break;
			}

			sum += map[nx][ny];
		}

		ans = Math.max(sum, ans);
	}

	static void L(int x, int y) {
		int[] dx = { 0, 1, 2, 2 };
		int[] dy = { 0, 0, 0, 1 };
		int[] rx = { 1, 1, -1, -1, 1, 1, -1, -1 };
		int[] ry = { 1, -1, 1, -1, 1, -1, 1, -1 };
		int nx = 0;
		int ny = 0;
		int sum;

		for (int i = 0; i < 8; i++) {
			sum = 0;

			for (int j = 0; j < 4; j++) {
				if (i < 4) {
					nx = x + (dx[j] * rx[i]);
					ny = y + (dy[j] * ry[i]);
				} else {
					nx = x + (dy[j] * ry[i]);
					ny = y + (dx[j] * rx[i]);
				}

				if (!isRange(nx, ny)) {
					sum = 0;
					break;
				}

				sum += map[nx][ny];
			}
			ans = Math.max(sum, ans);
		}
	}

	static void z(int x, int y) {
		int[] dx = { 0, 1, 1, 2 };
		int[] dy = { 0, 0, 1, 1 };
		int[] rx = { 1, 1, -1, -1, 1, 1, -1, -1 };
		int[] ry = { 1, -1, 1, -1, 1, -1, 1, -1 };
		int nx = 0;
		int ny = 0;
		int sum;

		for (int i = 0; i < 8; i++) {
			sum = 0;

			for (int j = 0; j < 4; j++) {
				if (i < 4) {
					nx = x + (dx[j] * rx[i]);
					ny = y + (dy[j] * ry[i]);
				} else {
					nx = x + (dy[j] * ry[i]);
					ny = y + (dx[j] * rx[i]);
				}

				if (!isRange(nx, ny)) {
					sum = 0;
					break;
				}

				sum += map[nx][ny];
			}
			ans = Math.max(sum, ans);
		}
	}

	static void last(int x, int y) {
		int[] dx = { 0, 0, 0, 1 };
		int[] dy = { 0, 1, -1, 0 };
		int[] rx = { 1, -1, 1, -1 };
		int[] ry = { 1, 1, 1, 1 };
		int nx = 0;
		int ny = 0;
		int sum;

		for (int i = 0; i < 4; i++) {
			sum = 0;

			for (int j = 0; j < 4; j++) {
				if (i < 2) {
					nx = x + (dx[j] * rx[i]);
					ny = y + (dy[j] * ry[i]);
				} else {
					nx = x + (dy[j] * ry[i]);
					ny = y + (dx[j] * rx[i]);
				}

				if (!isRange(nx, ny)) {
					sum = 0;
					break;
				}

				sum += map[nx][ny];
			}

			ans = Math.max(sum, ans);
		}
	}

	static boolean isRange(int x, int y) {
		if (x < n && y < m && x >= 0 && y >= 0) {
			return true;
		} else {
			return false;
		}
	}
}
