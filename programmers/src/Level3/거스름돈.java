package Level3;

import java.util.Arrays;

public class 거스름돈 {
	public static void main(String[] args) {
		int n = 10;
		int[] money = { 1, 2, 5 };
		System.out.println(solution(n, money));
	}

	static int solution(int n, int[] money) {
		int[] dp = new int[n + 1];
		dp[0] = 1;
		Arrays.sort(money);
		for (int i = money.length - 1; i >= 0; i--) {
			int m = money[i];

			for (int j = 1; j < n + 1; j++) {
				if (j - m >= 0) {
					dp[j] += dp[j - m];
					dp[j] %= 1000000007;
				}
			}
		}

		return dp[n];
	}
}
