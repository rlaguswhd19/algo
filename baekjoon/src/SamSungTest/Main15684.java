package SamSungTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main15684 {
	static int[][] map;
	static int[] dy = { 0, 1, -1 };
	static int n, m, h, ans;
	static Point[] list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		map = new int[h + 1][n + 1];
		ans = -1;

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			map[a][b] = 1;
			map[a][b + 1] = 2;

		}

		check(0);

		for (int i = 1; i < 4; i++) {
			if (ans != -1) {
				break;
			}

			list = new Point[i];
			com(1, 1, 0);
		}

		System.out.println(ans);
	}

	static void check(int length) {
		for (int i = 1; i < n + 1; i++) {
			int r = 1;
			int c = i;

			while (r < h + 1) {
				if (map[r][c] == 0) {
					r++;
				} else if (map[r][c] == 1) {
					c += 1;
					r++;
				} else {
					c -= 1;
					r++;
				}
			}

			if (c != i) {
				return;
			}
		}

		ans = length;
	}

	static void com(int x, int y, int idx) {
		if (ans != -1) { // 정답이 나왔으면 return;
			return;
		}

		if (y == n) { // x y 수정
			x++;
			y = 1;
		}

		if (idx == list.length) {

			check(list.length);
			return;
		} else if (x == h + 1 && y == 1) { // 끝
			return;
		} else {
			// 선택할 수 있다면
			if (map[x][y] == 0 && map[x][y + 1] == 0) {
				list[idx] = new Point(x, y);
				map[x][y] = 1;
				map[x][y + 1] = 2;

				com(x, y + 1, idx + 1); // 선택

				map[x][y] = 0;
				map[x][y + 1] = 0;

				com(x, y + 1, idx); // 선택하지 않음
			} else { // 못하면 다음
				com(x, y + 1, idx);
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
}
