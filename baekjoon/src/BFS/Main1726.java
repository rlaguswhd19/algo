package BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main1726 {
	static int n, m;
	static int[][] map;
	static Queue<Point> q;
	static Point end;
	static boolean[][][] visit;
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };
	static boolean find;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		map = new int[n + 1][m + 1];
		visit = new boolean[5][n + 1][m + 1];
		q = new LinkedList<>();
		find = false;

		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < m + 1; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		for (int i = 0; i < 2; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int dir = sc.nextInt();

			if (i == 0) {
				q.add(new Point(x, y, dir));
				visit[dir][x][y] = true;
			} else {
				end = new Point(x, y, dir);
			}
		}

		bfs();
	}

	static void go(int x, int y, int dir, int cnt) {
		if (cnt > 3) {
			return;
		}

		if (!visit[dir][x][y]) {
			q.add(new Point(x, y, dir));
			visit[dir][x][y] = true;
		}

		int nx = x + dx[dir - 1];
		int ny = y + dy[dir - 1];

		if (!isRange(nx, ny)) {
			return;
		}

		if (map[nx][ny] == 0 && !visit[dir][nx][ny]) {
			go(nx, ny, dir, cnt + 1);
		}
	}

	static void bfs() {

		int count = 0;

		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				Point p = q.poll();
				int dir = p.dir;

				if (p.x == end.x && p.y == end.y) {
					if (dir == end.dir) {
						System.out.println(count);
					} else {
						System.out.println(count + 1);
					}
					return;
				}

				for (int j = 0; j < 4; j++) {
					int nx = p.x + dx[j];
					int ny = p.y + dy[j];

					if (!isRange(nx, ny)) {
						continue;
					}

					if (map[nx][ny] == 0 && !visit[j + 1][nx][ny]) {
						if (dir == j + 1) {
							visit[j + 1][p.x][p.y] = true;
							go(nx, ny, dir, 1);
						} else {
							q.add(new Point(p.x, p.y, j + 1));
							visit[j + 1][p.x][p.y] = true;
						}
					}
				}
			}
			count++;
		}
	}

	static boolean isRange(int x, int y) {
		if (x >= 1 && y >= 1 && x < n + 1 && y < m + 1) {
			return true;
		} else {
			return false;
		}
	}

	static class Point {
		int x, y, dir;

		public Point(int x, int y, int dir) {
			super();
			this.x = x;
			this.y = y;
			this.dir = dir;
		}

		@Override
		public String toString() {
			return "Point [x=" + x + ", y=" + y + ", dir=" + dir + "]";
		}
	}
}