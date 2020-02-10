package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main2206 {
	static int n, m;
	static int[][] map;
	static Queue<Point> q;
	static boolean[][] visit1;
	static boolean[][] visit2;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int ans = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		visit1 = new boolean[n][m];
		visit2 = new boolean[n][m];

		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = s.charAt(j) - '0';
			}
		}

		bfs();
		if (ans == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(ans);
		}
	}

	static void bfs() {
		q = new LinkedList<>();

		q.add(new Point(0, 0, 1));
		visit1[0][0] = true; //드릴 안쓴애들
		visit2[0][0] = true; //드릴 쓴애들

		int count = 1;
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				Point p = q.poll();
				if (p.x == n - 1 && p.y == m - 1) {
					ans = count;
					return;
				}

				for (int j = 0; j < 4; j++) {
					int nx = p.x + dx[j];
					int ny = p.y + dy[j];

					if (!isRange(nx, ny)) {
						continue;
					}
					
					//드릴을 안썻고 이제 쓸것임
					if (map[nx][ny] == 1) {
						if(p.one == 1) {
							//안갔니?
							if(!visit2[nx][ny]) {
								//쓰고 간것으로 처리
								visit2[nx][ny] = true;
								q.add(new Point(nx, ny, p.one-1));
							}
						}
					} else {
						if(p.one == 1) {
							//아직안쓸때
							if(!visit1[nx][ny]) { //안왔니?
								//안쓴채로 온걸로 처리
								visit1[nx][ny] = true;
								q.add(new Point(nx, ny, p.one));
							}
						}else {
							//썼니?
							if(!visit2[nx][ny]) {
								//쓴놈이 온걸로 처리
								visit2[nx][ny] = true;
								q.add(new Point(nx, ny, p.one));
							}
						}
					}
				}
			}
			count++;
		}
	}

	static boolean isRange(int x, int y) {
		if (x >= 0 && y >= 0 && x < n && y < m) {
			return true;
		} else {
			return false;
		}
	}

	static class Point {
		int x, y, one;

		public Point(int x, int y, int one) {
			super();
			this.x = x;
			this.y = y;
			this.one = one;
		}

		@Override
		public String toString() {
			return "Point [x=" + x + ", y=" + y + ", one=" + one + "]";
		}
	}
}
