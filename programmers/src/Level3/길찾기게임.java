package Level3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class 길찾기게임 {
	public static void main(String[] args) {
		int[][] nodeinfo = { { 5, 3 }, { 11, 5 }, { 13, 3 }, { 3, 5 }, { 6, 1 }, { 1, 3 }, { 8, 6 }, { 7, 2 },
				{ 2, 2 } };
		solution(nodeinfo);
	}

	static void solution(int[][] nodeinfo) {
		HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

		ArrayList<Integer> arr;
		for (int i = 0; i < nodeinfo.length; i++) {
			int y = nodeinfo[i][0];
			int x = nodeinfo[i][1];

			if (map.containsKey(x)) {
				arr = map.get(x);
				arr.add(i);
				map.put(x, arr);
			} else {
				arr = new ArrayList<>();
				arr.add(i);
				map.put(x, arr);
			}
		}

		ArrayList<Integer> list = new ArrayList<>(map.keySet());
		Collections.sort(list);

		ArrayList<Integer> past = map.get(list.get(list.size() - 1));
		for (int i = list.size() - 2; i >= 0; i--) {
			int key = list.get(i);

			arr = map.get(key);
			for (int j = 0; j < arr.size(); j++) {
				
			}
		}
	}

	static class Node {
		int r, l, min, max;

		public Node(int r, int l, int min, int max) {
			super();
			this.r = r;
			this.l = l;
			this.min = min;
			this.max = max;
		}

		@Override
		public String toString() {
			return "Node [r=" + r + ", l=" + l + ", min=" + min + ", max=" + max + "]";
		}
	}
}
