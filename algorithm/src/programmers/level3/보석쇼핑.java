package programmers.level3;

import java.util.Arrays;
import java.util.HashMap;

public class 보석쇼핑 {
	public static void main(String[] args) {
		String[] gems = { "AA", "AB", "AC", "AA", "AC" };
		System.out.println(Arrays.toString(solution(gems)));
	}

	static int[] solution(String[] gems) {
		int[] ans = new int[2];
		HashMap<String, Integer> map = new HashMap<>();
		String key;
		for (int i = 0; i < gems.length; i++) {
			key = gems[i];
			if (map.containsKey(key)) {
				continue;
			} else {
				map.put(key, 0);
			}
		}

		int s = 0, e = 0, cnt = 0, size = map.keySet().size(), temp, min = Integer.MAX_VALUE;

		while (s < gems.length) {
			if (cnt < size) {
				while (e < gems.length) {
					if (cnt == size) {
						break;
					}

					key = gems[e];
					temp = map.get(key);
					map.put(key, temp + 1);
					e++;
					
					if (temp == 0) {
						cnt++;
					}

				}

				if (e == gems.length && cnt < size) {
					break;
				}
			} else {
				while (s < gems.length) {
					key = gems[s];
					temp = map.get(key);
					map.put(key, temp - 1);
					s++;

					if (temp == 1) {
						cnt--;

						if (cnt == size - 1) {
							if (min > e - s) {
								ans[0] = s;
								ans[1] = e;
								min = e - s;
							}
							
							break;
						}
					}
				}
			}
		}

		return ans;
	}
}