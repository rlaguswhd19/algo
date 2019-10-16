package 해시;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class level3_베스트앨범 {
	static String[] genres = { "classic", "pop", "classic", "classic", "pop" };
	static int[] plays = { 500, 600, 150, 800, 2500 };
	static HashMap<String, Integer> map;
	static HashMap<String, PriorityQueue<music>> arr;
	static HashSet<String> set;
	static TreeMap<Integer, String> treemap;

	public static void main(String[] args) {
		map = new HashMap<>();
		set = new HashSet<>();
		treemap = new TreeMap<>();
		arr = new HashMap<>();
		for (int i = 0; i < genres.length; i++) {
			set.add(genres[i]);
			if (!map.containsKey(genres[i])) {

				PriorityQueue<music> pq = new PriorityQueue<music>();
				pq.add(new music(i, plays[i]));
				arr.put(genres[i], pq);

				map.put(genres[i], plays[i]);
			} else {
				PriorityQueue<music> pq = arr.get(genres[i]);
				pq.add(new music(i, plays[i]));
				arr.put(genres[i], pq);

				map.put(genres[i], map.get(genres[i]) + plays[i]);
			}
		}

		// 뭐부터 꺼낼지 정해놓음 ㅎㅎ
		for (String s : set) {
			treemap.put(map.get(s), s);
		}
		System.out.println(treemap);
		System.out.println(arr);
		ArrayList<Integer> answer = new ArrayList<>();
		ArrayList<String> temp = new ArrayList<String>(treemap.values());
		for (int i = temp.size()-1; i >= 0; i--) {
			PriorityQueue<music> pq = arr.get(temp.get(i));
			if(pq.size() >= 2) {
				int cnt = 0;
				while(cnt < 2) {
					answer.add(pq.poll().index);
					cnt++;
				}
			}else {
				while(!pq.isEmpty()) {
					answer.add(pq.poll().index);
				}
			}
		}
		int[] ans = new int[answer.size()];
		for (int i = 0; i < answer.size(); i++) {
			ans[i] = answer.get(i);
		}
		System.out.println(Arrays.toString(ans));
	}

	static class music implements Comparable<music> {
		int index;
		int p;

		public music(int index, int play) {
			super();
			this.index = index;
			this.p = play;
		}
		@Override
		public String toString() {
			return "music [index=" + index + ", play=" + p + "]";
		}
		@Override
		public int compareTo(music o) {
			if (this.p < o.p) {
				return 1;
			} else if (this.p == o.p) {
				if (this.index < o.index) {
					return -1;
				} else {
					return 1;
				}
			} else {
				return -1;
			}
		}
	}
}
