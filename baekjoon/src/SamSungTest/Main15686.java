package SamSungTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main15686 {
	static int[][] map;
	static int n, m;
	static ArrayList<Point> homes;
	static ArrayList<Point> chickens;
	static Point[] result;
	static int ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][n];
		homes = new ArrayList<>();
		chickens = new ArrayList<>();
		result = new Point[m];
		ans = Integer.MAX_VALUE;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				int num = Integer.parseInt(st.nextToken());
				if (num == 1) {
					homes.add(new Point(i, j));
				} else if (num == 2) {
					chickens.add(new Point(i, j));
				}
			}
		}

		com(0, 0);
		System.out.println(ans);
	}

	static void check() {
		int sum = 0;
		int distance;
		for (int i = 0; i < homes.size(); i++) {
			Point home = homes.get(i);
			distance = Integer.MAX_VALUE;
			for (int j = 0; j < m; j++) {
				Point chicken = result[j];
				int temp = Math.abs(home.x - chicken.x) + Math.abs(home.y - chicken.y);
				distance = Math.min(temp, distance);
			}
			sum += distance;
		}
		ans = Math.min(sum, ans);
	}

	static void com(int cnt, int target) {
		if (cnt == m) {
			check();
			return;
		} else if (target == chickens.size()) {
			return;
		} else {
			result[cnt] = chickens.get(target);
			com(cnt + 1, target + 1);
			com(cnt, target + 1);
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
