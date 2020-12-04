package programmers.level3;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class 정수삼각형 {
	public static void main(String[] args) {
		int[][] triangle = { { 7 }, { 3, 8 }, { 8, 1, 0 }, { 2, 7, 4, 4 }, { 4, 5, 2, 6, 5 } };
		solution(triangle);
	}

	static int solution(int[][] triangle) {
		int ans = 0;
		int len = triangle.length;
		int[][] dp = new int[len][len];
		dp[0][0] = triangle[0][0];
		LinkedList<Point> pq = new LinkedList<>();
		pq.add(new Point(0, 0, dp[0][0], 0));
		int left = 0;
		int right = 0;
		int size = 0;
		
		while (!pq.isEmpty()) {
			size = pq.size();
			Collections.sort(pq, new Comparator<Point>() {

				@Override
				public int compare(Point p1, Point p2) {
					return p2.val - p1.val;
				}
			});
			for (int i = 0; i < size; i++) {
				Point p = pq.poll();
				
				if(p.val > dp[p.x][p.y]) {
					continue;
				}
				
				if (p.level == len - 1) {
					ans = Math.max(ans, p.val);
					continue;
				}
				
				left = p.val + triangle[p.x + 1][p.y];
				right = p.val + triangle[p.x + 1][p.y + 1];
				
				if (left > dp[p.x + 1][p.y]) {
					dp[p.x + 1][p.y] = left;
					pq.add(new Point(p.x + 1, p.y, left, p.level + 1));
				}
				
				if (right > dp[p.x + 1][p.y + 1]) {
					dp[p.x + 1][p.y + 1] = right;
					pq.add(new Point(p.x + 1, p.y + 1, right, p.level + 1));
				}
			}
		}
		
		return ans;
	}

	static class Point {
		int x, y, val, level;

		public Point(int x, int y, int val, int level) {
			super();
			this.x = x;
			this.y = y;
			this.val = val;
			this.level = level;
		}

		@Override
		public String toString() {
			return "Point [x=" + x + ", y=" + y + ", val=" + val + ", level=" + level + "]";
		}
	}
}
