package Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Test_3_못품 {
	static int[] sticker = { 12, 80, 14, 22, 100 };
	static boolean[] visit;
	static ArrayList<Point> arr;
	static int sum = 0;

	public static void main(String[] args) {
		arr = new ArrayList<>();
		visit = new boolean[sticker.length];
		for (int i = 0; i < sticker.length; i++) {
			arr.add(new Point(sticker[i], i));
		}

		Collections.sort(arr, new Comparator<Point>() {
			@Override
			public int compare(Point o1, Point o2) {
				if (o1.num < o2.num) {
					return 1;
				} else if (o1.num == o2.num) {
					if (o1.index > o2.index) {
						return 1;
					} else {
						return -1;
					}
				} else {
					return -1;
				}
			}
		});
		System.out.println(arr);
		cut();
		System.out.println(sum);
	}

	static void cut() {
		for (int i = 0; i < arr.size(); i++) {
			System.out.println(Arrays.toString(visit));
			Point p = arr.get(i);
			if (!visit[p.index]) {
				int cnt = 0;
				if (p.index - 1 >= 0) {
					visit[p.index - 1] = true;
				}
				if (p.index + 1 < arr.size()) {
					visit[p.index + 1] = true;
				}
				visit[p.index] = true;
				sum += p.num;
			}
		}
	}

	static class Point {
		int num;
		int index;

		public Point(int num, int index) {
			super();
			this.num = num;
			this.index = index;
		}

		@Override
		public String toString() {
			return "Point [num=" + num + ", index=" + index + "]";
		}
	}
}
