package T2019_2.EstSoft;

public class Solution2 {
	static int[] A;
	static int[][] ans = new int[2][200001];
	static int max = -1;

	public static void main(String[] args) {
		A = new int[200001];

		for (int i = 0; i < A.length; i++) {
			A[i] = (int) (Math.random() * 100000000 + 1);
		}
		
		for (int i = 0; i < A.length; i++) {
			check(A[i]);
		}
		
		System.out.println(max);
	}

	static void check(int num) {
		String s = "" + num;

		char[] temp = s.toCharArray();
		int sum = 0;
		for (int i = 0; i < temp.length; i++) {
			sum += temp[i] - '0';
		}

		// 큰게 바뀔때
		if (ans[0][sum] < num) {
			ans[1][sum] = ans[0][sum];
			ans[0][sum] = num;
			// 밀릴때 처음 들어온게 아니라면
			if (ans[1][sum] != 0) {
				max = Math.max(max, ans[0][sum] + ans[1][sum]);
			}
		} else { // 작거나 같으면 밑에로 들어가

			// 작은것이 바뀔때 갱신될때
			if (ans[1][sum] < num) {
				ans[1][sum] = num;
				max = Math.max(max, ans[0][sum] + ans[1][sum]);
			}
		}
	}
}
