package programmers.level4;

import java.util.Arrays;

public class 도둑질2 {
	static int ans = 0;
	static boolean[] visit;
	static int[] dp;

	public static void main(String[] args) {
		int[] money = { 4, 1, 1, 1, 1, 5 };
		System.out.println(solution(money));
	}

	static int solution(int[] money) {
		visit = new boolean[money.length];
		dp = new int[money.length];

		// 처음에 첫번째것을 쓸것인지 아닌지를 결정하는 곳
		if (money[money.length - 1] + money[1] < money[0] + money[2]) {
			// 첫번쨰를 쓰는 경우
			dp[0] = money[0];
			if (money[0] != 0) {
				visit[0] = true;
			}

			dp[2] = money[0] + money[2];
			visit[2] = visit[0];
		} else {
			// 첫번쨰를 안쓰는 경우
			dp[0] = 0;
			dp[1] = money[1];
			dp[2] = Math.max(money[1], money[2]);
		}

		for (int i = 0; i < 3; i++) {
			getMax(money, i);
		}

		for (int i = 3; i < dp.length; i++) {
			int n1 = dp[i - 2] + money[i];
			int n2 = dp[i - 3] + money[i];
			if (n1 > n2) {
				dp[i] = n1;
				visit[i] = visit[i - 2];
			} else if (n1 < n2) {
				dp[i] = n2;
				visit[i] = visit[i - 3];
			} else {
				if (!visit[i - 2]) {
					visit[i] = visit[i - 2];
				} else if (!visit[i - 3]) {
					visit[i] = visit[i - 3];
				} else {
					visit[i] = true;
				}

				dp[i] = n1;
			}

			getMax(money, i);
		}

		return ans;
	}

	static void getMax(int[] money, int i) {
		if (ans < dp[i]) {
			if (i == dp.length - 1) {
				if (visit[i]) { // 첫번째것을 선택한 경우
					return;
				} else {
					ans = dp[i];
				}
			} else {
				ans = dp[i];
			}
		}
	}
}
