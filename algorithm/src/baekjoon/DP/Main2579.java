package baekjoon.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2579 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n + 1];
		int[] dp = new int[n + 1]; // 계단

		for (int i = 1; i < n + 1; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		if (n <= 2) {
			if (n == 1) {
				System.out.println(arr[1]);
				return;
			} else if (n == 2) {
				System.out.println(arr[2] + arr[1]);
				return;
			}
		} else {
			dp[1] = arr[1];
			dp[2] = arr[2] + arr[1];

			for (int i = 3; i < n + 1; i++) {
				dp[i] = Math.max(dp[i - 3] + arr[i - 1] + arr[i], dp[i - 2] + arr[i]);
			}
		}

		System.out.println(dp[n]);
	}
}
