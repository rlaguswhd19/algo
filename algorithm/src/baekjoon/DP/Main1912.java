package baekjoon.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1912 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n + 1];

		StringTokenizer st = new StringTokenizer(br.readLine());
		int idx = 1;

		while (st.hasMoreTokens()) {
			arr[idx++] = Integer.parseInt(st.nextToken());
		}

		int[] dp = new int[n + 1];
		long ans = Long.MIN_VALUE;
		
		for (int i = 1; i < n + 1; i++) {
			if (dp[i - 1] < 0) {
				dp[i] = arr[i];
			} else {
				dp[i] = dp[i - 1] + arr[i];
			}
			
			ans = Math.max(ans, dp[i]);
		}
		
		System.out.println(ans);
	}
}
