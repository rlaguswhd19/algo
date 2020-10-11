package T2020_2.gabia;

public class Solution2 {
	public static void main(String[] args) {
		int a = 3000;
		int b = 5000;
		int budget = 23000;
		System.out.println(solution(a, b, budget));
	}

	static int solution(int a, int b, int budget) {
		int ans = 0;

		for (int i = a; i < budget + 1; i += a) {
			if((budget - i) % b == 0) {
				ans++;
			}
		}

		return ans;
	}
}
