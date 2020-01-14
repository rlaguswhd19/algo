package DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Main5719 {
	static int n, start, end;
	static PriorityQueue<point> pq;
	static int[] distance;
	static int[][] map;
	static ArrayList<Integer>[] list;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {

			n = sc.nextInt();
			int m = sc.nextInt();

			if (n == 0 && m == 0) {
				break;
			}

			start = sc.nextInt();
			end = sc.nextInt();
			distance = new int[n];
			map = new int[n][n];
			list = new ArrayList[n];

			for (int i = 0; i < n; i++) {
				if (i == start) {
					distance[i] = 0;
				} else {
					distance[i] = Integer.MAX_VALUE;
				}
				list[i] = new ArrayList<>();
				Arrays.fill(map[i], -1);
			}

			for (int i = 0; i < m; i++) {
				int u = sc.nextInt();
				int v = sc.nextInt();
				int p = sc.nextInt();
				map[u][v] = p;
			}
			
			dijkstra();
			pointremove();
			
			
			
			for (int i = 0; i < n; i++) {
				if (i == start) {
					distance[i] = 0;
				} else {
					distance[i] = Integer.MAX_VALUE;
				}
			}
			dijkstra();
			if(distance[end] == Integer.MAX_VALUE) {
				System.out.println(-1);
			}else {
				System.out.println(distance[end]);
			}
		}
	}
	static void pointremove() {
		Queue<Integer> q = new LinkedList<>();
		
		q.add(end);
		
		while(!q.isEmpty()) {
			int temp = q.poll();
			for (int i = 0; i < list[temp].size(); i++) {
				int c = list[temp].get(i);
				if(map[c][temp] != -1 && distance[temp] == map[c][temp] + distance[c]) {
					map[c][temp] = -1;
					q.add(c);
				}
			}
		}
	}
	static void dijkstra() {
		pq = new PriorityQueue<>(new Comparator<point>() {
			@Override
			public int compare(point p1, point p2) {
				if (p1.d < p2.d) {
					return -1;
				} else {
					return 1;
				}
			}
		});

		pq.add(new point(0, start));

		while (!pq.isEmpty()) {
			point p = pq.poll();
			int cost = p.d;
			int num = p.num;

			if (distance[num] < cost) {
				continue;
			}
			
			for (int i = 0; i < n; i++) {
				if (map[num][i] != -1 && distance[i] >= cost + map[num][i]) {
					distance[i] = cost + map[num][i];
					pq.add(new point(distance[i], i));
					list[i].add(num);
				}
			}
		}
	}

	static class point {
		int d, num;

		public point(int d, int num) {
			super();
			this.d = d;
			this.num = num;
		}

		@Override
		public String toString() {
			return "point [d=" + d + ", num=" + num + "]";
		}
	}
}