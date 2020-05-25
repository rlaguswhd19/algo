package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution3282_Knapsack {
	static int n, k;
	static int[][] dp;
	static Stuff[] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= t; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			n = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			dp = new int[n + 1][k + 1];
			arr = new Stuff[n + 1];

			for (int i = 1; i <= n; i++) {
				st = new StringTokenizer(br.readLine());

				int v = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());

				arr[i] = new Stuff(v, c);
			}

			for (int i = 1; i < n + 1; i++) {
				Stuff stuff = arr[i];

				for (int j = 1; j < k + 1; j++) {
					if (stuff.v > j) {
						dp[i][j] = dp[i - 1][j];
					} else {
						dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - stuff.v] + stuff.c);
					}
				}
			}

			System.out.println("#" + tc + " " + dp[n][k]);
		}
	}

	static class Stuff {
		int v, c;

		public Stuff(int v, int c) {
			super();
			this.v = v;
			this.c = c;
		}

		@Override
		public String toString() {
			return "Stuff [v=" + v + ", c=" + c + "]";
		}
	}
}
