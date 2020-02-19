package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main1600 {
	static int r, c, k;
	static int[][] map;
	static boolean[][][] visit;
	static Queue<Point> q;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int[] ndx = { 2, 1, -2, -1, 2, 1, -2, -1 };
	static int[] ndy = { 1, 2, 1, 2, -1, -2, -1, -2 };
	static int ans = Integer.MAX_VALUE;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		k = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		c = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		map = new int[r][c];
		visit = new boolean[k + 1][r][c];

		for (int i = 0; i < r; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < c; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		bfs();

		if (ans == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(ans);
		}
	}

	static void bfs() {
		q = new LinkedList<>();

		q.add(new Point(0, 0, k, 0));

		while (!q.isEmpty()) {
			Point p = q.poll();
			if (p.x == r - 1 && p.y == c - 1) {
				ans = Math.min(ans, p.count);
				return;
			}
			int k2 = p.k2;

			if (!isRange(p.x, p.y)) {
				continue;
			}
			if (map[p.x][p.y] == 1) {
				continue;
			}
			if (visit[k2][p.x][p.y]) {
				continue;
			}
			visit[k2][p.x][p.y] = true;
			
			for (int i = 0; i < 4; i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];

				q.add(new Point(nx, ny, k2, p.count+1));
			}

			if (k2 == 0) {
				continue;
			}

			for (int i = 0; i < 8; i++) {
				int nx = p.x + ndx[i];
				int ny = p.y + ndy[i];

				q.add(new Point(nx, ny, k2 - 1, p.count+1));
			}
		}
	}

	static boolean isRange(int x, int y) {
		if (x >= 0 && y >= 0 && x < r && y < c) {
			return true;
		} else {
			return false;
		}
	}

	static class Point {
		int x, y, k2, count;

		public Point(int x, int y, int k2, int count) {
			super();
			this.x = x;
			this.y = y;
			this.k2 = k2;
			this.count = count;
		}

		@Override
		public String toString() {
			return "Point [x=" + x + ", y=" + y + ", k2=" + k2 + ", count=" + count + "]";
		}

	}
}
