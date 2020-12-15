package programmers.level4;

public class 도둑질 {
	static int ans = 0;
	static int[] visit, dp;
	public static void main(String[] args) {
		int[] money = { 4, 2, 1, 1, 1, 3 };
		System.out.println(solution(money));
	}

	static int solution(int[] money) {
		visit = new int[money.length];
		dp = new int[money.length];
        
		// 처음에 첫번째것을 쓸것인지 아닌지를 결정하는 곳
        if(money[money.length -1 ] + money[1] < money[0] + money[2]) {
        	// 첫번쨰를 쓰는 경우
			dp[0] = money[0];
		    if (money[0] != 0) {
			    visit[0] = 1;
		    }
            
            dp[2] = money[0] + money[2];
            if(money[2] != 0){ // 첫번쨰가 0이아니면 세번째도 쓴다.
                visit[2] = 3;
            }else{
                visit[2] = 1;
            }
        }else{
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
				dp[i] = n1;
				visit[i] = Math.min(visit[i - 2], visit[i - 3]);
			}

			getMax(money, i);
		}

		return ans;
	}
	
	static void getMax(int[] money, int i) {
		if (ans < dp[i]) {
			if (i == dp.length - 1) {
				if (visit[i] == 1) { // 첫번째것만 선택한 경우
					ans = Math.max(ans, Math.max(dp[i] - money[i], dp[i] - money[0] + money[1]));
				} else if (visit[i] == 3) { // 세번째도 쓴 경우
					ans = Math.max(ans, dp[i] - Math.min(money[i], money[0]));
				} else {
					ans = dp[i];
				}
			} else {
				ans = dp[i];
			}
		}
	}
}
