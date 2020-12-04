package baekjoon.SamSungTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main17142 {
	static int n, m, ans, count;
	static int[][] map;
	static ArrayList<Point> virus;
	static Point[] list;
	static Queue<Point> q;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		virus = new ArrayList<>();
		map = new int[n][n];
		list = new Point[m];
		ans = Integer.MAX_VALUE;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());

				if (map[i][j] == 2) {
					virus.add(new Point(i, j));
				}

				if (map[i][j] == 0) {
					count++;
				}
			}
		}

		if (count == 0) {
			System.out.println(0);
		} else {
			com(0, 0);
			System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
		}

	}

	static void bfs(int count) {
		q = new LinkedList<>();
		int[][] temp = new int[n][n];

		for (int i = 0; i < list.length; i++) {
			Point p = list[i];
			q.add(p);
			temp[p.x][p.y] = 2;
		}

		int cnt = 0;

		while (!q.isEmpty()) {

			int size = q.size();

			for (int i = 0; i < size; i++) {

				Point p = q.poll();

				for (int j = 0; j < 4; j++) {
					int nx = p.x + dx[j];
					int ny = p.y + dy[j];

					if (!isOk(nx, ny)) {
						continue;
					}

					// 바이러스가 이미 활성되있거나, 벽이면 가지말기
					if (map[nx][ny] == 1 || temp[nx][ny] != 0) {
						continue;
					}

					if (map[nx][ny] == 0) {
						count--;
					}

					q.add(new Point(nx, ny));
					temp[nx][ny] = 2;
				}
			}

			cnt++;

			if (count == 0) {
				ans = Math.min(ans, cnt);
			}
		}

	}

	static void com(int target, int cnt) {
		if (cnt == m) {
			bfs(count);
			return;
		} else if (target == virus.size()) {
			return;
		} else {
			list[cnt] = virus.get(target);
			com(target + 1, cnt + 1);
			com(target + 1, cnt);
		}
	}

	static boolean isOk(int nx, int ny) {
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
