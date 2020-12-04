package baekjoon.BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main7569 {
	static int[][][] map;
	static int n, m, h;
	static Queue<point> q;
	static ArrayList<point> checklist;
	static int ans;
	static int[] dx = { 1, 0, 0, -1, 0, 0 };
	static int[] dy = { 0, 1, 0, 0, -1, 0 };
	static int[] dz = { 0, 0, 1, 0, 0, -1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		m = sc.nextInt();
		n = sc.nextInt();
		h = sc.nextInt();

		ans = 0;
		map = new int[h][n][m];
		q = new LinkedList<>();
		checklist = new ArrayList<>();

		for (int i = 0; i < h; i++) {
			for (int j = 0; j < n; j++) {
				for (int j2 = 0; j2 < m; j2++) {
					map[i][j][j2] = sc.nextInt();
					if (map[i][j][j2] == 1) {
						q.add(new point(i, j, j2));
					} else if (map[i][j][j2] == 0) {
						checklist.add(new point(i, j, j2));
					}
				}
			}
		}
		if (checklist.size() == 0) {
			System.out.println(0);
		} else {
			bfs();
 			if (!check()) {
				System.out.println(-1);
			} else {
				System.out.println(ans - 1);
			}
		}
	}

	static boolean check() {
		boolean result = true;
		for (int i = 0; i < checklist.size(); i++) {
			point p = checklist.get(i);

			if (map[p.x][p.y][p.z] != 1) {
				result = false;
			}
		}
		return result;
	}

	static void bfs() {
		while (!q.isEmpty()) {
			int size = q.size();
			for (int a = 0; a < size; a++) {
				point p = q.poll();
				for (int i = 0; i < 6; i++) {
					int nx = p.x + dx[i];
					int ny = p.y + dy[i];
					int nz = p.z + dz[i];

					if (!isRange(nx, ny, nz)) {
						continue;
					}

					if (map[nx][ny][nz] == 0) {
						map[nx][ny][nz] = 1;
						q.add(new point(nx, ny, nz));
					}
				}
			}
			ans++;
		}
	}

	static boolean isRange(int x, int y, int z) {
		if (x >= 0 && y >= 0 && z >= 0 && x < h && y < n && z < m) {
			return true;
		} else {
			return false;
		}
	}

	static class point {
		int x, y, z;

		public point(int x, int y, int z) {
			super();
			this.x = x;
			this.y = y;
			this.z = z;
		}

		@Override
		public String toString() {
			return "point [x=" + x + ", y=" + y + ", z=" + z + "]";
		}

	}
}
