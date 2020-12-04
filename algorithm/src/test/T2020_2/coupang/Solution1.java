package test.T2020_2.coupang;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution1 {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(14)));
	}
	
	static int[] solution(int N) {
		int ansIdx = 0;
		int ansMax = 0;
		
		for (int i = 2; i < 10; i++) {
			ArrayList<Integer> list = new ArrayList<>();
			int num = N;
			
			while(num > 0) {
				list.add(num % i);
				num /= i;
			}
			
			int sum = 1;
			
			for (int j = 0; j < list.size(); j++) {
				int temp = list.get(j);
				if(temp == 0) {
					continue;
				}
				
				sum *= temp;
			}
			
			if(ansMax <= sum) {
				ansMax = sum;
				ansIdx = i;
			}
		}
		
		int[] ans = new int[2];
		ans[0] = ansIdx;
		ans[1] = ansMax;
		
		return ans;
	}
}
