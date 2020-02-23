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
				q.add(new Point(x, y, dir));
				visit[dir][x][y] = true;
			} else {
				end = new Point(x, y, dir);
			}
		}

		bfs();
	}

	static void bfs() {

		int count = 0;

		while (!q.isEmpty()) {
			int size = q.size();
//			System.out.println(count);
			System.out.println(q);
			for (int i = 0; i < size; i++) {
				Point p = q.poll();
				int dir = p.dir;
				int x = p.x;
				int y = p.y;
				int cnt = 0;

				if (p.x == end.x && p.y == end.y && dir == end.dir) {
					System.out.println(count);
					return;
				}

				switch (dir) {
				case 1: // 동쪽

					if (!visit[4][x][y]) {
						q.add(new Point(x, y, 4));
						visit[4][x][y] = true;
					}

					if (!visit[3][x][y]) {
						q.add(new Point(x, y, 3));
						visit[3][x][y] = true;
					}

					loop: while (cnt < 3) {
						if (!isRange(x, y + 1)) {
							break;
						}

						if (map[x][y + 1] == 0 && !visit[dir][x][y + 1]) {
							visit[dir][x][y + 1] = true;
							q.add(new Point(x, y + 1, dir));
						} else {
							break loop;
						}
						cnt++;
						y++;
					}
					break;

				case 2: // 서쪽
					if (!visit[4][x][y]) {
						q.add(new Point(x, y, 4));
						visit[4][x][y] = true;
					}

					if (!visit[3][x][y]) {
						q.add(new Point(x, y, 3));
						visit[3][x][y] = true;
					}

					loop: while (cnt < 3) {
						if (!isRange(x, y - 1)) {
							break;
						}

						if (map[x][y - 1] == 0 && !visit[dir][x][y - 1]) {
							visit[dir][x][y - 1] = true;
							q.add(new Point(x, y - 1, dir));
						} else {
							break loop;
						}
						cnt++;
						y--;
					}
					break;

				case 3: // 남쪽
					if (!visit[1][x][y]) {
						q.add(new Point(x, y, 1));
						visit[1][x][y] = true;
					}

					if (!visit[2][x][y]) {
						q.add(new Point(x, y, 2));
						visit[2][x][y] = true;
					}

					loop: while (cnt < 3) {
						if (!isRange(x + 1, y)) {
							break;
						}

						if (map[x + 1][y] == 0 && !visit[dir][x + 1][y]) {
							visit[dir][x + 1][y] = true;
							q.add(new Point(x + 1, y, dir));
						} else {
							break loop;
						}
						cnt++;
						x++;
					}
					break;

				case 4: // 북쪽
					if (!visit[1][x][y]) {
						q.add(new Point(x, y, 1));
						visit[1][x][y] = true;
					}

					if (!visit[2][x][y]) {
						q.add(new Point(x, y, 2));
						visit[2][x][y] = true;
					}

					loop: while (cnt < 3) {
						if (!isRange(x - 1, y)) {
							break;
						}

						if (map[x - 1][y] == 0 && !visit[dir][x - 1][y]) {
							visit[dir][x - 1][y] = true;
							q.add(new Point(x - 1, y, dir));
						} else {
							break loop;
						}
						cnt++;
						x--;
					}
					break;
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