package test.T2020_2.ntech_2019;

import java.util.Arrays;

public class Solution3 {
	public static void main(String[] args) {
		int n = 100000000;
		System.out.println(solution(n));
	}

	static int solution(int n) {
		int[] arr = new int[n + 1];
		Arrays.fill(arr, 1);
		int ans = 1;
		
		for (int i = 2; i < arr.length; i++) {
			for (int j = i; j < arr.length; j += i) {
				arr[i] *= -1;
			}
			
			if(arr[i] == 1) {
				ans++;
			}
		}

		return ans;
	}
}
