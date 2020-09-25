package T2020_2.ntech_2020;

public class Solution1 {
	public static void main(String[] args) {
		int[][] flowers = {{3, 4},{4, 5}, {6, 7}, {8, 10}};
		solution(flowers);
	}

	static int solution(int[][] flowers) {
		int ans = 0;
		int[] days = new int[366];

		for (int i = 0; i < flowers.length; i++) {
			for (int j = flowers[i][0]; j < flowers[i][1]; j++) {
				days[j]++;
			}
		}
		
		for (int i = 0; i < days.length; i++) {
			if(days[i] != 0) {
				ans++;
			}
		}
		
		return ans;
	}
}
