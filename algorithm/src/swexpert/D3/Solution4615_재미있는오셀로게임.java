package swexpert.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution4615_재미있는오셀로게임 {
	static int[][] map;
	static int n, m;
	static int[] dx = { 1, 0, -1, 0, 1, -1, 1, -1 };
	static int[] dy = { 0, 1, 0, -1, 1, -1, -1, 1 };
	static Queue<Point> q;
	static ArrayList<Point>[] arr;
	static int w, b;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= t; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			w = 0;
			b = 0;
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			q = new LinkedList<>();
			map = new int[n + 1][n + 1];
			arr = new ArrayList[8];

			// setting 1흑, 2백

			int temp = n / 2;
			map[temp][temp] = 2;
			map[temp + 1][temp + 1] = 2;
			map[temp + 1][temp] = 1;
			map[temp][temp + 1] = 1;

			for (int a = 0; a < m; a++) {
				st = new StringTokenizer(br.readLine());

				int y = Integer.parseInt(st.nextToken());
				int x = Integer.parseInt(st.nextToken());
				int num = Integer.parseInt(st.nextToken());

				map[x][y] = num;

				bfs(x, y, num);

			}

			for (int i = 1; i < n + 1; i++) {
				for (int j = 1; j < n + 1; j++) {
					if (map[i][j] == 1) {
						b++;
					} else if (map[i][j] == 2) {
						w++;
					}
				}
			}

			System.out.println("#" + tc + " " + b + " " + w);
		}
	}

	static void bfs(int x, int y, int num) {

		// 갔던 행적을 기록하는 arr
		for (int i = 0; i < 8; i++) {
			arr[i] = new ArrayList<>();
		}

		// 8방향을 탐지하고 갈 수 있는것만 q에 넣자
		for (int i = 0; i < 8; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (!isRange(nx, ny)) {
				continue;
			}

			// 비어있지 않고 다른 돌이면 q에 넣기
			if (map[nx][ny] != num && map[nx][ny] != 0) {
				q.add(new Point(nx, ny, i));
			}
		}

		while (!q.isEmpty()) {
			Point p = q.poll();

			// 행적에 추가하기
			arr[p.dir].add(p);

			int nx = p.x + dx[p.dir];
			int ny = p.y + dy[p.dir];

			if (!isRange(nx, ny)) {
				continue;
			}

			// 같은돌이면
			if (map[nx][ny] == num) {

				// 같은돌로 바꿔버리기
				for (int i = 0; i < arr[p.dir].size(); i++) {
					Point dol = arr[p.dir].get(i);
					map[dol.x][dol.y] = num;
				}

			} else {

				// 비어있으면
				if (map[nx][ny] == 0) {
					continue; // 끝
				} else { // 다른돌이면
					q.add(new Point(nx, ny, p.dir));
					arr[p.dir].add(new Point(nx, ny, p.dir));
				}
			}
		}
	}

	static boolean isRange(int nx, int ny) {
		if (nx >= 0 && nx < n + 1 && ny >= 0 && ny < n + 1) {
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
