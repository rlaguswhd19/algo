package baekjoon.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main2589 {
	static char[][] map;
	static int n, m;
	static Point s, e;
	static Queue<Point> q;
	static boolean[][] visit;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int max;
	static int c;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new char[n][m];
		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = s.charAt(j);
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 'L') {
					bfs(new Point(i, j));
				}
			}
		}
		System.out.println(max-1);
	}

	static void bfs(Point start) {
		q = new LinkedList<>();
		visit = new boolean[n][m];
		Point end = null;
		
		q.add(start);
		visit[start.x][start.y] = true;
		int count = 0;

		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				Point p = q.poll();
				end = p;
				for (int j = 0; j < 4; j++) {
					int nx = p.x + dx[j];
					int ny = p.y + dy[j];

					if (!isRange(nx, ny)) {
						continue;
					}

					if (map[nx][ny] == 'L' && !visit[nx][ny]) {
						q.add(new Point(nx, ny));
						visit[nx][ny] = true;
					}
				}
			}
			count++;
		}
		if (max < count) {
			max = count;
			s = start;
			e = end;
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
