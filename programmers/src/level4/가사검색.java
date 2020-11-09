package level4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class 가사검색 { // 효율성 2번 실패
	static HashMap<Integer, ArrayList<Integer>[][]> map;
	static HashMap<Integer, Integer> count;

	// 효율성 2번 시간초과
	public static void main(String[] args) {
		String[] words = { "frodo", "front", "frost", "frozen", "frame", "kakao" };
		String[] queries = { "fro??", "?????", "fr???", "fro???", "pro?" };
		System.out.println(Arrays.toString(solution(words, queries)));
	}

	static int[] solution(String[] words, String[] queries) {
		int[] ans = new int[queries.length];
		map = new HashMap<>();
		int size = 0;
		ArrayList<Integer>[][] temp;
		count = new HashMap<>();
		for (int i = 0; i < words.length; i++) {
			String s = words[i];
			size = s.length();

			if (map.containsKey(size)) {
				temp = map.get(size);

				for (int j = 0; j < size; j++) {
					int al = s.charAt(j) - 'a';
					temp[j][al].add(i);

				}

				map.put(size, temp);

				int cnt = count.get(size);
				count.put(size, cnt + 1);
			} else {
				temp = new ArrayList[size][26];

				for (int j = 0; j < size; j++) {
					for (int k = 0; k < 26; k++) {
						temp[j][k] = new ArrayList<>();
					}
				}

				for (int j = 0; j < size; j++) {
					int al = s.charAt(j) - 'a';
					temp[j][al].add(i);
				}
				map.put(size, temp);

				count.put(size, 1);
			}

		}

		HashMap<String, Integer> result = new HashMap<>();
		for (int i = 0; i < queries.length; i++) {
			String query = queries[i];

			if (result.containsKey(query)) {
				ans[i] = result.get(query);
			} else {
				ans[i] = intersection(query, words.length);
				result.put(query, ans[i]);
			}
		}

		return ans;
	}

	static int intersection(String query, int cnt_size) {
		int size = query.length();
		if (!map.containsKey(size)) {
			return 0;
		}

		ArrayList<Integer>[][] temp = map.get(size);
		int[] cnt = new int[cnt_size];
		int ans = 0;
		int start = 0;

		if (query.charAt(0) == '?') {
			boolean isOk = false;

			start = binerySerch(query, false);
			size -= start;
			
			if (size == 0) {
				return count.get(start);
			}

			int al = 0;
			for (int i = start; i < query.length(); i++) {
				al = query.charAt(i) - 'a';

				ArrayList<Integer> list = temp[i][al];
				int idx = 0;
				for (int j = 0; j < list.size(); j++) {
					idx = list.get(j);

					if (++cnt[idx] == size) {
						ans++;
					}
				}
			}
		} else {
			int end = binerySerch(query, true);
			size = end;

			int al = 0;
			for (int i = 0; i < end; i++) {
				al = query.charAt(i) - 'a';

				ArrayList<Integer> list = temp[i][al];
				int idx = 0;
				for (int j = 0; j < list.size(); j++) {
					idx = list.get(j);

					if (++cnt[idx] == size) {
						ans++;
					}
				}
			}
		}

		return ans;
	}

	static int binerySerch(String query, boolean pre) {
		int right = query.length() - 1;
		int left = 0;
		int mid = 0;
		while (left <= right) {
			mid = (left + right) / 2;

			if (pre) {
				if (query.charAt(mid) == '?') {
					right = mid - 1;
				} else {
					left = mid + 1;
				}
			} else {
				if (query.charAt(mid) == '?') {
					left = mid + 1;
				} else {
					right = mid - 1;
				}
			}
		}

		return right + 1;
	}
}
