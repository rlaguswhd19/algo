package Level3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;

public class 징검다리건너기 {
	public static void main(String[] args) {
		int[] stones = { 2, 4, 5, 3, 2, 1, 4, 2, 5, 1 };
		int k = 3;
		System.out.println(solution(stones, k));
	}

	static int solution(int[] stones, int k) {
		int[] front = new int[stones.length];
		int[] back = new int[stones.length];

		int ans = 0;

		HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
		ArrayList<Integer> temp;
		for (int i = 0; i < stones.length; i++) {
			int num = stones[i];

			if (map.containsKey(num)) {
				temp = map.get(num);
				temp.add(i);
				map.put(num, temp);
			} else {
				temp = new ArrayList<>();
				temp.add(i);
				map.put(num, temp);
			}
		}

		ArrayList<Integer> list = new ArrayList<>(map.keySet());
		Collections.sort(list);
		int f = 0;
		int b = 0;
		int past = 0; // 전시간
		boolean isOk = true;
		
		for (int i = 0; i < list.size(); i++) {
			int key = list.get(i); // 디딤돌 허용량

			temp = map.get(key);

			for (int j = 0; j < temp.size(); j++) { // 빠져야할 인덱스들
				int idx = temp.get(j); // 없어질 인덱스들

				f = front[idx]; // 앞에 몇개가 비어있는지
				b = back[idx]; // 뒤에 몇개가 비어있는지
				if (idx - b - 1 >= 0) { // 뒤에 애한테 준다.
					front[idx - b - 1] += f + 1; // 1은 자기자신 f는 자기보다 앞에 비어있는 갯수
					if (front[idx - b - 1] >= k) {
						isOk = false;
					}
				}

				if (idx + f + 1 < stones.length) {
					back[idx + f + 1] += b + 1; // 1은 자기자신 b는 자기보다 뒤에 비어있는 갯수
					if (back[idx + f + 1] >= k) {
						isOk = false;
					}
				}
			}
			
			ans += key - past;
			past = key;

			if(!isOk) {
				break;
			}
		}
		
		return ans;
	}
}
