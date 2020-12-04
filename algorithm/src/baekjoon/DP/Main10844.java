package baekjoon.DP;

import java.io.InputStreamReader;
import java.util.Arrays;
import java.io.BufferedReader;
import java.io.IOException;

public class Main10844 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		long[][] dp = new long[n + 1][10];
		Arrays.fill(dp[1], 1);
		dp[1][0] = 0;

		for (int i = 2; i < n + 1; i++) {
			for (int j = 0; j < 10; j++) {
				if (dp[i - 1][j] == 0) {
					continue;
				}

				if (j == 0) {
					dp[i][j + 1] += dp[i - 1][j];
					dp[i][j + 1] %= 1000000000;
				} else if (j == 9) {
					dp[i][j - 1] += dp[i - 1][j];
					dp[i][j - 1] %= 1000000000;
				} else {
					dp[i][j + 1] += dp[i - 1][j];
					dp[i][j + 1] %= 1000000000;
					dp[i][j - 1] += dp[i - 1][j];
					dp[i][j - 1] %= 1000000000;
				}
			}
		}

		long sum = 0;
		for (int i = 0; i < 10; i++) {
			sum += dp[n][i];
			sum %= 1000000000;
		}
		
		System.out.println(sum);
	}
}
