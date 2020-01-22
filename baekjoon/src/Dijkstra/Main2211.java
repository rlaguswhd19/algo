package Dijkstra;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main2211 {
	static int[][] map;
	static int[] distance;
	static int n;
	static ArrayList<Integer>[] list;
	static int count = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		int m = sc.nextInt();
		map = new int[n + 1][n + 1];
		distance = new int[n + 1];
		list = new ArrayList[n + 1];
		for (int i = 1; i < n + 1; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			map[a][b] = c;
			map[b][a] = c;
		}

		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[1] = 0;

		dijkstra();
		
		System.out.println(count);
		for (int i = 2; i < n + 1; i++) {
			for (int j = 0; j < list[i].size(); j++) {
				System.out.println(list[i].get(j) + " " + i);
			}
		}
	}

	static void dijkstra() {
		PriorityQueue<point> pq = new PriorityQueue<>(new Comparator<point>() {

			@Override
			public int compare(point p1, point p2) {
				if (p1.cost < p2.cost) {
					return -1;
				} else {
					return 1;
				}
			}
		});

		pq.add(new point(1, 0));

		while (!pq.isEmpty()) {
			point p = pq.poll();

			for (int i = 1; i < n + 1; i++) {
				if (map[p.now][i] != 0) {
					if (distance[i] > distance[p.now] + map[p.now][i]) {
						distance[i] = distance[p.now] + map[p.now][i];
						pq.add(new point(i, distance[i]));
						count++;
						if(list[i].size() != 0) {
							count--;
							list[i].remove(list[i].size()-1);
						}
						list[i].add(p.now);
					}
				}
			}

		}
	}

	static class point {
		int now, cost;

		public point(int now, int cost) {
			super();
			this.now = now;
			this.cost = cost;
		}

		@Override
		public String toString() {
			return "point [now=" + now + ", cost=" + cost + "]";
		}

	}
}
