package swexpert.D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution4613_러시아국기같은깃발 {
	static char[][] map;
	static int n, m, ans;
	static int[] list;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= t; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			map = new char[n][m];
			ans = Integer.MAX_VALUE;
			list = new int[2];
			
			for (int i = 0; i < n; i++) {
				map[i] = br.readLine().toCharArray();
			}
			
			com(0, 1);

			System.out.println("#" + tc + " " + ans);
		}
	}

	static void com(int idx, int target) {
		if (idx == 2) {
			check();
			return;
		} else if (target == n) {
			return;
		} else {
			list[idx] = target;
			com(idx + 1, target + 1);
			com(idx, target + 1);
		}
	}

	static void check() {
		int a = list[0];
		int b = list[1];
		char color = 'W';
		int cnt = 0;

		for (int i = 0; i < n; i++) {
			if (i == a) {
				color = 'B';
			} else if (i == b) {
				color = 'R';
			}

			for (int j = 0; j < m; j++) {
				if (color != map[i][j]) {
					cnt++;
				}
			}
		}
		ans = Math.min(cnt, ans);
	}
}
