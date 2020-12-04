package programmers.level3;

import java.util.Comparator;
import java.util.PriorityQueue;

public class 단속카메라 {
	public static void main(String[] args) {
		int[][] routes = { { -20, 15 }, { -14, -5 }, { -18, -13 }, { -5, -3 } };
		System.out.println(solution(routes));
	}

	static int solution(int[][] routes) {
		PriorityQueue<Point> pq = new PriorityQueue<Point>(new Comparator<Point>() {

			@Override
			public int compare(Point p1, Point p2) {
				return p1.e - p2.e;
			}
		});
		
		for (int i = 0; i < routes.length; i++) {
			pq.add(new Point(routes[i][0], routes[i][1]));
		}
		
		int camera = pq.poll().e;
		int ans = 1;
		while(!pq.isEmpty()) {
			Point p = pq.poll();
			if(camera < p.s) {
				camera = p.e;
				ans++;
			}
		}
		return ans;
	}

	static class Point {
		int s, e;

		public Point(int s, int e) {
			super();
			this.s = s;
			this.e = e;
		}
	}
}
