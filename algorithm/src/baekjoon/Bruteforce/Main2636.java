package baekjoon.Bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main2636 {
	static int[][] map;
	static int n, m, cheese, time, cnt;
	static Queue<Point> q = new LinkedList<>();
	static ArrayList<Point> arr;
	static boolean[][] visit;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		while (st.hasMoreTokens()) {
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			map = new int[n][m];
			visit = new boolean[n][m];
		}

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) {
					cheese++;
				}
			}
		}
		time = 0;
		cnt = cheese;

		bfs();
	}

	static void addPoint() {
		// 초기화
		arr = new ArrayList<>();
		visit = new boolean[n][m];

		arr.add(new Point(0, 0));
		q.add(new Point(0, 0));
		visit[0][0] = true;

		int nx = 0;
		int ny = 0;

		while (!q.isEmpty()) {
			Point p = q.poll();
			for (int i = 0; i < 4; i++) {
				nx = p.x + dx[i];
				ny = p.y + dy[i];

				if (!isOk(nx, ny)) {
					continue;
				}

				if (map[nx][ny] == 1) {
					continue;
				}

				if (visit[nx][ny]) {
					continue;
				}

				visit[nx][ny] = true;
				Point nb = new Point(nx, ny);
				arr.add(nb);
				q.add(nb);
			}
		}
	}

	static void bfs() {
		int nx = 0;
		int ny = 0;

		while (true) {
			// 빈 공간을 arr에 넣는다.
			addPoint();

			// 빈 공간을 q에 넣는다.
			for (int i = 0; i < arr.size(); i++) {
				q.add(arr.get(i));
			}

			// q가 돌면서 치즈를 없앤다.
			while (!q.isEmpty()) {

				Point p = q.poll();

				for (int i = 0; i < 4; i++) {
					nx = p.x + dx[i];
					ny = p.y + dy[i];

					if (!isOk(nx, ny)) {
						continue;
					}

					if (map[nx][ny] == 0) {
						continue;
					}

					map[nx][ny] = 0;
					cheese--;
				}
			}
			
			// 시간 증가
			time++;
			
			// 치즈가 다 녹으면 끝낸다.
			if(cheese == 0) {
				break;
			}
			
			// 남은 치즈를 기록한다.
			cnt = cheese;
		}
		
		System.out.println(time);
		System.out.println(cnt);
	}

	static boolean isOk(int x, int y) {
		if (x >= 0 && y >= 0 && x < n && y < m) {
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
	}
}
