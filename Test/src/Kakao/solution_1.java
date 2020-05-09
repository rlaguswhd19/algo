package Kakao;

public class solution_1 {
	static Point[] phone;
	static Point left, right;
	static StringBuilder sb;

	public static void main(String[] args) {
		String hand = "left";
		int[] numbers = { 1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5 };
		phone = new Point[10];
		sb = new StringBuilder();

		// 시작위치
		left = new Point(3, 0);
		right = new Point(3, 2);

		int x = 0;
		int y = 0;
		phone[0] = new Point(3, 1);

		for (int i = 1; i < 10; i++) {
			phone[i] = new Point(x, y);
			y++;
			if (y == 3) {
				x++;
				y = 0;
			}
		}

		for (int i = 0; i < numbers.length; i++) {
			distance(numbers[i], hand);
		}

		System.out.println(sb.toString());
	}

	static void distance(int click, String hand) {
		int x = 0;
		int y = 0;
		int d = 0;
		
		if (click == 1 || click == 4 || click == 7) {
			sb.append("L");
			left = phone[click];
		} else if (click == 3 || click == 6 || click == 9) {
			sb.append("R");
			right = phone[click];
		} else {
			Point goal = phone[click];

			int ld = 0;
			int rd = 0;

			ld = Math.abs(goal.x - left.x) + Math.abs(goal.y - left.y);
			rd = Math.abs(goal.x - right.x) + Math.abs(goal.y - right.y);

			if (ld > rd) {
				sb.append("R");
				right = phone[click];
			} else if (rd > ld) {
				sb.append("L");
				left = phone[click];
			} else {
				if (hand.equals("right")) {
					sb.append("R");
					right = phone[click];
				} else {
					sb.append("L");
					left = phone[click];
				}
			}

		}

		d = x + y;
	}

	static class Point {
		int x, y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "Point [x=" + x + ", y=" + y + "]";
		}
	}
}
