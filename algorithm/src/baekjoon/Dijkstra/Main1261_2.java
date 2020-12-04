package baekjoon.Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main1261_2 {
	static int n, m;
	static int[][] distance;
	static int[][] map;
	static PriorityQueue<Point> pq;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		distance = new int[n][m];
		map = new int[n][m];

		for (int i = 0; i < n; i++) {
			String s = br.readLine();

			for (int j = 0; j < m; j++) {
				map[i][j] = s.charAt(j) - '0';
				distance[i][j] = Integer.MAX_VALUE;
			}
		}

		dijkstra();
		
		System.out.println(distance[n - 1][m - 1]);
	}

	static void dijkstra() {
		pq = new PriorityQueue<>(new Comparator<Point>() {

			@Override
			public int compare(Point p1, Point p2) {
				if (p1.val < p2.val) {
					return -1;
				} else {
					return 1;
				}
			}
		});

		pq.add(new Point(0, 0, 0));
		distance[0][0] = 0;

		while (!pq.isEmpty()) {
			Point p = pq.poll();

			if (p.val > distance[p.x][p.y]) {
				continue;
			}
			
			for (int i = 0; i < 4; i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
				
				if (!isOk(nx, ny)) {
					continue;
				}

				int val = p.val;

				if (map[nx][ny] == 1) {
					val++;
				}
				
				if (distance[nx][ny] > val) {
					distance[nx][ny] = val;
					pq.add(new Point(nx, ny, val));
				}
			}
		}
	}

	static boolean isOk(int nx, int ny) {
		if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
			return true;
		} else {
			return false;
		}
	}

	static class Point {
		int x, y, val;

		public Point(int x, int y, int val) {
			super();
			this.x = x;
			this.y = y;
			this.val = val;
		}

		@Override
		public String toString() {
			return "Point [x=" + x + ", y=" + y + ", val=" + val + "]";
		}
	}
}
