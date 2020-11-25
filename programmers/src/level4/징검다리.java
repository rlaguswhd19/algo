package level4;

import java.util.Arrays;

public class 징검다리 {
	public static void main(String[] args) {
		int distance = 25;
		int[] rocks = { 2, 14, 11, 21, 17 };
		int n = 2;
		solution(distance, rocks, n);
	}

	static int solution(int distance, int[] rocks, int n) {

		Arrays.sort(rocks);
		int left = 1, mid = 0, right = distance;
		int cnt = 0;
		int prev = 0;

		while (left <= right) {
			mid = (left + right) / 2;
			cnt = 0;
			prev = 0;

			for (int i = 0; i < rocks.length; i++) {
				if (rocks[i] - prev < mid) {
					cnt++;
				} else {
					prev = rocks[i];
				}
			}
			
			if(distance - prev < mid) {
				cnt++;
			}
			
			if(cnt <= n) {
				left = mid + 1;
			}else {
				right = mid - 1;
			}

		}

		return left - 1;
	}
}
