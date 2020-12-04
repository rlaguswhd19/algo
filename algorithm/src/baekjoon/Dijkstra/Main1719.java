package baekjoon.Dijkstra;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main1719 {
	static int n, m;
	static int[][] map;
	static int[] distance;
	static int[] ans;
	static PriorityQueue<point> pq;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		map = new int[n + 1][n + 1];
		distance = new int[n + 1];

		for (int i = 0; i < m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int d = sc.nextInt();
			map[a][b] = d;
			map[b][a] = d;
		}

		for (int i = 1; i < n + 1; i++) {
			dijkstra(i);
			for (int j = 1; j < n + 1; j++) {
				if (i == j) {
					System.out.print("- ");
				} else {
					System.out.print(ans[j] + " ");
				}
			}
			System.out.println();
		}

	}

	static void dijkstra(int start) {
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[start] = 0;
		ans = new int[n + 1];

		pq = new PriorityQueue<>(new Comparator<point>() {
			@Override
			public int compare(point p1, point p2) {
				if (p1.cost < p2.cost) {
					return -1;
				} else {
					return 1;
				}
			}
		});

		pq.add(new point(start, 0, start));

		int count = 0;

		while (!pq.isEmpty()) {
			point p = pq.poll();

			if (p.cost > distance[p.next]) {
				continue;
			}

			for (int i = 1; i < n + 1; i++) {
				if (map[p.next][i] == 0) {
					continue;
				}

				if (count == 0) {
					if (distance[i] > distance[p.next] + map[p.next][i]) {
						distance[i] = distance[p.next] + map[p.next][i];
						pq.add(new point(i, distance[i], i));
						ans[i] = i;
					}
				} else {
					if (distance[i] > distance[p.next] + map[p.next][i]) {
						distance[i] = distance[p.next] + map[p.next][i];
						pq.add(new point(i, distance[i], p.index));
						ans[i] = p.index;
					}
				}
			}
			count++;
		}
	}

	static class point {
		int next;
		int cost;
		int index;

		public point(int next, int cost, int index) {
			super();
			this.next = next;
			this.cost = cost;
			this.index = index;
		}

		@Override
		public String toString() {
			return "point [next=" + next + ", cost=" + cost + ", index=" + index + "]";
		}

	}
}
