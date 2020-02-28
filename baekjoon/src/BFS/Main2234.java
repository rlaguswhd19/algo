package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main2234 {
	static int[][] map;
	static int[][] result;
	static Queue<Point> q;
	static boolean[][] visit;
	static int n, m;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int room, max, wall;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		result = new int[n][m];
		visit = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (!visit[i][j]) {
					room++;
					bfs(i, j);
				}
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print(result[i][j] + " ");
			}
			System.out.println();
		}
		s-
		visit = new boolean[n][m];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (!visit[i][j]) {
					System.out.println(i+" "+j);
					wall(i, j, result[i][j]);
				}
			}
		}

		System.out.println(room);
		System.out.println(max);
		System.out.println(wall);
	}

	static void wall(int x, int y, int num) {
		q = new LinkedList<>();

		q.add(new Point(x, y));
		visit[x][y] = true;

		while (!q.isEmpty()) {
			Point p = q.poll();

			for (int i = 0; i < 4; i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];

				if (!isRange(nx, ny)) {
					continue;
				}

				if (!visit[nx][ny]) {
					if (result[nx][ny] == num) {
						q.add(new Point(nx, ny));
						visit[nx][ny] = true;
					} else {
						wall = Math.max(wall, result[nx][ny]+num);
					}
				}
			}
		}
	}

	static void bfs(int x, int y) {
		ArrayList<Point> list = new ArrayList<>();
		q = new LinkedList<>();

		q.add(new Point(x, y));
		visit[x][y] = true;
		int cnt = 0;
		while (!q.isEmpty()) {
			Point p = q.poll();
			list.add(p);
			int num = map[p.x][p.y];

			int[] arr = bit(num);
			for (int i = 0; i < 4; i++) {
				if (arr[i] == 0) {
					int nx = p.x + dx[i];
					int ny = p.y + dy[i];
					if (!visit[nx][ny]) {
						q.add(new Point(nx, ny));
						visit[nx][ny] = true;
					}
				}
			}
			cnt++;
		}

		for (int i = 0; i < list.size(); i++) {
			Point p = list.get(i);
			result[p.x][p.y] = cnt;
		}

		max = Math.max(cnt, max);
	}

	static int[] bit(int num) {

		int[] arr = new int[4];

		for (int i = 0; i < 4; i++) {
			arr[3 - i] = num & 1;
			num = num >> 1;
		}
		return arr;
	}

	static boolean isRange(int nx, int ny) {
		if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
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