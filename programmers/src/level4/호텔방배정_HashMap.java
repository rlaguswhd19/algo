package level4;

import java.util.HashMap;

public class 호텔방배정_HashMap {
	static long[] ans;
	static HashMap<Long, Long> map;

	public static void main(String[] args) {
		long k = 10;
		long[] room_number = { 5, 6, 100, 3000, 99, 99 };
		solution(k, room_number);
	}

	static long[] solution(long k, long[] room_number) {
		map = new HashMap<>();
		ans = new long[room_number.length];

		for (int i = 0; i < room_number.length; i++) {
			long num = room_number[i];

			ans[i] = find(num);
		}
		
		return ans;
	}

	static long find(long num) {
		if (map.containsKey(num)) {
			long next = map.get(num);
			long temp = find(next);
			
			map.put(num , temp); // 갱신
			return temp;
		} else {
			map.put(num, num + 1);
			return num;
		}
	}
}
