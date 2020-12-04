package test.T2019_2.line;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Solution5 {
	static String[][] dataSource = { { "Doc1", "t1", "t2", "t3" }, { "doc4", "t0", "t2", "t3" },
			{ "doc3", "t1", "t6", "t7" }, { "doc2", "t1", "t2", "t4" }, { "doc5", "t1", "t100", "t8" },{ "Doc6", "t1", "t2", "t4" }, { "doc7", "t1", "t2", "t4" },{ "doc8", "t1", "t2", "t4" },{ "doc9", "t1", "t2", "t4" },{ "doc10", "t1", "t2", "t4" },{ "doc0", "t1", "t2", "t3" }};
	static String[] tags = { "t1", "t2", "t3" };

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution()));
	}

	static String[] solution() {
		ArrayList<doc> arr = new ArrayList<>();

		for (int i = 0; i < dataSource.length; i++) {
			String name = dataSource[i][0];

			int cnt = 0;
			for (int j = 1; j < dataSource[i].length; j++) {

				for (int j2 = 0; j2 < tags.length; j2++) {
					if (dataSource[i][j].equals(tags[j2])) {
						cnt++;
						break;
					}
				}
			}
			
			if(cnt != 0) {
				arr.add(new doc(name, cnt));
			}
		}
		
		Collections.sort(arr, new Comparator<doc>() {

			@Override
			public int compare(doc d1, doc d2) {
				if(d1.cnt < d2.cnt) {
					return 1;
				}else if(d1.cnt > d2.cnt) {
					return -1;
				}else {
					return d1.name.compareTo(d2.name);
				}
			}
		});
		
		int size = 0;
		if(arr.size() > 10) {
			size = 10;
		}else {
			size = arr.size();
		}
		String[] answer = new String[size];
		for (int i = 0; i < answer.length; i++) {
			answer[i] = arr.get(i).name;
		}
		
		return answer;
	}

	static class doc {
		String name;
		int cnt;

		public doc(String name, int cnt) {
			super();
			this.name = name;
			this.cnt = cnt;
		}

		@Override
		public String toString() {
			return "doc [name=" + name + ", cnt=" + cnt + "]";
		}
	}
}
