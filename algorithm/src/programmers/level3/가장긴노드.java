package programmers.level3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class 가장긴노드 {
	public static void main(String[] args) {
		int n = 6;
		int[][] edge = { { 3, 6 }, { 4, 3 }, { 3, 2 }, { 1, 3 }, { 1, 2 }, { 2, 4 }, { 5, 2 } };
		System.out.println(solution(n, edge));
	}

	static int solution(int n, int[][] edge) {
		HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
		ArrayList<Integer> temp;
		for (int i = 0; i < edge.length; i++) {
			int s = edge[i][0];
			int e = edge[i][1];

			if (map.containsKey(s)) {
				temp = map.get(s);
			} else {
				temp = new ArrayList<>();
			}

			temp.add(e);
			map.put(s, temp);

			if (map.containsKey(e)) {
				temp = map.get(e);
			} else {
				temp = new ArrayList<>();
			}

			temp.add(s);
			map.put(e, temp);
		}

		int[] dp = new int[n + 1];
		Arrays.fill(dp, Integer.MAX_VALUE);

		PriorityQueue<Point> pq = new PriorityQueue<Point>(new Comparator<Point>() {

			@Override
			public int compare(Point p1, Point p2) {
				return p1.cnt - p2.cnt;
			}
		});

		pq.add(new Point(1, 0));
		dp[1] = 0;
		int ans = 0;
		int max = 0;

		while (!pq.isEmpty()) {
			Point p = pq.poll();

			if (p.cnt > dp[p.now]) { // 자기보다 높으면 끝
				continue;
			}

			// 갈곳이 없으면 끝내기
			if (map.containsKey(p.now)) {
				temp = map.get(p.now);
			} else {
				continue;
			}

			for (int i = 0; i < temp.size(); i++) {
				int next = temp.get(i);

				if (dp[p.now] + 1 < dp[next]) {
					dp[next] = dp[p.now] + 1;
					pq.add(new Point(next, p.cnt + 1));
					
					if (max == dp[next]) {
						ans++;
					} else if (max < dp[next]) {
						max = dp[next];
						ans = 1;
					}
				}
			}
		}

		return ans;
	}

	static class Point {
		int now, cnt;

		public Point(int now, int cnt) {
			super();
			this.now = now;
			this.cnt = cnt;
		}
	}
}
