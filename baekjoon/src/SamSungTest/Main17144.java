package SamSungTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main17144 {
	static int[][] map;
	static int[][] next;
	static int r, c, t;
	static Queue<Point> q;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static ArrayList<Point> wind = new ArrayList<>();
	static int ans = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		t = Integer.parseInt(st.nextToken());
		map = new int[r][c];
		next = new int[r][c];
		for (int i = 0; i < r; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < c; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				
				if (map[i][j] == -1) {
					wind.add(new Point(i, j));
				}
			}
		}
		int cnt = 0;
		while (cnt < t) {

			diffusion();
			cure();
			copy();

			cnt++;
		}
		
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				ans += map[i][j];
			}
		}
		
		System.out.println(ans+2);
	}

	static void copy() {
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				int num = next[i][j];
				map[i][j] = num;
			}
		}
	}

	static void cure() {
		for (int i = 0; i < 2; i++) {

			Point p = wind.get(i); // 위쪽
			int x = p.x;
			int y = p.y;

			Queue<Wind> wq = new LinkedList<>();
			wq.add(new Wind(1, 0));

			loop: while (true) {
				Wind w = wq.poll();

				int dir = w.dir;
				int num = w.next;

				// 방향 만큼 이동
				int nx = x + dx[dir];
				int ny = y + dy[dir];

				// 범위 밖으로 나가면 방향 바꾸기
				if (!isRange(nx, ny)) {
					if (i == 0) {
						dir++;
						if (dir > 3) {
							dir = 0;
						}
					} else {
						dir--;
						if (dir < 0) {
							dir = 3;
						}
					}

					x += dx[dir];
					y += dy[dir];
				} else { // 안나가면 그대로 넣기
					x = nx;
					y = ny;
				}

				// 숫자 빼놓기
				int nextNum = next[x][y];

				if (nextNum == -1) { // 공기청정기면 그만 돌아
					break loop;
				}

				// 숫자 넣기
				next[x][y] = num;

				wq.add(new Wind(dir, nextNum));
			}
		}
	}

	static void diffusion() {
		for (int i = 0; i < r; i++) {
			Arrays.fill(next[i], 0);
		}

		for (int i = 0; i < wind.size(); i++) {
			Point p = wind.get(i);
			next[p.x][p.y] = -1;
		}
		
		q = new LinkedList<>();
		
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if(map[i][j] > 0) {
					q.add(new Point(i, j));
				}
			}
		}

		while(!q.isEmpty()) {
			Point p = q.poll();
			int dust = map[p.x][p.y];

			int count = 0;

			for (int j = 0; j < 4; j++) {
				int nx = p.x + dx[j];
				int ny = p.y + dy[j];

				// 범위 밖
				if (!isRange(nx, ny)) {
					continue;
				}

				// 공기청정기 미세먼지
				if (map[nx][ny] == -1) {
					continue;
				}

				// 먼지가 퍼진다.
				next[nx][ny] += dust / 5;

				count++;
			}

			next[p.x][p.y] += dust - ((dust / 5) * count);
		}
	}

	static boolean isRange(int nx, int ny) {
		if (nx >= 0 && ny >= 0 && nx < r && ny < c) {
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

		@Override
		public String toString() {
			return "Point [x=" + x + ", y=" + y + "]";
		}
	}

	static class Wind {
		int dir, next;

		public Wind(int dir, int next) {
			super();
			this.dir = dir;
			this.next = next;
		}

		@Override
		public String toString() {
			return "Wind [dir=" + dir + ", next=" + next + "]";
		}
	}
}
