package EstSoft;

public class Solution1 {
	static int[] A = {3,8,2,3,3,2};
	static int[] ans = new int[100001];
	static int max;

	public static void main(String[] args) {
		max = 0;
		for (int i = 0; i < A.length; i++) {
			ans[A[i]]++;
		}

		for (int i = ans.length - 1; i >= 0; i--) {
			if (ans[i] == i) {
				max = i;
				break;
			}
		}
		System.out.println(max);
	}
}
