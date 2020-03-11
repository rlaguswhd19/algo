package SamSungTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main15683 {
	static int[][] map;
	static int n, m, ans;
	static ArrayList<Cctv> list;
	static boolean visit[][];
	static int[] dx = { 0, -1, 0, 1 };
	static int[] dy = { 1, 0, -1, 0 };
	static Queue<Cctv> q;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		ans = Integer.MAX_VALUE;
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		list = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] != 0 && map[i][j] != 6) {
					list.add(new Cctv(i, j, -1, map[i][j]));
				}
			}
		}

		per(0);

		System.out.println(ans);
	}

	static void check() {
		visit = new boolean[n][m];
		for (int i = 0; i < list.size(); i++) {

			Cctv cctv = list.get(i);
			int cnt = 1;

			int num = cctv.num;
			int dir = cctv.dir;
			int x = cctv.x;
			int y = cctv.y;

			q = new LinkedList<>();

			if (num == 1) {
				q.add(cctv);
			} else if (num == 2) {
				q.add(cctv);
				q.add(new Cctv(x, y, dir + 2, num));
			} else if (num == 3) {
				q.add(cctv);

				if (dir + 1 > 3) {
					dir = 0;
				} else {
					dir += 1;
				}

				q.add(new Cctv(x, y, dir, num));
			} else if (num == 4) {
				q = new LinkedList<>();
				q.add(cctv);

				if (dir + 1 > 3) {
					dir = 0;
				} else {
					dir += 1;
				}

				q.add(new Cctv(x, y, dir, num));

				if (dir + 1 > 3) {
					dir = 0;
				} else {
					dir += 1;
				}

				q.add(new Cctv(x, y, dir, num));
			} else {
				q = new LinkedList<>();

				for (int j = 0; j < 4; j++) {
					q.add(new Cctv(x, y, j, num));
				}
			}

			while (!q.isEmpty()) {
				int size = q.size();
				for (int j = 0; j < size; j++) {

					Cctv cctv2 = q.poll();

					int nx = cctv2.x + dx[cctv2.dir];
					int ny = cctv2.y + dy[cctv2.dir];
					// 범위 밖을 나가면
					if (!isRange(nx, ny)) {
						continue;
					}

					// 벽을 만나면
					if (map[nx][ny] == 6) {
						continue;
					}

					// 감시 표시
					if (map[nx][ny] == 0 && !visit[nx][ny]) {
						visit[nx][ny] = true;
					}

					q.add(new Cctv(nx, ny, cctv2.dir, num));
				}

				cnt++;
			}
		}
		int sum = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 0 && !visit[i][j]) {
					sum++;
				}
			}
		}

		ans = Math.min(sum, ans);
	}

	static boolean isRange(int nx, int ny) {
		if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
			return true;
		} else {
			return false;
		}
	}

	static void per(int cnt) {
		if (cnt == list.size()) {
			check();
			return;
		}

		Cctv cctv = list.get(cnt);

		if (cctv.num == 2) {
			for (int i = 0; i < 2; i++) {
				cctv.dir = i;
				per(cnt + 1);
			}
		} else if (cctv.num == 5) {
			per(cnt + 1);
		} else {
			for (int i = 0; i < 4; i++) {
				cctv.dir = i;
				per(cnt + 1);
			}
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

	static class Cctv {
		int x, y;
		int dir;
		int num;

		public Cctv(int x, int y, int dir, int num) {
			super();
			this.x = x;
			this.y = y;
			this.dir = dir;
			this.num = num;
		}

		@Override
		public String toString() {
			return "Cctv [x=" + x + ", y=" + y + ", dir=" + dir + ", num=" + num + "]";
		}

	}
}
