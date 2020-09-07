package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1463 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int[] dp = new int[n + 1];

		for (int i = 2; i < n + 1; i++) {
			int min = Integer.MAX_VALUE;

			if (i % 3 == 0) {
				min = Math.min(min, dp[i / 3]);
			}

			if (i % 2 == 0) {
				min = Math.min(min, dp[i / 2]);
			}

			if (i - 1 >= 1) {
				min = Math.min(min, dp[i - 1]);
			}

			dp[i] = min + 1;
		}
		
		System.out.println(dp[n]);
	}
}
