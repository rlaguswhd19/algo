package programmers.level3;

import java.util.Arrays;

public class 최고의집합 {
	public static void main(String[] args) {
		int n = 2;
		int s = 9;
		System.out.println(Arrays.toString(solution(n, s)));
	}
	static int[] solution(int n, int s) {
		int[] ans = new int[n];
		int res = s / n;
		if(res == 0) {
			ans = new int[1];
			ans[0] = -1;
			return ans;
		}
		
		if (s % n == 0) {
			for (int i = 0; i < n; i++) {
				ans[i] = res;
			}
		} else {
			int temp = s % n;
			for (int i = 0; i < n; i++) {
				ans[i] = res;
			}
			
			for (int i = n - 1; i > n - 1 - temp; i--) {
				ans[i] += 1;
			}
		}
        
		return ans;
	}
}
