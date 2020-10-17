package SamSungTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main13460 {
	static int n, m, ans = -1;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 }; // 위 아래 오른쪽 왼쪽
	static boolean[][][][] visit; // 파랑, 빨강
	static boolean[] over;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		char[][] map = new char[n][m];
		visit = new boolean[n][m][n][m];

		String s = "";
		Point red = null, blue = null;
		for (int i = 0; i < n; i++) {
			s = br.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = s.charAt(j);
				if (map[i][j] == 'R') {
					red = new Point(i, j);
				} else if (map[i][j] == 'B') {
					blue = new Point(i, j);
				}
			}
		}

		bfs(new Game(map, blue, red));

		System.out.println(ans);
	}

	static void bfs(Game game) {
		Queue<Game> q = new LinkedList<>();

		q.add(game);
		Point b = game.blue;
		Point r = game.red;
		visit[b.x][b.y][r.x][r.y] = true;
		int cnt = 0;
		loop: while (cnt < 10) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				Game g = q.poll();
				
				for (int d = 0; d < 4; d++) { // 중력 방향
					char[][] next = copy(g.map); // 복사

					b = g.blue;
					r = g.red;

					Game ng = move(next, b, r, d);
					
					if(ng.red.x == r.x && ng.blue.x == b.x && ng.red.y == r.y && ng.blue.y == b.y) {
						continue;
					}
					
					if (!over[0] && !over[1]) { // 공이 하나도 안들어감
						if (!visit[ng.blue.x][ng.blue.y][ng.red.x][ng.red.y]) {
							q.add(ng);
						}
					} else { // 공이 하나라도 들어감
						if (over[0] && !over[1]) {
							ans = cnt + 1;
							break loop;
						}
					}
				}
			}

			cnt++;
		}
	}

	static char[][] copy(char[][] map) {
		char[][] temp = new char[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				char c = map[i][j];
				temp[i][j] = c;
			}
		}

		return temp;
	}

	static Game move(char[][] map, Point b, Point r, int d) {
		boolean RED = false;
		// 먼저 움직일 아이를 찾아야 한다.
		if (d == 0) { // 위 x가 작아야 먼저감
			if (b.x >= r.x) {
				RED = true;
			}
		} else if (d == 1) { // 아래 x가 커야 먼저감
			if (b.x <= r.x) {
				RED = true;
			}
		} else if (d == 2) { // 오른쪽 y가 커야 먼저감
			if (b.y <= r.y) {
				RED = true;
			}
		} else { // 왼쪽 y가 작아야 먼저감
			if (b.y >= r.y) {
				RED = true;
			}
		}

		Point nr = null;
		Point nb = null;
		over = new boolean[2]; // 빨강 / 파랑

		if (RED) {
			int nx = r.x + dx[d];
			int ny = r.y + dy[d];

			while (true) {
				if (map[nx][ny] != '.') {
					map[r.x][r.y] = '.';
					
					if (map[nx][ny] == 'O') {
						over[0] = true;
					} else {
						nx -= dx[d];
						ny -= dy[d];
						map[nx][ny] = 'R';
					}
					break;
				}

				nx += dx[d];
				ny += dy[d];
			}

			nr = new Point(nx, ny);

			nx = b.x + dx[d];
			ny = b.y + dy[d];

			while (true) {
				if (map[nx][ny] != '.') {
					map[b.x][b.y] = '.';
					if (map[nx][ny] == 'O') {
						over[1] = true;
					} else {
						nx -= dx[d];
						ny -= dy[d];
						map[nx][ny] = 'B';
					}
					break;
				}

				nx += dx[d];
				ny += dy[d];
			}

			nb = new Point(nx, ny);
		} else {
			int nx = b.x + dx[d];
			int ny = b.y + dy[d];

			while (true) {
				if (map[nx][ny] != '.') {
					map[b.x][b.y] = '.';
					if (map[nx][ny] == 'O') {
						over[1] = true;
					} else {
						nx -= dx[d];
						ny -= dy[d];
						map[nx][ny] = 'B';
					}
					break;
				}

				nx += dx[d];
				ny += dy[d];
			}

			nb = new Point(nx, ny);

			nx = r.x + dx[d];
			ny = r.y + dy[d];

			while (true) {
				if (map[nx][ny] != '.') {
					map[r.x][r.y] = '.';
					if (map[nx][ny] == 'O') {
						over[0] = true;
					} else {
						nx -= dx[d];
						ny -= dy[d];
						map[nx][ny] = 'R';
					}
					break;
				}

				nx += dx[d];
				ny += dy[d];
			}

			nr = new Point(nx, ny);
		}

		return new Game(map, nb, nr);
	}

	static boolean isOk(int nx, int ny) {
		if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
			return true;
		} else {
			return false;
		}
	}

	static class Game {
		char[][] map;
		Point blue, red;

		public Game(char[][] map, Point blue, Point red) {
			super();
			this.map = map;
			this.blue = blue;
			this.red = red;
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
