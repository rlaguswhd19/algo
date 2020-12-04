package programmers.level4;

import java.util.Arrays;

public class 징검다리 {
	public static void main(String[] args) {
		int distance = 25;
		int[] rocks = { 2, 14, 11, 21, 17 };
		int n = 2;
		solution(distance, rocks, n);
	}

	static int solution(int distance, int[] rocks, int n) {
		// mid는 최소한의 거리, prev는 전의 돌, cnt는 지우는 갯수이다.
		// 문제의 접근 방법은 이 최솟값을 만들기 위해서 몇개의 돌을 지워야 하며 그것이 n보다 작으면 mid을 늘리고 n보다 크면 mid를 줄인다.
		// 이분탐색은 정답을 대조하여 범위를 줄여간다는 개념을 가지고 있어야 겠다. 이런 생각을 해내는게 너무 어려웠다.
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
