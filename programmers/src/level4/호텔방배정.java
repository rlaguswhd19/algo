package level4;

import java.util.ArrayList;

public class 호텔방배정 {
	static ArrayList<Point> list = new ArrayList<>();
	static long[] ans;
	static boolean isOk;

	public static void main(String[] args) {
		long k = 10;
		long[] room_number = { 5, 6, 100, 3000, 99 };
		solution(k, room_number);
	}

	static long[] solution(long k, long[] room_number) {
		// 범위를 넣어줘서 검색하기
		list = new ArrayList<>();
		ans = new long[room_number.length];

		// first set
		long first = room_number[0];
		list.add(new Point(first, first + 1));
		ans[0] = first;

		// 방번호를 돌면서
		for (int i = 1; i < room_number.length; i++) {
			long num = room_number[i]; // 방번호
			isOk = false;

			// 마지막 값보다 크면 그냥 마지막에 추가
			if (num > list.get(list.size() - 1).end) {
				list.add(new Point(num, num + 1));
				ans[i] = num;
				continue;
			}

			if (num < list.get(0).start) {
				if (num == list.get(0).start - 1) {
					list.set(0, new Point(num, list.get(0).end));
				} else {
					list.add(0, new Point(num, num + 1));
				}

				ans[i] = num;
				continue;
			}

			int mid = binerySerch(num);

			if (isOk) {
				Point p = list.get(mid);

				// 체크 다음꺼랑 겹치는지
				if (mid != list.size() - 1) { // 마지막이 아니라면
					Point next = list.get(mid + 1);

					if (p.end + 1 == next.start) { // 겹치면?
						list.remove(mid + 1); // 겹치면 다음꺼를 삭제하고 현재꺼를 고쳐주자
						list.set(mid, new Point(p.start, next.end));
					} else { // 안겹치면
						list.set(mid, new Point(p.start, p.end + 1));
					}

				} else { // 마지막이면 그냥 마지막꺼를 쓰자
					list.set(mid, new Point(p.start, p.end + 1));
				}

				ans[i] = p.end;
			} else {
				Point p = list.get(mid);

				if (p.start > num) { // 범위보다 작으면
					for (int j = mid; j >= 0; j--) {
						Point temp = list.get(j);
						if (temp.end < num) {
							if (list.get(j + 1).start == num + 1) {
								list.set(j + 1, new Point(num, p.end));
							} else {
								list.add(j + 1, new Point(num, num + 1));
							}

							break;
						}
					}
				}

				if (p.end < num) {
					for (int j = mid; j < list.size(); j++) {
						Point temp = list.get(j);
						
						if (temp.start > num) {
							if (temp.start == num + 1) {
								list.set(j, new Point(num, temp.end));
							} else {
								list.add(j, new Point(num, num + 1));
							}
							
							break;
						}
					}
				}

				ans[i] = num;
			}
		}

		return ans;
	}

	static int binerySerch(long num) {
		int left = 0;
		int right = list.size() - 1;
		int mid = 0;

		while (left <= right) {
			mid = (left + right) / 2;

			Point p = list.get(mid);

			if (p.start > num) {
				right = mid - 1;
			} else {
				if (p.end < num) {
					left = mid + 1;
				} else {
					isOk = true;
					return mid;
				}
			}
		}
		
		return mid;
	}

	static class Point {
		long start, end;

		public Point(long start, long end) {
			super();
			this.start = start;
			this.end = end;
		}

		@Override
		public String toString() {
			return "Point [start=" + start + ", end=" + end + "]";
		}
	}
}
