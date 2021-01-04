package test.T2020_2.fursys;

public class Solution2 {
	public static void main(String[] args) {
		int[][] office = { { 1, 0, 0, 0 }, { 0, 0, 0, 1 }, { 0, 0, 1, 0 }, { 0, 1, 1, 0 } };
		int k = 2;
		System.out.println(solution(office, k));
	}

	static int solution(int[][] office, int k) {
		int len = office.length;
		int ans = 0;
		for (int i = 0; i <= len - k; i++) {
			for (int j = 0; j <= len - k; j++) {
				
				int cnt = 0;
				for (int r = i; r < i + k; r++) {
					for (int c = j; c < j + k; c++) {
						if(office[r][c] == 1) {
							cnt++;
						}
					}
				}
				
				ans = Math.max(ans, cnt);
			}
		}
		
		return ans;
	}
}
