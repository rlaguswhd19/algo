package swexpert.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution1873_상호의배틀필드 {
	static char[][] map;
	static int h, w;
	static int d, x, y; // 전차 방향
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= t; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			h = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());

			map = new char[h][w];

			for (int i = 0; i < h; i++) {
				String s = br.readLine();
				for (int j = 0; j < s.length(); j++) {
					map[i][j] = s.charAt(j);
					if (map[i][j] == '<') {
						d = 3;
						x = i;
						y = j;
					} else if (map[i][j] == '>') {
						d = 1;
						x = i;
						y = j;
					} else if (map[i][j] == '^') {
						d = 2;
						x = i;
						y = j;
					} else if (map[i][j] == 'v') {
						d = 0;
						x = i;
						y = j;
					}
				}
			}

			int n = Integer.parseInt(br.readLine());

			String s = br.readLine();
			for (int i = 0; i < n; i++) {
				char action = s.charAt(i);

				int nx;
				int ny;

				switch (action) {
				case 'U':
					d = 2;
					nx = x + dx[d];
					ny = y + dy[d];

					if (!isRange(nx, ny)) {
						map[x][y] = '^';
						break;
					}

					if (map[nx][ny] == '.') {
						map[x][y] = '.';
						x = nx;
						y = ny;
					}

					map[x][y] = '^';

					break;
				case 'D':
					d = 0;
					nx = x + dx[d];
					ny = y + dy[d];

					if (!isRange(nx, ny)) {
						map[x][y] = 'v';
						break;
					}

					if (map[nx][ny] == '.') {
						map[x][y] = '.';
						x = nx;
						y = ny;
					}

					map[x][y] = 'v';

					break;
				case 'L':
					d = 3;
					nx = x + dx[d];
					ny = y + dy[d];

					if (!isRange(nx, ny)) {
						map[x][y] = '<';
						break;
					}

					if (map[nx][ny] == '.') {
						map[x][y] = '.';
						x = nx;
						y = ny;
					}

					map[x][y] = '<';

					break;
				case 'R':
					d = 1;
					nx = x + dx[d];
					ny = y + dy[d];

					if (!isRange(nx, ny)) {
						map[x][y] = '>';
						break;
					}

					if (map[nx][ny] == '.') {
						map[x][y] = '.';
						x = nx;
						y = ny;
					}

					map[x][y] = '>';

					break;
				case 'S':
					int sx = x;
					int sy = y;

					while (true) {

						// 다음칸
						sx += dx[d];
						sy += dy[d];

						if (!isRange(sx, sy)) {
							break;
						}

						if (map[sx][sy] == '*') {
							map[sx][sy] = '.';
							break;
						} else if (map[sx][sy] == '#') {
							break;
						}
					}

					break;
				}
			}

			System.out.print("#" + tc + " ");
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
		}
	}

	static boolean isRange(int nx, int ny) {
		if (nx < h && nx >= 0 && ny < w && ny >= 0) {
			return true;
		} else {
			return false;
		}
	}
}
