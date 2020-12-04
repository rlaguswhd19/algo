package test.T2020_2.ebay;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_1 {
	static int N = 2;
	static int[][] simulation_data = { { 0, 3 }, { 2, 5 }, { 4, 2 }, { 5, 3 } };

	public static void main(String[] args) {
		System.out.println(solution());
	}

	static int solution() {
		int[] list = new int[N];
		Queue<Point> q = new LinkedList<>();
		int idx = 0;
		int time = 0;
		int ans = 0;

		while (true) {
			// 다음 창구
			int next = -1;
			
			// 다음사람이 없고 대기사람이 없으면 끝내기
			if (idx == simulation_data.length && q.isEmpty()) { // 더이상 대기사람이 없음
				break;
			}

			// 창구 시간 --
			for (int i = 0; i < N; i++) {
				if(list[i] != 0) {
					list[i]--;
				}
				
				if (list[i] == 0) {
					// 대기사람이 있으면 넣어주기
					if (!q.isEmpty()) {
						Point p = q.poll();
						ans += time - p.s; // 기다린 시간
						list[i] = p.t;
					} else { // 대기사람이 없는데 비어있는 창구가 있으면?
						next = i;
					}

					continue;
				}

			}
			
			// 다음사람이 있는 경우
			if (idx < simulation_data.length && time == simulation_data[idx][0]) {
				int s = simulation_data[idx][0]; // 받은 시간
				int t = simulation_data[idx][1]; // 걸리는 시간
				if (next == -1) {
					q.add(new Point(s, t));
				} else {
					list[next] = t;
				}

				idx++; // 다음사람
			}

			time++; // 시간은 1초씩 흐른다
		}

		return ans;
	}

	static class Point {
		int s, t;

		public Point(int s, int t) {
			super();
			this.s = s;
			this.t = t;
		}

		@Override
		public String toString() {
			return "Point [s=" + s + ", t=" + t + "]";
		}

	}

}
