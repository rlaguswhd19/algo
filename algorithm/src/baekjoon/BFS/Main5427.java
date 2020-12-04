package baekjoon.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main5427 {
	static int r, c;
	static char[][] map;
	static boolean[][] visit;
	static Point start, end;
	static Queue<Point> mq;
	static Queue<Point> fq;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int ans;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < t; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			c = Integer.parseInt(st.nextToken());
			r = Integer.parseInt(st.nextToken());
			ans = Integer.MAX_VALUE;
			map = new char[r][c];
			visit = new boolean[r][c];
			fq = new LinkedList<>();
			mq = new LinkedList<>();

			for (int i = 0; i < r; i++) {
				String s = br.readLine();
				for (int j = 0; j < c; j++) {
					map[i][j] = s.charAt(j);
					if (map[i][j] == '@') {
						mq.add(new Point(i, j));
						map[i][j] = '.';
						visit[i][j] = true;
					} else if (map[i][j] == '*') {
						fq.add(new Point(i, j));
					}
				}
			}
			
			bfs();
			
			if(ans ==Integer.MAX_VALUE) {
				System.out.println("IMPOSSIBLE");
			}else {
				System.out.println(ans);
			}
		}
	}

	static void bfs() {

		int count = 0;
		while (!mq.isEmpty()) {

			// 불이 번지고
			int size = fq.size();
			for (int i = 0; i < size; i++) {
				Point p = fq.poll();

				for (int j = 0; j < 4; j++) {
					int nx = p.x + dx[j];
					int ny = p.y + dy[j];

					if (!isRange(nx, ny)) {
						continue;
					}

					if (map[nx][ny] == '.') {
						fq.add(new Point(nx, ny));
						map[nx][ny] = '*';
					}
				}
			}

			// 상근이가 이동
			size = mq.size();
			for (int i = 0; i < size; i++) {
				Point p = mq.poll();
				for (int j = 0; j < 4; j++) {
					int nx = p.x + dx[j];
					int ny = p.y + dy[j];

					if (!isRange(nx, ny)) {
						ans = count + 1;
						return;
					}
					
					if(map[nx][ny] == '.' && !visit[nx][ny]) {
						mq.add(new Point(nx, ny));
						visit[nx][ny] = true;
					}
				}
			}
			count++;
		}
	}

	static boolean isRange(int x, int y) {
		if (x >= 0 && y >= 0 && x < r && y < c) {
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
}
