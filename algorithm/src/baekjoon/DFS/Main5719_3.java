package baekjoon.DFS;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main5719_3 {
	static int n, start, end;
	static int[][] map;
	static PriorityQueue<point> pq;
	static int[] distance;
	static boolean[] visit;
	
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
			visit = new boolean[n];
			
			for (int i = 0; i < m; i++) {
				int u = sc.nextInt();
				int v = sc.nextInt();
				int p = sc.nextInt();
				map[u][v] = p;
			}
			
			for (int i = 0; i < n; i++) {
				if(i == start) {
					distance[i] = 0;
				}else {
					distance[i] = Integer.MAX_VALUE;
				}
			}
			
			dijkstra();
			
			System.out.println(distance[end]);
		}
	}
	static void dijkstra() {
		pq = new PriorityQueue<>(new Comparator<point>() {
			@Override
			public int compare(point p1, point p2) {
				if(p1.d < p2.d) {
					return -1;
				}else {
					return 1;
				}
			}
		});
		
		pq.add(new point(0, start));
		
		while(!pq.isEmpty()) {
			point p = pq.poll();
			int cost = p.d;
			int num = p.num;
			
			
			if(distance[num] < cost) {
				continue;
			}
			
			for (int i = 0; i < n; i++) {
				if(map[num][i] != 0) {
					int dis = cost + map[num][i];
					if(distance[i] > dis) {
						distance[i] = dis;
						pq.add(new point(dis, i));
					}
				}
			}
		}
	}
	static class point{
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