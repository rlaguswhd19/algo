package T2020_2.nhngodo;

public class Solution1 {
	public static void main(String[] args) {
		int[] goods = {50,62,93};
		solution(goods);
	}

	static int solution(int[] goods) {
		int ans = 0;
		int sum = 0;
		for (int i = 0; i < goods.length; i++) {
			if (goods[i] >= 50) {
				ans += goods[i] - 10;
			} else {
				sum += goods[i];
				if (sum > 50) {
					ans += sum - 10;
					sum = 0;
				}
			}
		}
		
		ans += sum;
		return ans;
	}
}
