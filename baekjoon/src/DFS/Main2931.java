package DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main2931 {
	static char[][] map;
	static int sx, sy, ex, ey, r, c;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int[][] visit;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		r = sc.nextInt();
		c = sc.nextInt();
		map = new char[r][c];
		visit = new int[r][c];
		sc.nextLine();
		for (int i = 0; i < r; i++) {
			String s = sc.nextLine();
			for (int j = 0; j < s.length(); j++) {
				map[i][j] = s.charAt(j);
				if (map[i][j] != '.') {
					visit[i][j]++;
					if (map[i][j] == 'M') {
						sx = i;
						sy = j;
					} else if (map[i][j] == 'Z') {
						ex = i;
						ey = j;
					} else if (map[i][j] == '+') {
						visit[i][j]++;
					}
				}
			}
		}


		visit[sx][sy]--;
		for (int i = 0; i < 4; i++) {
			int nx = sx + dx[i];
			int ny = sy + dy[i];
			if (isRange(nx, ny)) {
				if (map[nx][ny] != '.' && map[nx][ny] != 'Z') {
					dfs(i, nx, ny);
					break;
				}
			}
		}
		
	}

	static void dfs(int index, int x, int y) {
		visit[x][y]--;
		if (index == 0) { // 상 밑에서왔다.
			if (map[x][y] == '+' || map[x][y] == '|') {
				if (visit[x - 1][y] != 0) {
					dfs(0, x - 1, y);
				} else {
					check(0, x - 1, y);
					return;
				}
			} else if (map[x][y] == '1') {
				if (visit[x][y + 1] != 0) {
					dfs(3, x, y + 1);
				} else {
					check(3, x, y + 1);
					return;
				}
			} else if (map[x][y] == '4') {
				if (visit[x][y - 1] != 0) {
					dfs(2, x, y - 1);
				} else {
					check(2, x, y - 1);
					return;
				}
			}
		} else if (index == 1) { // 하 위에서왓다.
			if (map[x][y] == '+' || map[x][y] == '|') {
				if (visit[x + 1][y] != 0) {
					dfs(1, x + 1, y);
				} else {
					check(1, x + 1, y);
					return;
				}
			} else if (map[x][y] == '2') {
				if (visit[x][y + 1] != 0) {
					dfs(3, x, y + 1);
				} else {
					check(3, x, y + 1);
					return;
				}
			} else if (map[x][y] == '3') {
				if (visit[x][y - 1] != 0) {
					dfs(2, x, y - 1);
				} else {
					check(2, x, y - 1);
					return;
				}
			}
		} else if (index == 2) { // 좌 오른쪽에서왔다.
			if (map[x][y] == '+' || map[x][y] == '-') {
				if (visit[x][y - 1] != 0) {
					dfs(2, x, y - 1);
				} else {
					check(2, x, y - 1);
					return;
				}
			} else if (map[x][y] == '1') {
				if (visit[x + 1][y] != 0) {
					dfs(1, x + 1, y);
				} else {
					check(1, x + 1, y);
					return;
				}
			} else if (map[x][y] == '2') {
				if (visit[x - 1][y] != 0) {
					dfs(0, x - 1, y);
				} else {
					check(0, x - 1, y);
					return;
				}
			}
		} else if (index == 3) { // 우 왼쪽에서왔다.
			if (map[x][y] == '+' || map[x][y] == '-') {
				if (visit[x][y + 1] != 0) {
					dfs(3, x, y + 1);
				} else {
					check(3, x, y + 1);
					return;
				}
			} else if (map[x][y] == '3') {
				if (visit[x - 1][y] != 0) {
					dfs(0, x - 1, y);
				} else {
					check(0, x - 1, y);
					return;
				}
			} else if (map[x][y] == '4') {
				if (visit[x + 1][y] != 0) {
					dfs(1, x + 1, y);
				} else {
					check(1, x + 1, y);
					return;
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

	static void check(int index, int x, int y) {
		System.out.print((x + 1) + " " + (y + 1) + " ");
		ArrayList<Integer> temp = new ArrayList<>();
		int sum = 0;
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (isRange(nx, ny)) {
				if (map[nx][ny] != '.') {
					if(dec(i, nx, ny)) {
						temp.add(i+1);
						sum += i+1;
					}
				}
			}
		}
		Collections.sort(temp);
		if(sum == 7) {
			System.out.println('-');
		}else if(sum == 6) {
			System.out.println(1);
		}else if(sum == 5) {
			if(temp.get(0) == 1) {
				System.out.println(2);
			}else {
				System.out.println(4);
			}
		}else if(sum == 4) {
			System.out.println(3);
		}else if(sum == 3) {
			System.out.println('|');
		}else if(sum == 10) {
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

}
