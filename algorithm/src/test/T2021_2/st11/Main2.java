package test.T2021_2.st11;

import java.util.Arrays;

public class Main2 {
	public static void main(String[] args) {
		String[] S = {"abz", "bca", "dfz"};
		System.out.println(Arrays.toString(solution(S)));
	}
	
	static int[] solution(String[] S) {
		int[] ans = {};
		
		String s = S[0];
		char[] arr;
		int[][] visit = new int[s.length()][26];
		int idx;
		
		for (int i = 0; i < visit.length; i++) {
			Arrays.fill(visit[i], -1);
		}
		
		
		
		for (int i = 0; i < S.length; i++) {
			s = S[i];
			
			arr = s.toCharArray();
			for (int j = 0; j < arr.length; j++) {
				idx = (int)arr[j] - 97;
				
				if(visit[j][idx] == -1) {
					visit[j][idx] = i;
				}else {
					ans = new int[3];
					ans[0] = visit[j][idx];
					ans[1] = i;
					ans[2] = j;
					break;
				}
			}
		}
		
		for (int i = 0; i < visit.length; i++) {
			System.out.println(Arrays.toString(visit[i]));
		}
		return ans;
	}
}
