package test.T2020_2.kakao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class Solution2 {
	static char[] now, list;
	static int[] max;
	static ArrayList<String> ans;
	static TreeMap<String, Integer> map;

	public static void main(String[] args) {
		String[] orders = {"XYZ", "XWY", "WXA"};
		int[] course = { 2, 3, 4 };
		solution(orders, course);
	}

	static String[] solution(String[] orders, int[] course) {
		map = new TreeMap<String, Integer>();
		max = new int[11];
		ans = new ArrayList<>();

		for (int i = 0; i < orders.length; i++) {
			now = orders[i].toCharArray();
			list = new char[now.length + 1];
			com(course, 0, 1);

		}
		
		for (Map.Entry<String, Integer> m : map.entrySet()) {
			if(m.getValue() == max[m.getKey().length()]) {
				ans.add(m.getKey());
			}
		}
		
		Collections.sort(ans);
		String[] temp = new String[ans.size()];
		for (int i = 0; i < ans.size(); i++) {
			temp[i] = ans.get(i);
		}
		
		return temp;
	}

	static void com(int[] course, int idx, int cnt) {
		if (cnt == now.length + 1) {
			return;
		} else if (idx == now.length) {
			return;
		} else {
			list[cnt] = now[idx];
			
			if (size(cnt, course)) {
				StringBuilder sb = new StringBuilder();
				
				char[] temp = new char[cnt];
				int tempIdx = 0;
				for (int i = 1; i <= cnt; i++) {
					temp[tempIdx++] = list[i];
				}
				
				Arrays.sort(temp);
				
				for (int i = 0; i < temp.length; i++) {
					sb.append(temp[i]);
				}
				
				// cnt가 갯수야

				String s = sb.toString();
				
				if (map.containsKey(s)) {
					int val = map.get(s) + 1;
					max[sb.length()] = Math.max(val, max[sb.length()]);
					map.put(s, val);
				} else {
					map.put(s, 1);
				}
			}

			com(course, idx + 1, cnt + 1);
			com(course, idx + 1, cnt);
		}
	}

	static boolean size(int cnt, int[] course) {
		for (int i = 0; i < course.length; i++) {
			if (cnt == course[i]) {
				return true;
			}
		}

		return false;
	}
}
