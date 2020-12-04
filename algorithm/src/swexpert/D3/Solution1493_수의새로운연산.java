package swexpert.D3;

import java.io.IOException;
import java.util.Scanner;

public class Solution1493_수의새로운연산 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		int[][] map = new int[301][301];
		Point[] map2 = new Point[10001];

		int cnt = 0; // 기준
		int plus = 0; // 더하기

		for (int i = 1; i < 301; i++) {
			cnt = map[i - 1][1] + i;
			plus = i;

			for (int j = 1; j < 301; j++) {

				if (j == 1) {
					map[i][j] = cnt;
				} else {
					cnt += plus;
					map[i][j] = cnt;
					plus++;
				}

				if (cnt <= 10000) {
					map2[cnt] = new Point(i, j);
				}
			}
		}

		for (int tc = 1; tc <= t; tc++) {

			int p = sc.nextInt();
			int q = sc.nextInt();

			cnt = 0;

			Point p1 = map2[p];
			Point p2 = map2[q];

			int x = p1.x + p2.x;
			int y = p1.y + p2.y;
//			
			System.out.println("#" + tc + " " + map[x][y]);
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
