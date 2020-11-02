package Level3;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 셔틀버스 {
	public static void main(String[] args) {
//		int n = 10;
//		int t = 60;
//		int m = 45;
//		String[] timetable = { "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59",
//				"23:59", "23:59", "23:59", "23:59", "23:59", "23:59" };

		int n = 2;
		int t = 1;
		int m = 2;
		String[] timetable = { "09:00", "09:00", "09:00", "09:00" };
		System.out.println(solution(n, t, m, timetable));
	}

	static String solution(int n, int t, int m, String[] timetable) {
		int[] arr = new int[timetable.length];

		int time = 0;
		for (int i = 0; i < timetable.length; i++) {
			time = (Integer.parseInt(timetable[i].substring(0, 2)) * 60)
					+ Integer.parseInt(timetable[i].substring(3, 5));
			arr[i] = time;
		}

		Arrays.sort(arr);

		// n = 셔틀운행 횟수
		// t = 셔틀 운행 간경
		// m = 최대 탈 수 있는 사람

		Queue<Integer> q = new LinkedList<>();

		int now = 540; // 오전 9시
		int idx = 0;
		int cnt = 0; // 횟수
		while (cnt < n) {

			// 줄서기
			while (idx < arr.length) {
				if (now >= arr[idx]) {
					q.add(arr[idx++]);
				} else {
					break;
				}
			}

			// 버스 타기
			if (cnt == n - 1) { // 마지막 버스면?
				StringBuilder sb = new StringBuilder();
				if (q.size() < m) { // 이번에 탈 수 있으면 버스시간에 와서 타기
					make(sb, now);
					return sb.toString();
				} else { // 탈수가 없으면
					int last = 0;
					for (int i = 0; i < m; i++) {
						if (q.isEmpty()) {
							break;
						}

						last = q.poll();
					}

					last--;
					
					make(sb, last);
					
					return sb.toString();
				}
			} else {
				for (int i = 0; i < m; i++) { // m만큼 탈거야
					if (q.isEmpty()) { // 더이상 뺄게 없으면 끝내기 버스타고 출발~
						break;
					}

					q.poll();
				}
			}

			now += t; // 다음 시간으로 넘김
			cnt++;
		}

		return null;
	}
	
	static void make(StringBuilder sb, int time) {
		if(time/60 < 10) {
			sb.append(0);
			sb.append(time/60);
		}else {
			sb.append(time/60);
		}
		
		sb.append(":");
		
		if(time%60 < 10) {
			sb.append(0);
			sb.append(time%60);
		}else {
			sb.append(time%60);
		}
	}
}
