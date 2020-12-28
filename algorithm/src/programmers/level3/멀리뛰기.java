package programmers.level3;

public class 멀리뛰기 {
	public static void main(String[] args) {
		int n = 4;
		System.out.println(solution(n));
	}

	static long solution(int n) {
		long[] dp = new long[n + 1];
		if (n == 1) {
			return 1;
		} else if (n == 2) {
			return 2;
		} else {
			dp[1] = 1;
			dp[2] = 2;
			for (int i = 3; i < n + 1; i++) {
				dp[i] = dp[i - 1] + dp[i - 2];
				dp[i] %= 1234567;
			}
		}

		return dp[n];
	}
}
