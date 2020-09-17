package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main11053 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n + 1];
		int ans = 0;

		int idx = 1;
		StringTokenizer st = new StringTokenizer(br.readLine());
		while (st.hasMoreTokens()) {
			arr[idx++] = Integer.parseInt(st.nextToken());
		}

		int[] dp = new int[n + 1];
		
		for (int i = 1; i < n + 1; i++) {
			int max = 0;
			
			for (int j = 1; j < i; j++) {
				if(arr[i] > arr[j]) {
					max = Math.max(max, dp[j]);
				}
			}
			
			dp[i] = max + 1;
			ans = Math.max(dp[i], ans);
		}

		System.out.println(ans);
	}
}
