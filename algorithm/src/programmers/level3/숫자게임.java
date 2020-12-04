package programmers.level3;

import java.util.Arrays;

public class 숫자게임 {

	public static void main(String[] args) {
		int[] A = { 5, 1, 3, 7 };
		int[] B = { 2, 2, 6, 8 };
		System.out.println(solution(A, B));
	}

	static int solution(int[] A, int[] B) {
		Arrays.sort(A);
		Arrays.sort(B);

		int Aidx = 0;
		int ans = 0;
		
		for (int i = 0; i < B.length; i++) {
			
			if(A[Aidx] < B[i]) {
				ans++;
				Aidx++;
			}
		}
		
		return ans;
	}
}
