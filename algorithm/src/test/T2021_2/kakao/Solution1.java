package test.T2021_2.kakao;

import java.util.HashMap;
import java.util.HashSet;

public class Solution1 {
	static int[] ans;
	static HashMap<String, HashSet<String>> map;
	static HashMap<String, Integer> idx_map;
	public static void main(String[] args) {
		String[] id_list = {"muzi", "frodo", "apeach", "neo"};
		String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
		int k = 2;
		solution(id_list, report, k);
	}
	
	static int[] solution(String[] id_list, String[] report, int k) {
		map = new HashMap<>();
		idx_map = new HashMap<>();
		ans = new int[id_list.length];
		HashSet<String> block_list = new HashSet<>();
		for (int i = 0; i < id_list.length; i++) {
			map.put(id_list[i], new HashSet<>());
			idx_map.put(id_list[i], i);
		}
		
		for (int i = 0; i < report.length; i++) {
			String[] temp = report[i].split(" ");
			HashSet<String> set = map.get(temp[1]);
			set.add(temp[0]);
			if(set.size() >= k) {
				block_list.add(temp[1]);
			}
			
			map.put(temp[1], set);
		}
		
		for(String block_id : block_list) {
			HashSet<String> set = map.get(block_id);
			for(String key : set) {
				ans[idx_map.get(key)]++;
			}
		}
		
		return ans;
	}
}
