package D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution8382_방향전환 {
	static int[][] map;
	static Queue<Point> q;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static boolean[][] ud;
	static boolean[][] rl;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= t; tc++) {
			map = new int[201][201];
			q = new LinkedList<>();
			rl = new boolean[201][201];
			ud = new boolean[201][201];

			StringTokenizer st = new StringTokenizer(br.readLine());

			int sx = Integer.parseInt(st.nextToken()) + 100;
			int sy = Integer.parseInt(st.nextToken()) + 100;

			int ex = Integer.parseInt(st.nextToken()) + 100;
			int ey = Integer.parseInt(st.nextToken()) + 100;

			q.add(new Point(sx, sy, 1));
			q.add(new Point(sx, sy, 2));

			int cnt = 0;
			int ans = Integer.MAX_VALUE;

			loop: while (!q.isEmpty()) {
				int size = q.size();

				for (int s = 0; s < size; s++) {

					Point p = q.poll();

					if (p.x == ex && p.y == ey) {
						ans = cnt;
						break loop;
					}

					int nx = 0;
					int ny = 0;
					boolean updown = false;
					if (p.dir % 2 == 0) {
						updown = true;
					}

					for (int i = 0; i < 4; i++) {

						if (updown) { // ud
							if (i % 2 == 0) {
								continue;
							}

							nx = p.x + dx[i];
							ny = p.y + dy[i];
						} else { // rl
							if (i % 2 == 1) {
								continue;
							}

							nx = p.x + dx[i];
							ny = p.y + dy[i];
						}

						if (!isRange(nx, ny)) {
							continue;
						}

						if (updown) {
							if (!rl[nx][ny]) {
								q.add(new Point(nx, ny, i));
								rl[nx][ny] = true;
							}
						} else {
							if (!ud[nx][ny]) {
								q.add(new Point(nx, ny, i));
								ud[nx][ny] = true;
							}
						}
					}
				}

				cnt++;
			}

			System.out.println("#" + tc + " " + ans);
		}
	}

	static boolean isRange(int nx, int ny) {
		if (nx >= 0 && ny >= 0 && nx < 201 && ny < 201) {
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
