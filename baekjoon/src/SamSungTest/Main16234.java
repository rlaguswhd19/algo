package SamSungTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main16234 {
	static int[][] map;
	static int n, l, r;
	static Queue<Point> q;
	static boolean[][] visit;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		l = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());

		map = new int[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		ans = 0;
		move();
		System.out.println(ans);
	}

	static void move() {

		while (true) {
			visit = new boolean[n][n];

			int cnt = 0;
			// 무리 구하기
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (!visit[i][j]) {
						bfs(i, j);
						cnt++;
					}
				}
			}

			if (cnt == n * n) {
				break;
			}

			ans++;
		}
	}

	static void bfs(int i, int j) {
		q = new LinkedList<>();
		q.add(new Point(i, j));
		visit[i][j] = true;

		ArrayList<Point> list = new ArrayList<>();
		int sum = 0;
		while (!q.isEmpty()) {
			Point p = q.poll();
			list.add(p);
			int now = map[p.x][p.y];
			sum += now;
			for (int k = 0; k < 4; k++) {
				int nx = p.x + dx[k];
				int ny = p.y + dy[k];

				if (!isRange(nx, ny)) {
					continue;
				}
				if (visit[nx][ny]) {
					continue;
				}

				int next = map[nx][ny];
				
				if (Math.abs(next - now) >= l && Math.abs(next - now) <= r) {
					visit[nx][ny] = true;
					q.add(new Point(nx, ny));
				}
			}
		}
		int num = sum/list.size();
		for (int k = 0; k < list.size(); k++) {
			Point p = list.get(k);
			map[p.x][p.y] = num;
		}
	}

	static boolean isRange(int nx, int ny) {
		if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
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
