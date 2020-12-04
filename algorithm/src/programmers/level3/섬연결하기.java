package programmers.level3;

import java.util.PriorityQueue;

public class 섬연결하기 {
	static int[] parent;
	public static void main(String[] args) {
		int n = 4;
		int[][] costs = {{0,1,1},{0,2,2},{1,2,5},{1,3,1},{2,3,8}};
		solution(n, costs);
	}
	
	static int solution(int n, int[][] costs) {
		parent = new int[n];
		for (int i = 0; i < n; i++) {
			parent[i] = i;
		}

		int ans = 0;

		PriorityQueue<Point> pq = new PriorityQueue<Point>();

		for (int i = 0; i < costs.length; i++) {
			int s = costs[i][0];
			int e = costs[i][1];
			int cost = costs[i][2];

			pq.add(new Point(s, e, cost));
		}

		while (!pq.isEmpty()) {
			Point p = pq.poll();

			int s = find(p.s);
			int e = find(p.e);
			
			if(s == e) {
				continue;
			}
			
			parent[s] = e;

			ans += p.cost;
		}

		return ans;
	}

	static int find(int num) {
		if (parent[num] == num) {
			return num;
		}
		
		int temp = find(parent[num]);
		parent[num] = temp;
		
		return temp;
	}

	static class Point implements Comparable<Point> {
		int s, e, cost;

		public Point(int s, int e, int cost) {
			super();
			this.s = s;
			this.e = e;
			this.cost = cost;
		}

		@Override
		public String toString() {
			return "Point [s=" + s + ", e=" + e + ", cost=" + cost + "]";
		}

		@Override
		public int compareTo(Point p) {
			return this.cost < p.cost ? -1 : 1;
		}
	}
}
