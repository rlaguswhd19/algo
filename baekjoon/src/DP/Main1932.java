package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1932 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int[][] map = new int[n][n];
		int[][] dp = new int[n][n];

		StringTokenizer st;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());

			int j = 0;
			while (st.hasMoreTokens()) {
				map[i][j++] = Integer.parseInt(st.nextToken());
			}
		}

		dp[0][0] = map[0][0];

		int idx = 1;

		for (int i = 1; i < n; i++) {

			for (int j = 0; j <= idx; j++) {
				if (j == 0) {
					dp[i][j] = dp[i - 1][j] + map[i][j];
				} else if (j == idx) {
					dp[i][j] = dp[i - 1][j - 1] + map[i][j];
				} else {
					dp[i][j] = Math.max(dp[i - 1][j] + map[i][j], dp[i - 1][j - 1] + map[i][j]);
				}
			}

			idx++;
		}

		int ans = 0;
		for (int i = 0; i < n; i++) {
			ans = Math.max(ans, dp[n - 1][i]);
		}

		System.out.println(ans);
	}
}
