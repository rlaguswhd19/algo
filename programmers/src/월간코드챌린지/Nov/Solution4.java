package 월간코드챌린지.Nov;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class Solution4 {
	static HashMap<Integer, ArrayList<Integer>> map;
	static int ans = 0;

	public static void main(String[] args) {
		int[][] t = { { 5, 1 }, { 2, 5 }, { 3, 5 }, { 3, 6 }, { 2, 4 }, { 4, 0 } };
		solution(t);
	}

	static int solution(int[][] t) {
		map = new HashMap<>();
		ArrayList<Integer> temp;
		int[] visit = new int[t.length + 1];
		for (int i = 0; i < t.length; i++) {
			int s = t[i][0];
			int e = t[i][1];

			if (map.containsKey(s)) {
				temp = map.get(s);
				temp.add(e);
				map.put(s, temp);
			} else {
				temp = new ArrayList<>();
				temp.add(e);
				map.put(s, temp);
			}

			if (map.containsKey(e)) {
				temp = map.get(e);
				temp.add(s);
				map.put(e, temp);
			} else {
				temp = new ArrayList<>();
				temp.add(s);
				map.put(e, temp);
			}
		}

		int size = 0;
		
		for (int key : map.keySet()) {
			temp = map.get(key);
			if(temp == null) {
				continue;
			}
			Collections.sort(temp, new Comparator<Integer>() {

				@Override
				public int compare(Integer o1, Integer o2) {
					if(map.get(o1).size() < map.get(o2).size()) {
						return 1;
					}else {
						return -1;
					}
				}
			});
			map.put(key, temp);
		}
		
		for (int key : map.keySet()) {
			temp = map.get(key);
			size = temp.size();

			if (size <= 3) {
				for (int i = 0; i < temp.size(); i++) {
					visit[temp.get(i)]++;
				}
				
				if(visit[key] <= 2) {
					ans++;
				}
			}
		}
		
		return ans;
	}
}
