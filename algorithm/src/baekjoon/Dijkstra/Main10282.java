package baekjoon.Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main10282 {
	static int n, d, c;
	static ArrayList<point>[] list;
	static PriorityQueue<point> pq;
	static int[] distance;
	static int max;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < t; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			max = -1;
			n = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			list = new ArrayList[n + 1];

			for (int i = 1; i < n + 1; i++) {
				list[i] = new ArrayList<>();
			}

			distance = new int[n + 1];
			for (int i = 0; i < d; i++) {
				st = new StringTokenizer(br.readLine());
				int r = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				int dis = Integer.parseInt(st.nextToken());
				list[c].add(new point(r, dis));
			}
			
			
			dijkstra();

			int sum = 0;
			for (int i = 1; i < distance.length; i++) {
				if (distance[i] != Integer.MAX_VALUE) {
					sum++;
					max = Math.max(distance[i], max);
				}
			}
			System.out.println(sum + " " + max);
		}
	}

	static void dijkstra() {
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[c] = 0;

		pq = new PriorityQueue<>(new Comparator<point>() {

			@Override
			public int compare(point p1, point p2) {
				if (p1.distance < p2.distance) {
					return -1;
				} else {
					return 1;
				}
			}
		});

		pq.add(new point(c, distance[c]));

		while (!pq.isEmpty()) {
			point p = pq.poll();
			if (distance[p.next] < p.distance) {
				continue;
			}
			
			for (int i = 0; i < list[p.next].size(); i++) {
				point p2 = list[p.next].get(i);
				int nx = p2.next;
				int nd = p2.distance;
				
				if (distance[nx] > distance[p.next] + nd) {
					distance[nx] = distance[p.next] + nd;
					pq.add(new point(nx, distance[nx]));
				}
			}
		}
	}

	static class point {
		int next;
		int distance;
		
		public point(int next, int distance) {
			super();
			this.next = next;
			this.distance = distance;
		}
		
		@Override
		public String toString() {
			return "point [next=" + next + ", distance=" + distance + "]";
		}
	}
}
