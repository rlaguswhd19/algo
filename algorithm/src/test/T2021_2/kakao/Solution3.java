package test.T2021_2.kakao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

public class Solution3 {
	static HashMap<String, Integer> map;
	static HashMap<String, Integer> visit;
	static HashSet<String> cars;

	public static void main(String[] args) {
		int[] fees = { 180, 5000, 10, 600 };
		String[] records = { "05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN",
				"18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT" };
		solution(fees, records);
	}

	static int[] solution(int[] fees, String[] records) {
		String[] arr;
		map = new HashMap<>();
		visit = new HashMap<>();
		cars = new HashSet<>();

		for (int i = 0; i < records.length; i++) {
			arr = records[i].split(" ");

			int time = Integer.parseInt(arr[0].substring(0, 2)) * 60 + Integer.parseInt(arr[0].substring(3, 5));
			String car = arr[1];
			cars.add(car);
			String in_out = arr[2];

			if (in_out.equals("IN")) {
				visit.put(car, time);
			} else {

				int start = visit.get(car);
				visit.remove(car);

				if (map.containsKey(car)) {
					// 누적시간
					int accumulate = map.get(car);
					map.put(car, accumulate + (time - start));
				} else {
					map.put(car, time - start);
				}
			}
		}

		int time = 23 * 60 + 59;
		for (String car : visit.keySet()) {
			int start = visit.get(car);

			if (map.containsKey(car)) {
				// 누적시간
				int accumulate = map.get(car);
				map.put(car, accumulate + (time - start));
			} else {
				map.put(car, time - start);
			}
		}

		ArrayList<String> car_list = new ArrayList<>(cars);
		Collections.sort(car_list);

		int[] ans = new int[car_list.size()];

		for (int i = 0; i < ans.length; i++) {
			String car = car_list.get(i);
			time = map.get(car);

			if (time <= fees[0]) {
				ans[i] = fees[1];
			} else {
				time -= fees[0];
				int addition_time = time / fees[2];
				if (time % fees[2] != 0) {
					addition_time += 1;
				}

				ans[i] = fees[1] + addition_time * fees[3];
			}

		}


		return ans;
	}
}
