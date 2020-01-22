package DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main2931_1 {
	static char[][] map;
	static int sx, sy, ex, ey, r, c;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static boolean[][] visit;
	static Queue<point> q;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		r = sc.nextInt();
		c = sc.nextInt();
		map = new char[r][c];
		visit = new boolean[r][c];
		sc.nextLine();
		for (int i = 0; i < r; i++) {
			String s = sc.nextLine();
			for (int j = 0; j < s.length(); j++) {
				map[i][j] = s.charAt(j);
				if (map[i][j] != '.') {
					if (map[i][j] == 'M') {
						sx = i;
						sy = j;
					} else if (map[i][j] == 'Z') {
						ex = i;
						ey = j;
					}
				}
			}
		}

		visit[sx][sy] = true;
		for (int i = 0; i < 4; i++) {
			int nx = sx + dx[i];
			int ny = sy + dy[i];
			if (isRange(nx, ny)) {
				if (map[nx][ny] != '.' && map[nx][ny] != 'Z') {
					q = new LinkedList<>();
					q.add(new point(nx, ny));
					bfs(nx, ny);
					break;
				}
			}
		}
	}

	static void bfs(int x, int y) {

		loop: while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				point p = q.poll();
				visit[p.x][p.y] = true;

				if (map[p.x][p.y] == '|') {
					if (!visit[p.x - 1][p.y]) {
						q.add(new point(p.x - 1, p.y));
					}
					if (!visit[p.x + 1][p.y]) {
						q.add(new point(p.x + 1, p.y));
					}
				} else if (map[p.x][p.y] == '+') {
					for (int j = 0; j < 4; j++) {
						int nx = p.x + dx[j];
						int ny = p.y + dy[j];
						if (!visit[nx][ny]) {
							q.add(new point(nx, ny));
						}
					}
				} else if (map[p.x][p.y] == '-') {
					if (!visit[p.x][p.y - 1]) {
						q.add(new point(p.x, p.y - 1));
					}
					if (!visit[p.x][p.y + 1]) {
						q.add(new point(p.x, p.y + 1));
					}
				} else if (map[p.x][p.y] == '1') {
					if (!visit[p.x][p.y + 1]) {
						q.add(new point(p.x, p.y + 1));
					}
					if (!visit[p.x + 1][p.y]) {
						q.add(new point(p.x + 1, p.y));
					}
				} else if (map[p.x][p.y] == '2') {
					if (!visit[p.x - 1][p.y]) {
						q.add(new point(p.x - 1, p.y));
					}
					if (!visit[p.x][p.y + 1]) {
						q.add(new point(p.x, p.y + 1));
					}
				} else if (map[p.x][p.y] == '3') {
					if (!visit[p.x - 1][p.y]) {
						q.add(new point(p.x - 1, p.y));
					}
					if (!visit[p.x][p.y - 1]) {
						q.add(new point(p.x, p.y - 1));
					}
				} else if (map[p.x][p.y] == '4') {
					if (!visit[p.x + 1][p.y]) {
						q.add(new point(p.x + 1, p.y));
					}
					if (!visit[p.x][p.y - 1]) {
						q.add(new point(p.x, p.y - 1));
					}
				} else if (map[p.x][p.y] == '.') {
					check(p.x, p.y);
					break loop;
				}
			}
		}
	}

	static boolean dec(int index, int x, int y) {
		switch (index) {
		case 0:
			if (map[x][y] == '+' || map[x][y] == '|' || map[x][y] == '1' || map[x][y] == '4') {
				return true;
			}
			return false;
		case 1:
			if (map[x][y] == '+' || map[x][y] == '|' || map[x][y] == '2' || map[x][y] == '3') {
				return true;
			}
			return false;
		case 2:
			if (map[x][y] == '+' || map[x][y] == '-' || map[x][y] == '1' || map[x][y] == '2') {
				return true;
			}
			return false;
		case 3:
			if (map[x][y] == '+' || map[x][y] == '-' || map[x][y] == '3' || map[x][y] == '4') {
				return true;
			}
			return false;
		}
		return false;
	}

	static void check(int x, int y) {
		System.out.print((x + 1) + " " + (y + 1) + " ");
		ArrayList<Integer> temp = new ArrayList<>();
		int sum = 0;
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (isRange(nx, ny)) {
				if (map[nx][ny] != '.') {
					if (dec(i, nx, ny)) {
						temp.add(i + 1);
						sum += i + 1;
					}
				}
			}
		}
		Collections.sort(temp);
		if (sum == 7) {
			System.out.println('-');
		} else if (sum == 6) {
			System.out.println(1);
		} else if (sum == 5) {
			if (temp.get(0) == 1) {
				System.out.println(2);
			} else {
				System.out.println(4);
			}
		} else if (sum == 4) {
			System.out.println(3);
		} else if (sum == 3) {
			System.out.println('|');
		} else if (sum == 10) {
			System.out.println('+');
		}
	}

	static boolean isRange(int x, int y) {
		if (x < r && y < c && x >= 0 && y >= 0) {
			return true;
		} else {
			return false;
		}
	}

	static class point {
		int x, y;

		public point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "point [x=" + x + ", y=" + y + "]";
		}
		
	}
}
