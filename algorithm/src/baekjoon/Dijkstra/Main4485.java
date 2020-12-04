package baekjoon.Dijkstra;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main4485 {
	static int[][] map;
	static int[][] distance;
	static PriorityQueue<point> pq;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int n;
	static int count;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		count = 1;
		while (true) {
			n = sc.nextInt();

			if (n == 0) {
				break;
			}

			map = new int[n][n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					map[i][j] = sc.nextInt();
				}
			}

			distance = new int[n][n];

			for (int i = 0; i < n; i++) {
				Arrays.fill(distance[i], Integer.MAX_VALUE);
			}

			distance[0][0] = map[0][0];

			dijkstra();
			
			System.out.println("Problem "+count+": "+distance[n-1][n-1]);
			count++;
		}
	}

	static void dijkstra() {
		pq = new PriorityQueue<>(new Comparator<point>() {

			@Override
			public int compare(point p1, point p2) {
				if (map[p1.x][p1.y] < map[p2.x][p2.y]) {
					return -1;
				} else {
					return 1;
				}
			}
		});

		pq.add(new point(0, 0));

		while (!pq.isEmpty()) {
			point p = pq.poll();

			if (distance[p.x][p.y] < map[p.x][p.y]) {
				continue;
			}

			for (int i = 0; i < 4; i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];

				if (isRange(nx, ny)) {
					if (distance[nx][ny] > distance[p.x][p.y] + map[nx][ny]) {
						distance[nx][ny] = distance[p.x][p.y] + map[nx][ny];
						pq.add(new point(nx, ny));
					}
				}
			}
		}
	}

	static boolean isRange(int nx, int ny) {
		if (nx < n && ny < n && nx >= 0 && ny >= 0) {
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
