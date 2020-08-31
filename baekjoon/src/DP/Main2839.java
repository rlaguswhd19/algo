package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main2839 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int[] v = new int[2];
		v[0] = 3;
		v[1] = 5;

		int[] dp = new int[n + 1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;
		dp[1] = 0;
		dp[2] = 0;

		for (int i = 0; i < 2; i++) {
			int kg = v[i];
			for (int j = kg; j < n + 1; j++) {
				if (j % kg == 0) {
					dp[j] = Math.min(dp[j], dp[j - kg] + 1);
				} else {
					if (j - kg >= 3 && dp[j - kg] != Integer.MAX_VALUE) {
						dp[j] = Math.min(dp[j], dp[j - kg] + 1);
					}
				}
			}
		}
		System.out.println(dp[n] == Integer.MAX_VALUE ? -1 : dp[n]);
	}
}
