package T2020_2.ntech_2019;

public class Solution1 {
	public static void main(String[] args) {
		int speed_limit = 60;
		int[][] cameras = { { 60, 1 }, { 130, 2 }, { 240, 4 }, { 432, 7 } };
		solution(speed_limit, cameras);
	}

	static void solution(int speed_limit, int[][] cameras) {
		int start = 0;
		int now = 0;
		int idx = 0;
		int ans = 0;

		while (idx < cameras.length) {
			int distance = cameras[idx][0] - start;
			int time = cameras[idx][1] - now;
			
			if(distance/time > speed_limit) {
				ans++;
			}
			
			start = cameras[idx][0];
			now = cameras[idx][1];

			idx++;
		}
		
		System.out.println(ans);
	}
}
