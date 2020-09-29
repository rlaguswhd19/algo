package T2020_2.st11;

public class Solution3 {
	public static void main(String[] args) {
		int[] A = { 2, 1, 4, 4 };
		System.out.println(solution(A));
	}

	static int solution(int[] A) {
		int[] cnt = new int[A.length + 1];

		for (int i = 0; i < A.length; i++) {
			cnt[A[i]]++;
		}

		int num = 1;
		int ans = 0;
		int idx = 1;
		
		while (num <= A.length) {
			
			if (cnt[idx] == 0) {
				idx++;
			} else {
				ans += Math.abs(num - idx);
				cnt[idx]--;
				num++;
				
				if (ans > 1000000000) {
					return -1;
				}
			}
		}

		return ans;
	}
}
