package programmers.level3;

import java.util.ArrayList;
import java.util.HashMap;

public class GPS {
	public static void main(String[] args) {
		int n = 7, m = 10;
		int[][] edge_list = { { 1, 2 }, { 1, 3 }, { 2, 3 }, { 2, 4 }, { 3, 4 }, { 3, 5 }, { 4, 6 }, { 5, 6 }, { 5, 7 },
				{ 6, 7 } };
		int k = 6;
		int[] gps_log = { 1, 2, 3, 3, 6, 7 };
		solution(n, m, edge_list, k, gps_log);
	}

	static void solution(int n, int m, int[][] edge_list, int k, int[] gps_log) {
		HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

		int s, e;
		ArrayList<Integer> temp;
		for (int i = 0; i < edge_list.length; i++) {
			s = edge_list[i][0];
			e = edge_list[i][1];

			if (map.containsKey(s)) {
				temp = map.get(s);
			} else {
				temp = new ArrayList<>();
			}

			temp.add(e);
			map.put(s, temp);

			if (map.containsKey(e)) {
				temp = map.get(e);
			} else {
				temp = new ArrayList<>();
			}

			temp.add(s);
			map.put(e, temp);
		}

		int now = gps_log[0];
		int next = 0;
		int ans = 0;
		int[] dp = new int[k];
		
		boolean isOk = false;
		for (int i = 1; i < gps_log.length; i++) {
			next = gps_log[i];
			temp = map.get(now);
			isOk = false;

			for (int j = 0; j < temp.size(); j++) {
				if (next == temp.get(j)) {
					isOk = true;
					break;
				}
			}

			if (!isOk) { // 못가는 경우

			}

			now = next;
		}
	}
}
