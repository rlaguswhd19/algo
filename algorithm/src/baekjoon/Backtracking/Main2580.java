package baekjoon.Backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main2580 {
	static int[][] map = new int[9][9];
	static int[][][] list = new int[9][9][10];
	static ArrayList<Point> plist = new ArrayList<>();
	static ArrayList<Point>[][] group = new ArrayList[9][9];
	static boolean[][] visit;
	static boolean isOk = false;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		plist.add(new Point(-1, -1));
		
		StringTokenizer st;
		for (int i = 0; i < 9; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < 9; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (map[i][j] == 0) {
					plist.add(new Point(i, j));
					group[i][j] = check(i, j);
				}
			}
		}

		dfs(1);
	}

	static void dfs(int idx) {
		if (idx == plist.size()) {
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					System.out.print(map[i][j] + " ");
				}
				System.out.println();
			}

			System.exit(0);
		}

		Point p = plist.get(idx);

		ArrayList<Point> g = group[p.x][p.y];

		// 쓸수 있는걸 찾는다.
		for (int j2 = 1; j2 < 10; j2++) {
			if (list[p.x][p.y][j2] == 0) {
				// j2를 쓰는것으로 2로 표시.
				list[p.x][p.y][j2] = -idx;

				for (int i = 0; i < g.size(); i++) {
					Point tp = g.get(i);

					if (list[tp.x][tp.y][j2] == 0) {
						list[tp.x][tp.y][j2] = -idx;
					}
				}

				// map에 j2 기입
				map[p.x][p.y] = j2;

				dfs(idx + 1);
				map[p.x][p.y] = 0;
				// j2 쓴것을 다시 돌려놓는다.

				list[p.x][p.y][j2] = 0;
				
				for (int i = 0; i < g.size(); i++) {
					Point tp = g.get(i);

					if (list[tp.x][tp.y][j2] == -idx) {
						list[tp.x][tp.y][j2] = 0;
					}
				}
			}
		}
	}

	static ArrayList<Point> check(int i, int j) {
		ArrayList<Point> temp = new ArrayList<>();
		visit = new boolean[9][9];
		visit[i][j] = true;

		// 가로
		for (int k = 0; k < 9; k++) {
			if (map[i][k] == 0 && !visit[i][k]) {
				temp.add(new Point(i, k));
				visit[i][k] = true;
			} else {
				list[i][j][map[i][k]] = 1;
			}
		}
		// 세로
		for (int k = 0; k < 9; k++) {
			if (map[k][j] == 0 && !visit[k][j]) {
				temp.add(new Point(k, j));
				visit[k][j] = true;
			} else {
				list[i][j][map[k][j]] = 1;
			}
		}

		// 네모 i/3 j/3 으로 범위 지정
		int x = i / 3 * 3;
		int y = j / 3 * 3;
		for (int k = x; k < x + 3; k++) {
			for (int k2 = y; k2 < y + 3; k2++) {
				if (map[k][k2] == 0 && !visit[k][k2]) {
					temp.add(new Point(k, k2));
					visit[k][k2] = true;
				} else {
					list[i][j][map[k][k2]] = 1;
				}
			}
		}

		return temp;
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
