package programmers.level4;

public class 올바른괄호의갯수 {
	public static void main(String[] args) {
		int n = 4;
		System.out.println(solution(n));
	}

	static int solution(int n) {
		if (n < 3) {
			return n;
		}

		int[] dp = new int[n + 1];
		dp[1] = 1;
		dp[2] = 2;

		for (int i = 3; i < dp.length; i++) {
			for (int j = 0; j < i; j++) {
				dp[i] += dp[j] * dp[i - j];
			}

			dp[i] += dp[i - 1];
		}

		return dp[n];
	}
}
