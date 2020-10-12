package SamSungTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main17136_2 {
	static int[][] map;
	static int ans;
	static int[] paper = { 0, 5, 5, 5, 5, 5 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st;
		map = new int[10][10];
		ans = Integer.MAX_VALUE;

		for (int i = 0; i < 10; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 10; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dfs(0, 0, 0);

		System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
	}

	static void dfs(int x, int y, int cnt) {
		if (x == 10 && y == 0) {
			ans = Math.min(ans, cnt);
			return;
		}

		if (cnt >= ans) {
			return;
		}

		int ny = y + 1;
		int nx = x;

		if (ny == 10) {
			ny = 0;
			nx = x + 1;
		}

		if (map[x][y] == 1) {
			int max = sizeCheck(x, y);
			
			for (int i = max; i >= 1; i--) {
				if (paper[i] <= 0) {
					continue;
				}

				fill(x, y, i, 0);
				paper[i]--;
				dfs(nx, ny, cnt + 1);
				paper[i]++;
				fill(x, y, i, 1);
			}
		} else {
			dfs(nx, ny, cnt);
		}

	}

	static void fill(int x, int y, int size, int num) {
		for (int i = x; i < x + size; i++) {
			for (int j = y; j < y + size; j++) {
				map[i][j] = num;
			}
		}
	}

	static int sizeCheck(int x, int y) {
		int size = 0;

		loop: for (int i = 1; i < 5; i++) { // 최대 길이를 생각해서 다 구하기
			if (!isOk(x + i, y + i)) {
				break;
			}

			for (int j = 0; j < i; j++) {
				if (map[x + j][y + i] != 1 || map[x + i][y + j] != 1) {
					break loop;
				}
			}
			
			if(map[x+i][y+i] != 1) {
				break loop;
			}

			size = i;
		}

		return size + 1;
	}

	static boolean isOk(int nx, int ny) {
		if (nx >= 0 && ny >= 0 && nx < 10 && ny < 10) {
			return true;
		} else {
			return false;
		}
	}
}
