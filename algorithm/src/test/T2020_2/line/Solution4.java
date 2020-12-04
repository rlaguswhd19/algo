package test.T2020_2.line;

import java.util.LinkedList;
import java.util.Queue;

public class Solution4 {

	// 방향에 따른 진행 방향
	static int[] dy = { 0, 1, 0, -1 };
	static int[] dx = { 1, 0, -1, 0 };

	// 왼쪽 검사하기 위한 배열
	static int[] ch_dy = { 1, 0, -1, 0 };
	static int[] ch_dx = { 0, -1, 0, 1 };
	static int dir; // 0 밑, 1 오른쪽, 2 위, 3 왼쪽 이 순서로 밖에 못돔
	static int size;

	public static void main(String[] args) {
		int[][] maze = 	{{0, 0, 0, 0, 0, 0}, {1, 1, 1, 0, 1, 1}, {0, 0, 0, 0, 0, 0}, {1, 0, 1, 1, 1, 1}, {0, 0, 0, 0, 0, 0}, {1, 1, 0, 1, 1, 0}};
		System.out.println(solution(maze));
	}

	static int solution(int[][] maze) {
		Queue<Point> q = new LinkedList<>();
		size = maze.length;

		q.add(new Point(0, 0));
		int cnt = 1;

		if (maze[0][1] == 1) {
			dir = 0;
		} else if (maze[1][0] == 1) {
			dir = 1;
		}

		while (!q.isEmpty()) {
			Point p = q.poll();
			maze[p.x][p.y] = 2;
			if (p.x == size - 1 && p.y == size - 1) {
				return cnt - 1;
			}

			// 왼쪽 벽 확인
			int ch_nx = p.x + ch_dx[dir];
			int ch_ny = p.y + ch_dy[dir];

			if (!isOk(ch_nx, ch_ny) || maze[ch_nx][ch_ny] == 1) { // 왼쪽 벽이 있다고 판단
				int nx = p.x + dx[dir];
				int ny = p.y + dy[dir];

				if (!isOk(nx, ny) || maze[nx][ny] == 1) { // 벽이면 방향 전환 dir-=1
					dir -= 1;
					if (dir == -1) {
						dir = 3;
					}

					q.add(new Point(p.x, p.y)); // 현재 위치 넣어주기
				} else { // 벽이 아니면
					cnt++;

					q.add(new Point(nx, ny));
				}
			} else { // 왼쪽 벽이 없으면 방향전환 dir+=1 후 전진
				dir += 1;
				if (dir == 4) {
					dir = 0;
				}

				int nx = p.x + dx[dir];
				int ny = p.y + dy[dir];

				cnt++;

				q.add(new Point(nx, ny));
			}
		}
		
		return cnt;
	}

	static boolean isOk(int nx, int ny) {
		if (nx < size && ny < size && nx >= 0 && ny >= 0) {
			return true;
		} else {
			return false;
		}
	}

	static class Point {
		int x, y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
}
