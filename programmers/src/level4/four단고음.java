package level4;

import java.util.LinkedList;
import java.util.Queue;

public class four단고음 {
	public static void main(String[] args) {
		int n = 41;
		System.out.println(solution(n));
	}

	static int solution(int n) {
		int ans = 0;

		Queue<Point> q = new LinkedList<>();
		q.add(new Point(n - 2, 2));

		while (!q.isEmpty()) {
			Point p = q.poll();

			if (p.val < 3 || p.val < Math.pow(3, p.plus / 2)) {
				continue;
			}

			if (p.val == 3 && p.plus == 2) {
				ans++;
				continue;
			}

			int idx = 0;
			for (int i = 1; i < 3; i++) {
				if ((p.val - i) % 3 == 0) {
					idx = i;
					break;
				}
			}

			if (idx == 0) {
				if (p.plus >= 2) {
					q.add(new Point(p.val / 3, p.plus - 2));
				}

				q.add(new Point(p.val - 3, p.plus + 3));
			} else {
				q.add(new Point(p.val - idx, p.plus + idx));
			}
		}

		return ans;
	}

	static class Point {
		int val, plus;

		public Point(int val, int plus) {
			super();
			this.val = val;
			this.plus = plus;
		}

		@Override
		public String toString() {
			return "Point [val=" + val + ", plus=" + plus + "]";
		}
	}
}
