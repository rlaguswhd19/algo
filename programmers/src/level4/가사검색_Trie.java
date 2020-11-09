package level4;

import java.util.Arrays;
import java.util.HashMap;

public class 가사검색_Trie {

	// 효율성 2번 시간초과 및 효율성 안좋음
	public static void main(String[] args) {
		String[] words = { "frodo", "front", "frost", "frozen", "frame", "kakao" };
		String[] queries = { "fro??", "????o", "fr???", "fro???", "pro?" };
		System.out.println(Arrays.toString(solution(words, queries)));
	}

	static int[] solution(String[] words, String[] queries) {
		HashMap<Integer, Trie> map = new HashMap<>();
		
		HashMap<String, Integer> result = new HashMap<>();

		int key = 0;
		Trie temp;
		for (int i = 0; i < words.length; i++) {
			String word = words[i];
			key = word.length();

			if (map.containsKey(key)) {
				temp = map.get(key);
				createTrie(temp, word, 0);
				map.put(key, temp);
			} else {
				temp = new Trie(0, new HashMap<Character, Trie>());
				createTrie(temp, word, 0);
				map.put(key, temp);
			}
		}
		
		int[] ans = new int[queries.length];
		
		for (int i = 0; i < queries.length; i++) {
			String query = queries[i];
			if (result.containsKey(query)) {
				ans[i] = result.get(query);
			} else {
				key = query.length();
				if (map.containsKey(key)) {
					temp = map.get(key);
					if (query.charAt(0) == '?') { // 앞에 있으면
						ans[i] = suffix(temp, query, 0);
					} else {
						ans[i] = prefix(temp, query, 0);
					}

					result.put(query, ans[i]);
				} else {
					ans[i] = 0;
				}
			}
		}

		return ans;
	}

	static int prefix(Trie t, String query, int idx) { // ?이 뒤에

		if (idx == query.length()) { // 끝까지 간경우
			return t.cnt;
		}

		char al = query.charAt(idx);

		if (al == '?') { // 중간에 ? 만난경우
			return t.cnt;
		}

		if (t.map.containsKey(al)) {
			Trie temp = t.map.get(al);
			return prefix(temp, query, idx + 1);
		} else {
			return 0;
		}
	}

	static int suffix(Trie t, String query, int idx) { // ?이 앞에
		if (idx == query.length()) { // 끝까지 간경우
			return t.cnt;
		}

		char al = query.charAt(idx);

		Trie temp;
		if (al == '?') {
			int sum = 0;

			for (char key : t.map.keySet()) {
				temp = t.map.get(key);
				sum += suffix(temp, query, idx + 1);
			}

			return sum;
		} else {
			if (t.map.containsKey(al)) { // 다음 알파벳이 있으면 타고
				temp = t.map.get(al);
				return suffix(temp, query, idx + 1);
			} else { // 없으면 0개야
				return 0;
			}
		}
	}

	static void createTrie(Trie t, String word, int idx) {
		t.cnt++; // 자기자신의 갯수 추가

		if (idx == word.length()) { // 마지막이면 끝
			return;
		}

		char c = word.charAt(idx); // 다음 문자
		Trie temp;
		if (t.map.containsKey(c)) {
			temp = t.map.get(c);
			createTrie(temp, word, idx + 1); // 뽑아서 가기
		} else {
			temp = new Trie(0, new HashMap<Character, Trie>());
			createTrie(temp, word, idx + 1);
			t.map.put(c, temp);
		}
	}

	static class Trie {
		int cnt;
		HashMap<Character, Trie> map;

		public Trie(int cnt, HashMap<Character, Trie> map) {
			super();
			this.cnt = cnt;
			this.map = map;
		}

		@Override
		public String toString() {
			return "Trie [cnt=" + cnt + ", map=" + map + "]";
		}
	}
}
