package T2020_2.coupang;

import java.util.HashMap;
import java.util.HashSet;

public class Solution3 {
	public static void main(String[] args) {
		int k = 2;
		int[] score = {1300000000,700000000,668239490,618239490,568239490,568239486,518239486,157658638,157658634,100000000,100};
		System.out.println(solution(k, score));
	}

	static int solution(int k, int[] score) {
		HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
		HashMap<Integer, Integer> cntMap = new HashMap<>();

		int size = score.length;
		HashSet<Integer> set;
		int cnt = 0;
		for (int i = 1; i < score.length; i++) {
			int now = score[i];
			int diff = 0;

			int past = score[i - 1];
			diff = Math.abs(now - past);

			if (map.containsKey(diff)) {
				cnt = cntMap.get(diff);
				cntMap.put(diff, cnt + 1);

				set = map.get(diff);
			} else {
				cnt = 1;
				cntMap.put(diff, cnt);

				set = new HashSet<>();
			}

			set.add(i);
			set.add(i - 1);

			map.put(diff, set);
		}

		HashSet<Integer> ans = new HashSet<>();
		
		for(int key : cntMap.keySet()) {
			int val = cntMap.get(key);
			if(val >= k) {
				for(int num : map.get(key)) {
					ans.add(num);
				}
			}
		}
		
		return size - ans.size();
	}
}
