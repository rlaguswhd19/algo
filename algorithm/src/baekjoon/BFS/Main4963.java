package baekjoon.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main4963 {
	static int[][] map;
	static boolean[][] visit;
	static Queue<Point> q;
	static int w, h;
	static int[] dx = { 1, 0, -1, 0, 1, 1, -1, -1 };
	static int[] dy = { 0, 1, 0, -1, 1, -1, 1, -1 };
	static int ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			ans = 0;
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());

			if (w == 0 && h == 0) {
				break;
			}

			map = new int[h][w];
			visit = new boolean[h][w];
			q = new LinkedList<>();

			for (int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < w; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if (map[i][j] == 1 && !visit[i][j]) {
						ans++;
						bfs(i, j);
					}
				}
			}

			System.out.println(ans);
		}
	}

	static void bfs(int x, int y) {
		q.add(new Point(x, y));
		visit[x][y] = true;

		while (!q.isEmpty()) {
			Point p = q.poll();

			for (int i = 0; i < 8; i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];

				if (!isOk(nx, ny)) {
					continue;
				}

				if (map[nx][ny] == 0) {
					continue;
				}

				if (visit[nx][ny]) {
					continue;
				}

				q.add(new Point(nx, ny));
				visit[nx][ny] = true;
			}
		}
	}

	static boolean isOk(int nx, int ny) {
		if (nx >= 0 && ny >= 0 && nx < h && ny < w) {
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
