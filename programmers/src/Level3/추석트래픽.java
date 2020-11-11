package Level3;

import java.util.Arrays;

public class 추석트래픽 {
	public static void main(String[] args) {
		String[] lines = { "2016-09-15 20:59:57.421 0.351s", "2016-09-15 20:59:58.233 1.181s",
				"2016-09-15 20:59:58.299 0.8s", "2016-09-15 20:59:58.688 1.041s", "2016-09-15 20:59:59.591 1.412s",
				"2016-09-15 21:00:00.464 1.466s", "2016-09-15 21:00:00.741 1.581s", "2016-09-15 21:00:00.748 2.31s",
				"2016-09-15 21:00:00.966 0.381s", "2016-09-15 21:00:02.066 2.62s" };

//		String[] lines = { "2016-09-15 01:00:04.002 2.0s", "2016-09-15 01:00:07.000 2s" };
//		String[] lines = { "2016-09-15 01:00:04.001 2.0s", "2016-09-15 01:00:07.000 2s" };
		System.out.println(solution(lines));
	}

	static int solution(String[] lines) {
		int ans = 0;
		int time = 0;
		int[] list_end = new int[lines.length];
		int[] list_start = new int[lines.length];

		for (int i = 0; i < lines.length; i++) {
			String s = lines[i];
			int hour = Integer.parseInt(s.substring(11, 13));
			int minute = Integer.parseInt(s.substring(14, 16));
			minute += hour * 60;
			time = minute * 60 * 1000;

			double second = Double.parseDouble(s.substring(17, 23)) * 1000;
			double later = Double.parseDouble(s.substring(24, s.length() - 1)) * 1000;
			
			time += (int) second;

			list_end[i] = time;
			list_start[i] = time - (int) later + 1;
		}

		Arrays.sort(list_start);


		int left = 0;
		int right = 0;
		int cnt = 0;
		int now = list_end[left];

		while (right < list_start.length) {
			int next = list_start[right];

			if (now + 999 < next) { // 끝나면
				ans = Math.max(ans, cnt); // 갯수 비교
				cnt--; // 맨 처음꺼 나가기
				left++; // 맨처음꺼 옮기기
				now = list_end[left];
			} else {
				right++;
				cnt++;
			}
		}

		ans = Math.max(ans, cnt);

		return ans;
	}
}
