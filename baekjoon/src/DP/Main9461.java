package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main9461 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		long[] dp = new long[100];
		dp[0] = 1;
		dp[1] = 1;
		dp[2] = 1;
		
		for (int i = 3; i < 100; i++) {
			dp[i] = dp[i - 3] + dp[i - 2];
		}
		
		int n = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(br.readLine());
			System.out.println(dp[num - 1]);
		}
	}
}
