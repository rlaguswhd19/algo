package Level3;

import java.util.Comparator;
import java.util.PriorityQueue;

public class 풍선터트리기 {
	static int min, max;

	public static void main(String[] args) {
		int[] a = { -16, 27, 65, -2, 58, -92, -71, -68, -61, -33 };
		System.out.println(solution(a));
	}

	static int solution(int[] a) {
		PriorityQueue<Point> pq = new PriorityQueue<Point>(new Comparator<Point>() {

			@Override
			public int compare(Point p1, Point p2) {
				if (p1.val < p2.val) {
					return -1;
				} else {
					return 1;
				}
			}
		});

		for (int i = 0; i < a.length; i++) {
			pq.add(new Point(a[i], i));
		}

		Point first = pq.poll();
		max = first.idx;
		min = first.idx;
		
		int ans = 1;
		while (!pq.isEmpty()) {
			Point p = pq.poll();
			if (search(p.idx)) {
				ans++;
			}
		}

		return ans;
	}

	static boolean search(int idx) {
		if (min > idx) {
			min = idx;
			return true;
		} else if (max < idx) {
			max = idx;
			return true;
		} else {
			return false;
		}

	}

	static class Point {
		int val, idx;

		public Point(int val, int idx) {
			super();
			this.val = val;
			this.idx = idx;
		}

		@Override
		public String toString() {
			return "Point [val=" + val + ", idx=" + idx + "]";
		}
	}
}
