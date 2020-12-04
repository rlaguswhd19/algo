package baekjoon.Bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main3085 {
	static char[][] arr;
	static boolean[][][][] visit;
	static int ans, n;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	static Queue<Point> q;
	static boolean[][] ptemp;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());

		arr = new char[n][n];
		ans = 0;
		visit = new boolean[n][n][n][n];

		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			for (int j = 0; j < n; j++) {
				arr[i][j] = s.charAt(j);
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {

				// 4방향 검사
				for (int k = 0; k < 4; k++) {
					int nx = i + dx[k];
					int ny = j + dy[k];

					if (!isOk(nx, ny)) {
						continue;
					}

					if (visit[i][j][nx][ny]) {
						continue;
					}

					// 했다고 표시하기
					visit[i][j][nx][ny] = true;
					visit[nx][ny][i][j] = true;

					check(i, j, nx, ny);
				}
			}
		}
		
		System.out.println(ans);
	}

	static void check(int i, int j, int ni, int nj) {
		char temp = arr[i][j];
		arr[i][j] = arr[ni][nj];
		arr[ni][nj] = temp;
		q = new LinkedList<>();
		int cnt = 0;

		for (int a = 0; a < 4; a += 2) {

			q.add(new Point(i, j));
			ptemp = new boolean[n][n];
			ptemp[i][j] = true;
			cnt = 0;

			while (!q.isEmpty()) {
				Point p = q.poll();
				cnt++;

				for (int k = a; k < a + 2; k++) {
					int nx = p.x + dx[k];
					int ny = p.y + dy[k];

					if (!isOk(nx, ny)) {
						continue;
					}

					if (arr[p.x][p.y] != arr[nx][ny]) {
						continue;
					}

					if (ptemp[nx][ny]) {
						continue;
					}

					q.add(new Point(nx, ny));
					ptemp[nx][ny] = true;
				}
			}

			if (ans < cnt) {
				ans = cnt;
			}
		}

		for (int a = 0; a < 4; a += 2) {

			q.add(new Point(ni, nj));
			ptemp = new boolean[n][n];
			ptemp[ni][nj] = true;
			cnt = 0;

			while (!q.isEmpty()) {
				Point p = q.poll();
				cnt++;

				for (int k = a; k < a + 2; k++) {
					int nx = p.x + dx[k];
					int ny = p.y + dy[k];

					if (!isOk(nx, ny)) {
						continue;
					}

					if (arr[p.x][p.y] != arr[nx][ny]) {
						continue;
					}

					if (ptemp[nx][ny]) {
						continue;
					}

					q.add(new Point(nx, ny));
					ptemp[nx][ny] = true;
				}
			}

			if (ans < cnt) {
				ans = cnt;
			}
		}

		temp = arr[i][j];
		arr[i][j] = arr[ni][nj];
		arr[ni][nj] = temp;
	}

	static boolean isOk(int nx, int ny) {
		if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
			return true;
		} else {
			return false;
		}
	}

	static class Point {
		int x, y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "Point [x=" + x + ", y=" + y + "]";
		}
	}
}
