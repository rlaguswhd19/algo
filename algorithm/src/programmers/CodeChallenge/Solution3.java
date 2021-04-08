package programmers.CodeChallenge;

import java.util.ArrayList;

public class Solution3 {
	public static void main(String[] args) {
		int[] a = { 1,2,3,4};
//		int[] a = { 0 };
		System.out.println(solution(a));
	}

	static int solution(int[] a) {
		int ans = 0;
		int[] visit = new int[a.length + 1];

		// 가장 짝수로 겹치는 애들은 빼야돼
		int num1 = 0, num2 = 0;
		
		for (int i = 0; i < a.length; i++) {
			visit[a[i]]++;
		}

		ArrayList<Integer> result = new ArrayList<>();
		int max = 0;

		for (int i = 0; i < visit.length; i++) {
			if (max < visit[i]) {
				result = new ArrayList<>();
				result.add(i);
				max = visit[i];
			} else if (max == visit[i]) {
				result.add(i);
			}
		}

		for (int i = 0; i < result.size(); i++) {
			int num = result.get(i);
			int sum = 0;
			
			for (int j = 0; j < a.length; j++) {
				num1 = a[j];
				j++;

				while (true) {
					if (j == a.length) { // 끝이면 마지막 숫자만 넣어주기
						break;
					}

					num2 = a[j];
					
					if(num1 == num2) {
						j++;
						continue;
					}
					
					if (num1 == num || num2 == num) {
						sum += 2;
						break;
					}

					j++;
				}
			}
			ans = Math.max(ans, sum);
		}

		return ans;
	}
}
