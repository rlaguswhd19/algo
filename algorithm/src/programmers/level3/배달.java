package programmers.level3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class 배달 {
	public static void main(String[] args) {
		int N = 5;
		int K = 3;
		int[][] road = { { 1, 2, 1 }, { 2, 3, 3 }, { 5, 2, 2 }, { 1, 4, 2 }, { 5, 3, 1 }, { 5, 4, 2 } };
		System.out.println(solution(N, road, K));
	}

	static int solution(int N, int[][] road, int K) {
		int[] distance = new int[N + 1];
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[1] = 0;
		HashMap<Integer, ArrayList<Point>> map = new HashMap<>();

		ArrayList<Point> temp;
		for (int i = 0; i < road.length; i++) {
			int now = road[i][0];
			int next = road[i][1];
			int cost = road[i][2];

			if (map.containsKey(now)) {
				temp = map.get(now);
			} else {
				temp = new ArrayList<>();
			}

			temp.add(new Point(next, cost));
			map.put(now, temp);

			if (map.containsKey(next)) {
				temp = map.get(next);
			} else {
				temp = new ArrayList<>();
			}

			temp.add(new Point(now, cost));
			map.put(next, temp);
		}

		PriorityQueue<Point> pq = new PriorityQueue<Point>(new Comparator<Point>() {

			@Override
			public int compare(Point p1, Point p2) {
				if (p1.cost < p2.cost) {
					return -1;
				} else {
					return 1;
				}
			}
		});

		pq.add(new Point(1, 0));

		while (!pq.isEmpty()) {
			Point p = pq.poll();

			if (distance[p.now] < p.cost) {
				continue;
			}

			if (!map.containsKey(p.now)) {
				continue;
			}

			temp = map.get(p.now);
			for (int i = 0; i < temp.size(); i++) {
				Point next = temp.get(i);
				if (distance[next.now] > p.cost + next.cost) {
					distance[next.now] = p.cost + next.cost;
					pq.add(new Point(next.now, distance[next.now]));
				}
			}
		}

		int ans = 0;
		for (int i = 1; i < distance.length; i++) {
			if (distance[i] <= K) {
				ans++;
			}
		}

		return ans;
	}

	static class Point {
		int now, cost;

		public Point(int now, int cost) {
			super();
			this.now = now;
			this.cost = cost;
		}

		@Override
		public String toString() {
			return "Point [now=" + now + ", cost=" + cost + "]";
		}
	}
}
