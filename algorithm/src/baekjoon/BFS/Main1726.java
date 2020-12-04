package baekjoon.BFS;

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
	static int[] dy = { 1, -1, 0, 0 }; // 동 서 남 북

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		map = new int[n + 1][m + 1];
		visit = new boolean[5][n + 1][m + 1];
		q = new LinkedList<>();

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
				visit[dir][x][y] = true;
				q.add(new Point(x, y, dir, 0));
			} else {
				end = new Point(x, y, dir, 0);
			}
		}

		bfs();
	}

	static void bfs() {

		while (!q.isEmpty()) {
			Point p = q.poll();
			int dir = p.dir;
			int x = p.x;
			int y = p.y;
			int cnt = p.cnt;

			if (p.x == end.x && p.y == end.y && dir == end.dir) {
				System.out.println(cnt);
				return;
			}

			for (int i = 1; i <= 3; i++) {
				int nx = x + (dx[dir - 1] * i);
				int ny = y + (dy[dir - 1] * i);
				if (!isRange(nx, ny)) {
					break;
				}
				if (map[nx][ny] == 0) {
					if (!visit[dir][nx][ny]) {
						visit[dir][nx][ny] = true;
						q.add(new Point(nx, ny, dir, cnt + 1));
					}
				} else {
					break;
				}
			}

			for (int i = 1; i < 5; i++) {
				if (dir != i && !visit[i][x][y]) {
					int add = 1;
					if (dir == 1) {
						if (i == 2) {
							add++;
						}
					} else if (dir == 2) {
						if (i == 1) {
							add++;
						}
					} else if (dir == 3) {
						if (i == 4) {
							add++;
						}
					} else if (dir == 4) {
						if (i == 3) {
							add++;
						}
					}

					visit[i][x][y] = true;
					q.add(new Point(x, y, i, cnt + add));
				}
			}
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
		int x, y, dir, cnt;

		public Point(int x, int y, int dir, int cnt) {
			super();
			this.x = x;
			this.y = y;
			this.dir = dir;
			this.cnt = cnt;
		}

		@Override
		public String toString() {
			return "Point [x=" + x + ", y=" + y + ", dir=" + dir + ", cnt=" + cnt + "]";
		}
	}
}