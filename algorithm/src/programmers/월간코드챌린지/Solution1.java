package programmers.월간코드챌린지;

public class Solution1 {
	public static void main(String[] args) {
		int[] a = { 1, 2, 3, 4 };
		int[] b = { -3, -1, 0, 2 };
		solution(a, b);
	}

	static int solution(int[] a, int[] b) {
		int ans = 0;
		for (int i = 0; i < b.length; i++) {
			ans += a[i]*b[i];
		}
		
		return ans;
	}
}
