package swexpert.D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution1868_파핑파핑지뢰찾기 {
	static char[][] map;
	static int[] dx = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int[] dy = { 0, 1, 1, 1, 0, -1, -1, -1 };
	static int ans;
	static int n;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= t; tc++) {
			n = Integer.parseInt(br.readLine());
			map = new char[n][n];
			ans = 0;

			for (int i = 0; i < n; i++) {
				map[i] = br.readLine().toCharArray();
			}

			// 우선적으로 0을 클릭?
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (map[i][j] == '.') {

						// 주위에 지뢰가 있냐?
						if (check(i, j)) {
							// 없으면 터트리기
							change(i, j);
							ans++;
						}
					}
				}
			}

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (map[i][j] == '.') {
						ans++;
					}
				}
			}

			System.out.println("#" + tc + " " + ans);
		}
	}

	static boolean check(int x, int y) {
		int cnt = 0;
		ArrayList<Integer> temp = new ArrayList<>();

		for (int i = 0; i < 8; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (!isOk(nx, ny)) {
				continue;
			}

			if (map[nx][ny] == '*') {
				cnt++;
			}
		}

		if (cnt != 0) {
			return false;
		} else {
			return true;
		}

	}

	static void change(int x, int y) {
		int cnt = 0;
		ArrayList<Integer> arr = new ArrayList<>();

		for (int i = 0; i < 8; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (!isOk(nx, ny)) {
				continue;
			}

			if (map[nx][ny] == '*') {
				cnt++;
			} else if (map[nx][ny] == '.') {
				arr.add(i);
			}
		}

		map[x][y] = (char) ('0' + cnt);

		if (cnt != 0) {
			return;
		}

		for (int i = 0; i < arr.size(); i++) {
			int idx = arr.get(i);
			int nx = x + dx[idx];
			int ny = y + dy[idx];

			change(nx, ny);
		}
	}

	static boolean isOk(int nx, int ny) {
		if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
			return true;
		} else {
			return false;
		}
	}
}
