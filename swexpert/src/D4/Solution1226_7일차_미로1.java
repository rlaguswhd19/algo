package D4;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Solution1226_7일차_미로1 {
	static int[][] map;
	static boolean[][] visit;
	static Queue<Point> q;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int tc = 1; tc <= 10; tc++) {
			int t = Integer.parseInt(br.readLine());

			map = new int[16][16];
			q = new LinkedList<>();
			visit = new boolean[16][16];
			int ex = 0, ey = 0;
			int isOk = 0;

			for (int i = 0; i < 16; i++) {
				String s = br.readLine();

				for (int j = 0; j < s.length(); j++) {
					map[i][j] = s.charAt(j) - '0';

					if (map[i][j] == 2) {
						q.add(new Point(i, j));
						visit[i][j] = true;
					} else if (map[i][j] == 3) {
						ex = i;
						ey = j;
					}
				}
			}

			while (!q.isEmpty()) {
				Point p = q.poll();

				if (p.x == ex && p.y == ey) {
					isOk = 1;
					break;
				}

				int nx = 0;
				int ny = 0;

				for (int i = 0; i < 4; i++) {
					nx = p.x + dx[i];
					ny = p.y + dy[i];

					if (!isRange(nx, ny)) {
						continue;
					}

					if (map[nx][ny] == 1) {
						continue;
					}

					if (visit[nx][ny]) {
						continue;
					}

					q.add(new Point(nx, ny));
					visit[nx][ny] = true;
				}
			}

			System.out.println("#" + tc + " " + isOk);
		}
	}

	static boolean isRange(int nx, int ny) {
		if (nx >= 0 && ny >= 0 && nx < 16 && ny < 16) {
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
