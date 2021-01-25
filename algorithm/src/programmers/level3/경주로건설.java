package programmers.level3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class 경주로건설 {
	public static void main(String[] args) {
		int[][] board = { { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 } };
		System.out.println(solution(board));
	}

	static int solution(int[][] board) {
		int[] dx = { 1, 0, -1, 0 };
		int[] dy = { 0, 1, 0, -1 };
		int[][] list = { { 0, 1, 3 }, { 1, 0, 2 }, { 2, 1, 3 }, { 3, 0, 2 } };
		int len = board.length;
		int[][][] map = new int[4][len][len];

		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < len; j++) {
				Arrays.fill(map[i][j], Integer.MAX_VALUE);
			}
		}

		map[0][0][0] = 0;
		map[1][0][0] = 0;
		map[2][0][0] = 0;
		map[3][0][0] = 0;

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

		pq.add(new Point(0, 0, 0, 0));
		pq.add(new Point(0, 0, 0, 1));
		while (!pq.isEmpty()) {
			Point p = pq.poll();
			if (map[p.dir][p.x][p.y] < p.cost) {
				continue;
			}

			int nx, ny, next_cost, dir;
			for (int i = 0; i < list[p.dir].length; i++) {
				dir = list[p.dir][i];
				if (p.dir == dir) {
					next_cost = 100;
				} else {
					next_cost = 600;
				}

				nx = p.x + dx[dir];
				ny = p.y + dy[dir];

				if (!isOk(nx, ny, len)) {
					continue;
				}

				if (board[nx][ny] == 1) {
					continue;
				}

				if (map[dir][nx][ny] > p.cost + next_cost) {
					map[dir][nx][ny] = p.cost + next_cost;
					pq.add(new Point(nx, ny, map[dir][nx][ny], dir));
				}
			}
		}

		int ans = Integer.MAX_VALUE;
		for (int i = 0; i < 4; i++) {
			ans = Math.min(ans, map[i][len - 1][len - 1]);
		}

		return ans;
	}

	static boolean isOk(int nx, int ny, int len) {
		if (nx >= 0 && ny >= 0 && nx < len && ny < len) {
			return true;
		} else {
			return false;
		}
	}

	static class Point {
		int x, y, cost, dir;

		public Point(int x, int y, int cost, int dir) {
			super();
			this.x = x;
			this.y = y;
			this.cost = cost;
			this.dir = dir;
		}
	}
}
