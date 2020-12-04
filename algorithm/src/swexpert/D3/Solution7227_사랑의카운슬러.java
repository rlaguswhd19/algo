package swexpert.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution7227_사랑의카운슬러 {
	static Point[] arr;
	static int[] list;
	static int n;
	static long min;
	static boolean[] visit;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= t; tc++) {
			n = Integer.parseInt(br.readLine());
			arr = new Point[n];
			visit = new boolean[n];
			list = new int[n / 2];
			StringTokenizer st;

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());

				arr[i] = new Point(x, y);
			}
			min = Long.MAX_VALUE;
			com(0, 0);
			System.out.println("#" + tc + " " + min);
		}
	}
	static void com(int idx, int target) {
		if (idx == n / 2) {
			long x = 0;
			long y = 0;
			visit = new boolean[n];
			for (int i = 0; i < list.length; i++) {
				int index = list[i];
				visit[index] = true;
				x += arr[index].x;
				y += arr[index].y;
			}

			for (int i = 0; i < visit.length; i++) {
				if (!visit[i]) {
					x -= arr[i].x;
					y -= arr[i].y;
				}
			}
			min = Math.min(min, x * x + y * y);
			return;
		} else if (target == n) {
			return;
		} else {
			list[idx] = target;
			com(idx + 1, target + 1);
			com(idx, target + 1);
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
