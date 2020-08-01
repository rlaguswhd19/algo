package T2019_2.Kakao;

import java.util.Comparator;
import java.util.PriorityQueue;

public class solution_4 {
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static PriorityQueue<Point> q;
	static int n, ans;
	static int[][] distance;
	static int[][] board = { { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 } };

	public static void main(String[] args) {
		n = board.length;
		distance = new int[n][n];
		ans = Integer.MAX_VALUE;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				distance[i][j] = Integer.MAX_VALUE;
			}
		}

		bfs();

		ans = distance[n - 1][n - 1];
		System.out.println(ans);
	}

	static void bfs() {
		q = new PriorityQueue<>(new Comparator<Point>() {

			@Override
			public int compare(Point p1, Point p2) {
				if (distance[p1.x][p1.y] > distance[p2.x][p2.y]) {
					return -1;
				} else {
					return 1;
				}
			}
		});

		q.add(new Point(0, 0, 0));
		distance[0][0] = 0;
		int cnt = 0;
		while (!q.isEmpty()) {
			int size = q.size();
			Point p = q.poll();
			int d = p.d;
			// 도착했을때
			if (p.x == n - 1 && p.y == n - 1) {
				continue;
			}

			for (int i = 0; i < 4; i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];

				// 범위
				if (!isRange(nx, ny)) {
					continue;
				}

				// 벽
				if (board[nx][ny] == 1) {
					continue;
				}

				int cost = 0;
				if (cnt == 0) {
					cost = 100;
				} else {
					if (d != i) { // 코너면
						cost = 600;
					} else { // 직진이면
						cost = 100;
					}
				}

				// 다음 갈곳의 cost 보다 크면
				if (distance[nx][ny] >= distance[p.x][p.y] + cost) {
					distance[nx][ny] = distance[p.x][p.y] + cost;
					q.add(new Point(nx, ny, i));
				}
			}
			cnt++;
		}
	}

	static boolean isRange(int nx, int ny) {
		if (nx >= 0 && nx < n && ny < n && ny >= 0) {
			return true;
		} else {
			return false;
		}
	}

	static class Point {
		int x, y, d;

		public Point(int x, int y, int d) {
			super();
			this.x = x;
			this.y = y;
			this.d = d;
		}

		@Override
		public String toString() {
			return "Point [x=" + x + ", y=" + y + ", d=" + d + "]";
		}
	}
}
