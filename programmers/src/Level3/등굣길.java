package Level3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class 등굣길 {
	static int[] dx = { 1, 0 };
	static int[] dy = { 0, 1 };

	public static void main(String[] args) {
		int m = 4;
		int n = 3;
		int[][] puddles = { { 2, 2 } };
		System.out.println(solution(m, n, puddles));
	}

	static int solution(int m, int n, int[][] puddles) {
		int[][] distance = new int[n][m];
		int[][] cnt = new int[n][m];

		for (int i = 0; i < n; i++) {
			Arrays.fill(distance[i], Integer.MAX_VALUE);
		}

		for (int i = 0; i < puddles.length; i++) {
			int x = puddles[i][0] - 1;
			int y = puddles[i][1] - 1;

			distance[y][x] = 0;
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

		pq.add(new Point(0, 0, 0));
		distance[0][0] = 0;
		cnt[0][0] = 1;

		while (!pq.isEmpty()) {
			Point p = pq.poll();
			System.out.println(p);
			
			if (p.cost > distance[p.x][p.y]) { // 최단거리가 아니면 넘기기
				continue;
			}

			for (int i = 0; i < 2; i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];

				if (!isOk(nx, ny, n, m)) { // 범위 밖이면 넘기기
					continue;
				}

				if (distance[nx][ny] > p.cost + 1) { // 새로운 최단거리
					cnt[nx][ny] = cnt[p.x][p.y]; // 갯수 전에놈을 추가
					distance[nx][ny] = p.cost + 1; // 거리 초기화
					pq.add(new Point(nx, ny, p.cost + 1)); // 최초 하나 넣기
				} else if (distance[nx][ny] == p.cost + 1) {
					cnt[nx][ny] += cnt[p.x][p.y]; // 나머지는 갯수만 추가
					cnt[nx][ny] %= 1000000007; // 나눠주기
				}
			}
		}
		
		return cnt[n-1][m-1];
	}

	static boolean isOk(int nx, int ny, int n, int m) {
		if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
			return true;
		} else {
			return false;
		}
	}

	static class Point {
		int x, y, cost;

		public Point(int x, int y, int cost) {
			super();
			this.x = x;
			this.y = y;
			this.cost = cost;
		}

		@Override
		public String toString() {
			return "Point [x=" + x + ", y=" + y + ", cost=" + cost + "]";
		}
	}
}
