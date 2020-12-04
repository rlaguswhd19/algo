package baekjoon.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2579_2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[] step = new int[n + 1];

		for (int i = 1; i < n + 1; i++) {
			step[i] = Integer.parseInt(br.readLine());
		}

		int[] dp = new int[n + 1];
		if (n == 1) {
			System.out.println(step[1]);
		} else if (n == 2) {
			System.out.println(step[1] + step[2]);
		} else {
			dp[1] = step[1];
			dp[2] = step[1] + step[2];
			for (int i = 3; i < n + 1; i++) {
				dp[i] = Math.max(dp[i - 3] + step[i - 1], dp[i - 2]) + step[i];
			}

			System.out.println(dp[n]);
		}

	}
}
