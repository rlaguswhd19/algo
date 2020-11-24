package Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main5719 {
	static int n, m, s, d, ans;
	static int[] distance;
	static HashMap<Integer, ArrayList<Point>> map;
	static HashMap<Integer, ArrayList<Point>> remove;
	static PriorityQueue<Point> pq;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			if (n == 0 && m == 0) {
				break;
			}

			distance = new int[n];
			map = new HashMap<>();
			remove = new HashMap<>();

			st = new StringTokenizer(br.readLine());
			s = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());

			ArrayList<Point> temp;
			int now, next, cost;
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				now = Integer.parseInt(st.nextToken());
				next = Integer.parseInt(st.nextToken());
				cost = Integer.parseInt(st.nextToken());
				if (map.containsKey(now)) {
					temp = map.get(now);
				} else {
					temp = new ArrayList<>();
				}

				temp.add(new Point(next, cost));
				map.put(now, temp);
			}
			
			Arrays.fill(distance, Integer.MAX_VALUE);
			distance[s] = 0;
			dijkstra();
			
			remove_point();

			Arrays.fill(distance, Integer.MAX_VALUE);
			distance[s] = 0;
			dijkstra();
			System.out.println(distance[d] == Integer.MAX_VALUE ? -1 : distance[d]);
		}
	}

	static void remove_point() {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(d, distance[d]));
		ArrayList<Point> temp;

		while (!q.isEmpty()) {
			Point now = q.poll();
			
			if(!remove.containsKey(now.next)) {
				continue;
			}
			
			temp = remove.get(now.next);
			
			for (int i = 0; i < temp.size(); i++) {
				Point p = temp.get(i);

				if (distance[p.next] == now.cost - p.cost) {
					delete(p.next, now.next);
					q.add(new Point(p.next, distance[p.next]));
				}
			}
		}
	}

	static void delete(int now, int next) {
		ArrayList<Point> temp = map.get(now);

		for (int i = 0; i < temp.size(); i++) {
			Point p = temp.get(i);
			if (p.next == next) {
				temp.remove(i);
				return;
			}
		}
	}

	static void dijkstra() {
		pq = new PriorityQueue<Point>(new Comparator<Point>() {

			@Override
			public int compare(Point p1, Point p2) {
				return p1.cost - p2.cost;
			}
		});

		pq.add(new Point(s, 0));
		ArrayList<Point> temp;
		ArrayList<Point> remove_temp;
		while (!pq.isEmpty()) {
//			System.out.println(pq);
			Point now = pq.poll();
			if (now.cost > distance[now.next]) {
				continue;
			}
			
			if (!map.containsKey(now.next)) {
				continue;
			}

			temp = map.get(now.next);

			for (int i = 0; i < temp.size(); i++) {
				Point p = temp.get(i);

				if (distance[now.next] + p.cost <= distance[p.next]) {
					distance[p.next] = distance[now.next] + p.cost;

					if (remove.containsKey(p.next)) {
						remove_temp = remove.get(p.next);
					} else {
						remove_temp = new ArrayList<>();
					}

					remove_temp.add(new Point(now.next, p.cost));
					remove.put(p.next, remove_temp);
					pq.add(new Point(p.next, distance[p.next]));
				}
			}
		}
	}

	static class Point {
		int next, cost;

		public Point(int next, int cost) {
			super();
			this.next = next;
			this.cost = cost;
		}

		@Override
		public String toString() {
			return "Point [next=" + next + ", cost=" + cost + "]";
		}
	}
}
