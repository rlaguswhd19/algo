package baekjoon.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1003 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		Point[] dp = new Point[41];
		dp[0] = new Point(1, 0);
		dp[1] = new Point(0, 1);

		for (int i = 2; i < dp.length; i++) {
			Point p1 = dp[i-2];
			Point p2 = dp[i-1];
			
			dp[i] = new Point(p1.zero + p2.zero, p1.one + p2.one);
		}

		for (int tc = 1; tc <= t; tc++) {
			int n = Integer.parseInt(br.readLine());
			
			System.out.println(dp[n].zero + " " + dp[n].one);
		}
	}
	
	static class Point{
		int zero, one;

		public Point(int zero, int one) {
			super();
			this.zero = zero;
			this.one = one;
		}

		@Override
		public String toString() {
			return "Point [zero=" + zero + ", one=" + one + "]";
		}
	}
}
