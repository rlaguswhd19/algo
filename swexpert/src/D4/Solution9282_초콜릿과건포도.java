package D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution9282_초콜릿과건포도 {
	static int[][][][] dp;
	static int n, m;
	static int[][] map;
	static int[][] sum;
	static int ans;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= t; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			map = new int[n + 1][m + 1];
			dp = new int[n + 1][m + 1][n + 1][m + 1];
			sum = new int[n + 1][m + 1];

			for (int i = 1; i < n + 1; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 1; j < m + 1; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			setMap();

			ans = dfs(1, 1, n, m);
			
			System.out.println("#"+tc+" "+ans);
		}
	}

	static int dfs(int sx, int sy, int ex, int ey) {
		if (sx == ex && sy == ey) { // 한조각이다.
			return 0;
		}

		// 최대값이 아니면 최소값 넣어.
		if (dp[sx][sy][ex][ey] != Integer.MAX_VALUE) {
			return dp[sx][sy][ex][ey];
		}

		// 현재 건포도 양?
		int cnt = sum[ex][ey] - sum[sx - 1][ey] - sum[ex][sy - 1] + sum[sx - 1][sy - 1];
		int sum = Integer.MAX_VALUE;
		// 가로로 자르는 경우
		for (int i = sx; i < ex; i++) {
			int temp = dfs(sx, sy, i, ey) + dfs(i + 1, sy, ex, ey);
			sum = Math.min(sum, temp + cnt);
		}

		for (int i = sy; i < ey; i++) {
			int temp = dfs(sx, sy, ex, i) + dfs(sx, i + 1, ex, ey);
			sum = Math.min(sum, temp + cnt);
		}

		return dp[sx][sy][ex][ey] = sum;
	}

	static void setMap() {
		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < m + 1; j++) {
				sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + map[i][j];
			}
		}

		for (int i = 0; i < n + 1; i++) {
			for (int j = 0; j < m + 1; j++) {
				for (int j2 = 0; j2 < n + 1; j2++) {
					Arrays.fill(dp[i][j][j2], Integer.MAX_VALUE);
				}
			}
		}
	}
}
