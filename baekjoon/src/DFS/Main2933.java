package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main2933 {
	static char[][] map;
	static int r, c;
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };
	static boolean[][] visit;
	static Queue<point> q = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		map = new char[r][c];

		for (int i = 0; i < r; i++) {
			String s = br.readLine();
			map[i] = s.toCharArray();
		}

		int n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < n; i++) {
			int hight = r - Integer.parseInt(st.nextToken());

			broke(hight, i);

			bfs();
		}

		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}

	static void broke(int hight, int i) {
		if (i % 2 == 0) {
			for (int j = 0; j < c; j++) {
				if (map[hight][j] == 'x') {
					map[hight][j] = '.';
					break;
				}
			}
		} else {
			for (int j = c - 1; j >= 0; j--) {
				if (map[hight][j] == 'x') {
					map[hight][j] = '.';
					break;
				}
			}
		}
	}

	static void bfs() {
		visit = new boolean[r][c];
		ArrayList<point> list = new ArrayList<>();

		for (int i = 0; i < c; i++) {
			if (map[r - 1][i] == 'x' && !visit[r - 1][i]) {
				visit[r - 1][i] = true;
				q.add(new point(r - 1, i));

				while (!q.isEmpty()) {
					int size = q.size();
					for (int a = 0; a < size; a++) {
						point p = q.poll();

						for (int j = 0; j < 4; j++) {
							int nx = p.x + dx[j];
							int ny = p.y + dy[j];
							if (nx >= 0 && nx < r && ny >= 0 && ny < c) {
								if (!visit[nx][ny] && map[nx][ny] == 'x') {
									visit[nx][ny] = true;
									q.add(new point(nx, ny));
								}
							}
						}
					}

				}

			}
		}

		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (!visit[i][j] && map[i][j] == 'x') {
					map[i][j] = '.';
					list.add(new point(i, j));
				}
			}
		}

		if (list.isEmpty()) {
			return;
		}

		boolean down = true;

		while (down) {
			for (point p : list) {
				int nx = p.x + 1;
				int ny = p.y;
				if (!(nx >= 0 && nx < r && ny >= 0 && ny < c) || map[nx][ny] == 'x') {
					down = false;
					break;
				}
			}

			if (down) {
				for (point p : list) {
					p.x++;
				}
			}
		}

		for (point p : list) {
			map[p.x][p.y] = 'x';
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
