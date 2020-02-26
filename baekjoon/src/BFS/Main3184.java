package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main3184 {
	static char[][] map;
	static boolean[][] visit;
	static int n, m;
	static Queue<Point> q;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int v, o;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new char[n][m];
		visit = new boolean[n][m];

		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			for (int j = 0; j < s.length(); j++) {
				map[i][j] = s.charAt(j);
				if (map[i][j] == 'v') {
					v++;
				} else if (map[i][j] == 'o') {
					o++;
				}
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (!visit[i][j] && map[i][j] != '#') {
					bfs(i, j);
				}
			}
		}
		System.out.println(o + " " + v);
	}

	static void bfs(int x, int y) {
		q = new LinkedList<>();
		q.add(new Point(x, y));
		visit[x][y] = true;

		// 초기화
		int vcnt = 0;
		int ocnt = 0;

		while (!q.isEmpty()) {
			Point p = q.poll();

			if (map[p.x][p.y] == 'o') {
				ocnt++;
			} else if (map[p.x][p.y] == 'v') {
				vcnt++;
			}
			for (int i = 0; i < 4; i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];

				if (!isRange(nx, ny)) {
					continue;
				}

				if (map[nx][ny] != '#' && !visit[nx][ny]) {
					q.add(new Point(nx, ny));
					visit[nx][ny] = true;
				}
			}
		}
		if (vcnt >= ocnt) {
			o -= ocnt;
		} else {
			v -= vcnt;
		}
	}

	static boolean isRange(int x, int y) {
		if (x >= 0 && y >= 0 && x < n && y < m) {
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
