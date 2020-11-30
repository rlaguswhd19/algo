package T2020_2.nhngodo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Solution3 {
	public static void main(String[] args) {
		String s = "aaabbcc";
		int n = 2;
		System.out.println(solution(s, n));
	}

	static int solution(String s, int n) {
		int[] cnt = new int[123];
		for (int i = 0; i < s.length(); i++) {
			cnt[s.charAt(i)]++;
		}

		ArrayList<Point> list = new ArrayList<>();
		for (int i = 97; i < cnt.length; i++) {
			if (cnt[i] == 0) {
				continue;
			}
			list.add(new Point(i, cnt[i]));
		}

		Collections.sort(list, new Comparator<Point>() {

			@Override
			public int compare(Point p1, Point p2) {
				return p2.cnt - p1.cnt;
			}
		});

		for (int i = list.size() - 1; i >= 0; i--) {
			Point p = list.get(i);
			if (p.cnt <= n) {
				n -= p.cnt;
				list.remove(list.size() - 1);
			} else {
				break;
			}
		}

		Point max = list.get(0);
		int idx = list.size() - 1;
		Point min = list.get(idx);

		while (true) {
			if (n < max.cnt) {
				max.cnt-=n;
			}
		}
	}

	static class Point {
		int idx, cnt;

		public Point(int idx, int cnt) {
			super();
			this.idx = idx;
			this.cnt = cnt;
		}

		@Override
		public String toString() {
			return "Point [idx=" + idx + ", cnt=" + cnt + "]";
		}
	}
}
