package baekjoon.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1149 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int[][] arr = new int[3][n + 1];
		int[][] dp = new int[3][n + 1];

		for (int i = 1; i < n + 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				arr[j][i] = Integer.parseInt(st.nextToken());
			}
		}

		dp[0][1] = arr[0][1]; // R
		dp[1][1] = arr[1][1]; // G
		dp[2][1] = arr[2][1]; // B

		for (int i = 2; i <= n; i++) {
			dp[0][i] = Math.min(dp[1][i-1], dp[2][i-1]) + arr[0][i];
			dp[1][i] = Math.min(dp[0][i-1], dp[2][i-1]) + arr[1][i];
			dp[2][i] = Math.min(dp[0][i-1], dp[1][i-1]) + arr[2][i];
		}
		
		
		int ans = Integer.MAX_VALUE;

		for (int i = 0; i < 3; i++) {
			ans = Math.min(ans, dp[i][n]);
		}

		System.out.println(ans);
	}
}
