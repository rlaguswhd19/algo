package Dijkstra;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main1261 {
	static int[][] arr;
	static int[][] distance;
	static int[] a = { -1, 1, 0, 0 };
	static int[] b = { 0, 0, -1, 1 };
	static int n, m;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		arr = new int[m + 1][n + 1];
		distance = new int[m + 1][n + 1];
		sc.nextLine();
		for (int i = 1; i < m + 1; i++) {
			String s = sc.nextLine();
			for (int j = 0; j < s.length(); j++) {
				arr[i][j + 1] = s.charAt(j) - '0';
			}
		}

		for (int i = 1; i < m + 1; i++) {
			for (int j = 1; j < n + 1; j++) {
				distance[i][j] = Integer.MAX_VALUE;
			}
		}
		distance[1][1] = 0;

		dijkstra();

		System.out.println(distance[m][n]);
	}

	static void dijkstra() {
		PriorityQueue<point> pq = new PriorityQueue<>(new Comparator<point>() {

			@Override
			public int compare(point p1, point p2) {
				if (p1.value < p2.value) {
					return -1;
				} else {
					return 1;
				}
			}
		});

		pq.add(new point(1, 1, 0));

		while (!pq.isEmpty()) {
			point p = pq.poll();
			int x = p.x;
			int y = p.y;

			if (p.value > distance[x][y]) {
				continue;
			}

			for (int i = 0; i < 4; i++) {
				if (x + a[i] < m + 1 && x + a[i] >= 1 && y + b[i] < n + 1 && y + b[i] >= 1) {
					if (distance[x + a[i]][y + b[i]] > arr[x + a[i]][y + b[i]] + p.value) {
						distance[x + a[i]][y + b[i]] = arr[x + a[i]][y + b[i]] + p.value;
						pq.add(new point(x + a[i], y + b[i], distance[x + a[i]][y + b[i]]));
					}
				}
			}
		}
	}

	static class point {
		int x, y;
		int value;

		public point(int x, int y, int value) {
			super();
			this.x = x;
			this.y = y;
			this.value = value;
		}

		@Override
		public String toString() {
			return "point [x=" + x + ", y=" + y + ", value=" + value + "]";
		}
	}
}
