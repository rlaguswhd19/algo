package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main2178 {
	static int n, m;
	static int[][] map;
	static boolean[][] visit;
	static Queue<point> q;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		ans = 0;
		map = new int[n][m];
		visit = new boolean[n][m];

		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			for (int j = 0; j < s.length(); j++) {
				map[i][j] = s.charAt(j) - '0';
			}
		}

		bfs();

		System.out.println(ans);
	}

	static void bfs() {
		q = new LinkedList<>();

		q.add(new point(0, 0));
		visit[0][0] = true;
		int count = 1;
		loop: while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				point p = q.poll();
				if (p.x == n - 1 && p.y == m - 1) {
					ans = count;
					break loop;
				}
				for (int j = 0; j < 4; j++) {
					int nx = p.x + dx[j];
					int ny = p.y + dy[j];

					if (isRange(nx, ny)) {

						if (visit[nx][ny] || map[nx][ny] == 0) {
							continue;
						}

						q.add(new point(nx, ny));
						visit[nx][ny] = true;
					}
				}
			}
			count++;
		}
	}

	static boolean isRange(int x, int y) {
		if (x >= 0 && x < n && y >= 0 && y < m) {
			return true;
		} else {
			return false;
		}
	}

	static class point {
		int x, y;

		public point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "point [x=" + x + ", y=" + y + "]";
		}

	}
}
