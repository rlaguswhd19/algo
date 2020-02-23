package BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main1726 {
	static int n, m;
	static int[][] map;
	static Queue<Point> q;
	static Point end;
	static int[][][] visit;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		map = new int[n + 1][m + 1];
		visit = new int[5][n + 1][m + 1];
		q = new LinkedList<>();
		
		for (int i = 1; i < 5; i++) {
			for (int j = 1; j < n+1; j++) {
				for (int j2 = 1; j2 < m+1; j2++) {
					visit[i][j][j2] = Integer.MAX_VALUE;
				}
			}
		}
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
				q.add(new Point(x, y, dir, 0));
				visit[dir][x][y] = 0;
			} else {
				end = new Point(x, y, dir, 0);
			}
		}

		bfs();
		
		System.out.println(visit[end.dir][end.x][end.y]);
	}

	static void bfs() {

		while (!q.isEmpty()) {
			int size = q.size();
			Point p = q.poll();
			int dir = p.dir;
			int x = p.x;
			int y = p.y;
			int cnt = 0;

			switch (dir) {
			case 1: // 동쪽

				if (visit[4][x][y] > p.cnt) {
					q.add(new Point(x, y, 4, p.cnt+1));
					visit[4][x][y] = p.cnt+1;
				}

				if (visit[3][x][y] > p.cnt) {
					q.add(new Point(x, y, 3, p.cnt+1));
					visit[3][x][y] = p.cnt+1;
				}

				loop: while (cnt < 3) {
					if (!isRange(x, y + 1)) {
						break;
					}

					if (map[x][y + 1] == 0 && visit[dir][x][y + 1] > p.cnt+1) {
						visit[dir][x][y + 1] = p.cnt+1;
						q.add(new Point(x, y + 1, dir, p.cnt+1));
					} else {
						break loop;
					}
					cnt++;
					y++;
				}
				break;

			case 2: // 서쪽
				if (visit[4][x][y] > p.cnt) {
					q.add(new Point(x, y, 4, p.cnt+1));
					visit[4][x][y] = p.cnt+1;
				}

				if (visit[3][x][y] > p.cnt) {
					q.add(new Point(x, y, 3, p.cnt+1));
					visit[3][x][y] = p.cnt+1;
				}

				loop: while (cnt < 3) {
					if (!isRange(x, y - 1)) {
						break;
					}

					if (map[x][y - 1] == 0 && visit[dir][x][y - 1] > p.cnt+1) {
						visit[dir][x][y - 1] = p.cnt+1;
						q.add(new Point(x, y - 1, dir, p.cnt+1));
					} else {
						break loop;
					}
					cnt++;
					y--;
				}
				break;

			case 3: // 남쪽
				if (visit[1][x][y] > p.cnt+1) {
					q.add(new Point(x, y, 1, p.cnt+1));
					visit[1][x][y] = p.cnt+1;
				}

				if (visit[2][x][y] > p.cnt+1) {
					q.add(new Point(x, y, 2, p.cnt+1));
					visit[2][x][y] = p.cnt+1;
				}

				loop: while (cnt < 3) {
					if (!isRange(x + 1, y)) {
						break;
					}

					if (map[x + 1][y] == 0 && visit[dir][x + 1][y] > p.cnt+1) {
						visit[dir][x + 1][y] = p.cnt+1;
						q.add(new Point(x + 1, y, dir, p.cnt+1));
					} else {
						break loop;
					}
					cnt++;
					x++;
				}
				break;

			case 4: // 북쪽
				if (visit[1][x][y] > p.cnt+1) {
					q.add(new Point(x, y, 1, p.cnt+1));
					visit[1][x][y] = p.cnt+1;
				}

				if (visit[2][x][y] > p.cnt+1) {
					q.add(new Point(x, y, 2, p.cnt+1));
					visit[2][x][y] = p.cnt+1;
				}

				loop: while (cnt < 3) {
					if (!isRange(x - 1, y)) {
						break;
					}

					if (map[x - 1][y] == 0 && visit[dir][x - 1][y] > p.cnt+1) {
						visit[dir][x - 1][y] = p.cnt+1;
						q.add(new Point(x - 1, y, dir, p.cnt+1));
					} else {
						break loop;
					}
					cnt++;
					x--;
				}
				break;
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