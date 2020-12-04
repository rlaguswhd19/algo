package baekjoon.SamSungTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main14503 {
	static int n, m;
	static int r, c, d;
	static int[][] map;
	static Queue<Point> q;
	static int[] dx = { 0, -1, 0, 1 };
	static int[] dy = { -1, 0, 1, 0 }; //서북동남
	static int ans = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];

		st = new StringTokenizer(br.readLine());

		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		bfs();
		System.out.println();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print(map[i][j]+" ");
			}System.out.println();
		}
		
		System.out.println(ans);
	}

	static void bfs() {
		q = new LinkedList<>();

		q.add(new Point(r, c, d));
		int c = 2;
		loop: while (!q.isEmpty()) {
			System.out.println(q);
			Point p = q.poll();

			// 현재 위치를 청소한다.
			if(map[p.x][p.y] == 0) {
				map[p.x][p.y] = c;
				ans++;
				c++;
			}

			int dir = p.dir;
			int nx = p.x + dx[dir];
			int ny = p.y + dy[dir];
			// 벽이 아니고 청소를 안했으면
			if (map[nx][ny] == 0) {

				dir--;
				if (dir == -1) {
					dir = 3;
				}

				q.add(new Point(nx, ny, dir));

			} else {

				// 4방향 검사하기
				int cnt = 0;
				for (int i = 0; i < 4; i++) {
					nx = p.x + dx[i];
					ny = p.y + dy[i];

					// 청소를 안했으면
					if (map[nx][ny] == 0) {
						break;
					}
					
					cnt++;
				}

				if (cnt == 4) { // 4방향 청소를 했다면
					int temp = dir;
					// 한칸 후진하기
					dir--;
					if (dir == -1) {
						dir = 3;
					}
					
					nx = p.x+dx[dir];
					ny = p.y+dy[dir];
					if(map[nx][ny] == 1) { // 벽이면 동작금지
						break loop;
					}else { // 벽이아니면 방향 유지후 뒤로 한칸이동
						q.add(new Point(nx, ny, temp));
					}
				} else { // 회전하고 넣기

					dir--;
					if (dir == -1) {
						dir = 3;
					}

					q.add(new Point(p.x, p.y, dir));
				}
			}
			
//			for (int i = 0; i < n; i++) {
//				for (int j = 0; j < m; j++) {
//					System.out.print(map[i][j]+" ");
//				}System.out.println();
//			}
		}
	}

	static class Point {
		int x, y, dir;

		public Point(int x, int y, int dir) {
			super();
			this.x = x;
			this.y = y;
			this.dir = dir;
		}

		@Override
		public String toString() {
			return "Point [x=" + x + ", y=" + y + ", dir=" + dir + "]";
		}
	}

}
