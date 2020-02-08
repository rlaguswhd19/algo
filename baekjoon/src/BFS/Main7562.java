package BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main7562 {
	static Queue<point> q;
	static point start, end;
	static int n;
	static boolean[][] visit;
	static int[] dx = { -2, -1, -2, -1, 2, 1, 2, 1 };
	static int[] dy = { -1, -2, 1, 2, -1, -2, 1, 2 };
	static int ans;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();
		for (int tc = 0; tc < t; tc++) {

			n = sc.nextInt();
			start = new point(sc.nextInt(), sc.nextInt());
			end = new point(sc.nextInt(), sc.nextInt());
			ans = 0;
			visit = new boolean[n][n];
			if(end.x == start.x && end.y == start.y) {
				System.out.println(0);
			}else {
				bfs();
				System.out.println(ans + 1);
			}
		}
	}

	static void bfs() {
		q = new LinkedList<>();

		q.add(start);
		visit[start.x][start.y] = true;

		loop: while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				point p = q.poll();
				for (int j = 0; j < 8; j++) {
					int nx = p.x + dx[j];
					int ny = p.y + dy[j];

					if (!isRange(nx, ny)) {
						continue;
					}

					if (nx == end.x && ny == end.y) {
						break loop;
					}

					if (!visit[nx][ny]) {
						q.add(new point(nx, ny));
						visit[nx][ny] = true;
					}
				}
			}
			ans++;
		}
	}

	static boolean isRange(int x, int y) {
		if (x >= 0 && y >= 0 && x < n && y < n) {
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
