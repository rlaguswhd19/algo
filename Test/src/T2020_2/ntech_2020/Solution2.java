package T2020_2.ntech_2020;

public class Solution2 {
	public static void main(String[] args) {
		int n = 3;
		solution(n);
	}

	static int solution(int n) {
		int[] dp = new int[n + 1];
		dp[0] = 1;
		dp[1] = 1;

		for (int i = 2; i < n + 1; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}
		
		return dp[n]; 
	}
}
