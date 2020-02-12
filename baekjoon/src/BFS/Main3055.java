package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main3055 {
	static char[][] map;
	static int r, c;
	static ArrayList<Point> w;
	static Queue<Point> bq;
	static Queue<Point> wq;
	static Point start;
	static boolean[][] visit;
	static int ans = Integer.MAX_VALUE;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		map = new char[r][c];
		visit = new boolean[r][c];
		w = new ArrayList<>();

		for (int i = 0; i < r; i++) {
			String s = br.readLine();
			for (int j = 0; j < c; j++) {
				map[i][j] = s.charAt(j);
				if (map[i][j] == 'S') {
					start = new Point(i, j);
				} else if (map[i][j] == '*') {
					w.add(new Point(i, j));
				}
			}
		}
		bfs();
		if(ans == Integer.MAX_VALUE) {
			System.out.println("KAKTUS");
		}else {
			System.out.println(ans);
		}
	}

	static void bfs() {
		bq = new LinkedList<>();
		wq = new LinkedList<>();

		bq.add(start);
		visit[start.x][start.y] = true;

		for (int i = 0; i < w.size(); i++) {
			Point p = w.get(i);
			wq.add(p);
			visit[p.x][p.y] = true;
		}

		int count = 0;
		while (!bq.isEmpty()) {
			int wsize = wq.size();
			int bsize = bq.size();

			for (int i = 0; i < wsize; i++) {
				Point p = wq.poll();
				for (int j = 0; j < 4; j++) {
					int nx = p.x + dx[j];
					int ny = p.y + dy[j];

					if (!isRange(nx, ny)) {
						continue;
					}

					if (!visit[nx][ny] && map[nx][ny] == '.') {
						wq.add(new Point(nx, ny));
						visit[nx][ny] = true;
					}
				}
			}

			for (int i = 0; i < bsize; i++) {
				Point p = bq.poll();
				for (int j = 0; j < 4; j++) {
					int nx = p.x + dx[j];
					int ny = p.y + dy[j];

					if (!isRange(nx, ny)) {
						continue;
					}

					if (map[nx][ny] == 'D') {
						ans = count + 1;
						return;
					}

					if (!visit[nx][ny] && map[nx][ny] == '.') {
						bq.add(new Point(nx, ny));
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
