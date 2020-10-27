package level4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class 무지의먹방라이브 {
	public static void main(String[] args) {
		long k = 5;
		int[] food_times = { 3, 1, 2};

		System.out.println(solution(food_times, k));
	}

	static int solution(int[] food_times, long k) {
		HashMap<Integer, ArrayList<Integer>> idx = new HashMap<>();
		boolean[] visit = new boolean[food_times.length + 1]; // 다먹은 음식인지 확인하기
		boolean isOk = true;
		for (int i = 0; i < food_times.length; i++) {
			int food = food_times[i]; // 음식양

			if (idx.containsKey(food)) { // 음식양이 있는지 확인
				ArrayList<Integer> arr = idx.get(food);
				arr.add(i + 1); // 있으면 인덱스를 넣어준다.
				idx.put(food, arr);
			} else {
				ArrayList<Integer> arr = new ArrayList<>();
				arr.add(i + 1);
				idx.put(food, arr); // 인덱스 추가
			}
		}

		ArrayList<Integer> list = new ArrayList<>(idx.keySet()); // 음식물 량에 따른 갯수
		Collections.sort(list);
		long size = food_times.length; // 음식들 사이즈
		int past = 0;

		// 한타임에 한 사이클을 돌림
		// 시간 = 지나간시간 * 한사이클
		for (int i = 0; i < list.size(); i++) {
			int now = list.get(i); // 사이클 시간
			long time = now - past; // 지나간 시간
			ArrayList<Integer> arr = idx.get(now); // 빠져야 하는 음식 인덱스들

			k -= size * time; // 현재시간 - (사이클 * 시간) = 남은 시간
			past = now; // 시간 갱신

			if (k < 0) {
				k %= size; // 많은 시간이 지난것을 고려하여 시간을 나눠준다.
				break;
			} else if (k == 0) {
				eat_food(arr, visit);
				size -= arr.size();

				if (size == 0) { // k는 0인데 먹을 음식이 없어
					isOk = false; // 그럼 -1
				}

				break;
			}
			
			eat_food(arr, visit);
			size -= arr.size();

			if (size == 0) { // k가 0보다 큰데? 더이상 먹을게 없네?
				isOk = false;
				break;
			}
		}
		
		if (isOk) { // 먹을게 남았어 그럼 돌면서 index를 구하자
			int ans = 0;
			long count = 0;
			if (k != 0) {
				count = size + k;
			}
			
			for (int i = 1; i < visit.length; i++) {
				if (visit[i]) {
					continue;
				}

				if (count == 0) {
					ans = i;
					break;
				}

				count--;
			}

			return ans;
		} else { // 더이상 먹을게 없을땐 -1
			return -1;
		}
	}
	
	static void eat_food(ArrayList<Integer> arr, boolean[] visit) {
		for (int j = 0; j < arr.size(); j++) { // 다먹은 애들은 true
			int index = arr.get(j);
			visit[index] = true;
		}
	}
}
