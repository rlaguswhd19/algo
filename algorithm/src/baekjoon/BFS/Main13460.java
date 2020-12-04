package baekjoon.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main13460 {
	static int n, m;
	static char[][] map;
	static int rx, ry, bx, by;
	static boolean[][][][] visit;
	static int ans;
	static boolean find;
	static Queue<Point> q;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		ans = 0;
		map = new char[n][m];
		find = false;
		visit = new boolean[10][10][10][10];

		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			for (int j = 0; j < s.length(); j++) {
				map[i][j] = s.charAt(j);
				if (map[i][j] == 'R') {
					rx = i;
					ry = j;
					map[i][j] = '.';
				} else if (map[i][j] == 'B') {
					bx = i;
					by = j;
					map[i][j] = '.';
				}
			}
		}
		bfs();
		
	}

	static void bfs() {
		q = new LinkedList<>();

		q.add(new Point(rx, ry, bx, by));

		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				Point p = q.poll();
				visit[p.rx][p.ry][p.bx][p.by] = true;
				for (int j = 0; j < 4; j++) {
					move(j, p.rx, p.ry, p.bx, p.by);

					if (find) {
						System.out.println(ans + 1);
						return;
					}
				}
			}
			ans++;
			if (ans >= 10) {
				System.out.println(-1);
				return;
			}
		}
		System.out.println(-1);
	}

	static void move(int dir, int rx, int ry, int bx, int by) {
		boolean r = false;
		boolean b = false;
		Point first = new Point(rx, ry, bx, by);
		switch (dir) {
		case 0: // 왼쪽
			red: while (true) {

				// 빨강
				if (map[rx][ry - 1] != '#') {
					ry--;
				} else {
					break red;
				}

				// 빨강확인
				if (map[rx][ry] == 'O') {
					r = true;
					break red;
				}
			}

			blue: while (true) {
				// 파랑
				if (map[bx][by - 1] != '#') {
					by--;
				} else {
					break blue;
				}
				// 파랑확인
				if (map[bx][by] == 'O') {
					b = true;
					break blue;
				}
			}

			if (b) {
				return;
			}

			if (r) {
				find = true;
				return;
			}

			if (rx == bx && ry == by) {
				if (first.ry < first.by) {
					by++;
				} else if (first.ry > first.by) {
					ry++;
				}
			}
			if (!visit[rx][ry][bx][by]) {
				q.add(new Point(rx, ry, bx, by));
			}
			return;
		case 1: // 오른쪽
			red: while (true) {

				// 빨강
				if (map[rx][ry + 1] != '#') {
					ry++;
				} else {
					break red;
				}

				// 빨강확인
				if (map[rx][ry] == 'O') {
					r = true;
					break red;
				}
			}

			blue: while (true) {
				// 파랑
				if (map[bx][by + 1] != '#') {
					by++;
				} else {
					break blue;
				}
				// 파랑확인
				if (map[bx][by] == 'O') {
					b = true;
					break blue;
				}
			}

			if (b) {
				return;
			}

			if (r) {
				find = true;
				return;
			}
			if (rx == bx && ry == by) {
				if (first.ry < first.by) {
					ry--;
				} else if (first.ry > first.by) {
					by--;
				}
			}
			if (!visit[rx][ry][bx][by]) {
				q.add(new Point(rx, ry, bx, by));
			}
			return;
		case 2: // 아래
			red: while (true) {

				// 빨강
				if (map[rx + 1][ry] != '#') {
					rx++;
				} else {
					break red;
				}

				// 빨강확인
				if (map[rx][ry] == 'O') {
					r = true;
					break red;
				}
			}

			blue: while (true) {
				// 파랑
				if (map[bx + 1][by] != '#') {
					bx++;
				} else {
					break blue;
				}
				// 파랑확인
				if (map[bx][by] == 'O') {
					b = true;
					break blue;
				}
			}

			if (b) {
				return;
			}
			if (r) {
				find = true;
				return;
			}

			if (rx == bx && ry == by) {
				if (first.rx < first.bx) {
					rx--;
				} else if (first.rx > first.bx) {
					bx--;
				}
			}
			if (!visit[rx][ry][bx][by]) {
				q.add(new Point(rx, ry, bx, by));
			}
			return;
		case 3: // 위
			red: while (true) {

				// 빨강
				if (map[rx - 1][ry] != '#') {
					rx--;
				} else {
					break red;
				}

				// 빨강확인
				if (map[rx][ry] == 'O') {
					r = true;
					break red;
				}
			}

			blue: while (true) {
				// 파랑
				if (map[bx - 1][by] != '#') {
					bx--;
				} else {
					break blue;
				}
				// 파랑확인
				if (map[bx][by] == 'O') {
					b = true;
					break blue;
				}
			}

			if (b) {
				return;
			}

			if (r) {
				find = true;
				return;
			}

			// 같을때
			if (rx == bx && ry == by) {
				if (first.rx < first.bx) {
					bx++;
				} else if (first.rx > first.bx) {
					rx++;
				}
			}

			if (!visit[rx][ry][bx][by]) {
				q.add(new Point(rx, ry, bx, by));
			}
			return;
		}
	}

	static class Point {
		int rx, ry, bx, by;

		public Point(int rx, int ry, int bx, int by) {
			super();
			this.rx = rx;
			this.ry = ry;
			this.bx = bx;
			this.by = by;
		}

		@Override
		public String toString() {
			return "Point [rx=" + rx + ", ry=" + ry + ", bx=" + bx + ", by=" + by + "]";
		}

	}
}
