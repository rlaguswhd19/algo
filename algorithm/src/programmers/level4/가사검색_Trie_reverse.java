package programmers.level4;

import java.util.Arrays;
import java.util.HashMap;

public class 가사검색_Trie_reverse {
	
	// Trie를 만들때 뒤에서 부터 만드는것을 추가해서 suffix인 경우 뒤에서 만든 Trie를 사용한다.
	public static void main(String[] args) {
		String[] words = { "frodo", "front", "frost", "frozen", "frame", "kakao" };
		String[] queries = { "fro??", "????o", "fr???", "fro???", "pro?" };
		System.out.println(Arrays.toString(solution(words, queries)));
	}

	static int[] solution(String[] words, String[] queries) {
		HashMap<Integer, Trie> prefix = new HashMap<>(); // 뒤에 ??
		HashMap<Integer, Trie> suffix = new HashMap<>(); // 앞에 ??

		HashMap<String, Integer> result = new HashMap<>();

		int key = 0;
		Trie temp;
		for (int i = 0; i < words.length; i++) {
			String word = words[i];
			key = word.length();

			if (prefix.containsKey(key)) {
				temp = prefix.get(key);
				createTrie(temp, word, 0, true);
				prefix.put(key, temp);

				temp = suffix.get(key);
				createTrie(temp, word, word.length() - 1, false);
				suffix.put(key, temp);
			} else {
				temp = new Trie(0, new HashMap<Character, Trie>());
				createTrie(temp, word, 0, true);
				prefix.put(key, temp);

				temp = new Trie(0, new HashMap<Character, Trie>());
				createTrie(temp, word, word.length() - 1, false);
				suffix.put(key, temp);
			}
		}

		int[] ans = new int[queries.length];

		for (int i = 0; i < queries.length; i++) {
			String query = queries[i];
			if (result.containsKey(query)) {
				ans[i] = result.get(query);
			} else {
				key = query.length();

				if (query.charAt(0) == '?') {
					if (suffix.containsKey(key)) {
						temp = suffix.get(key);
						ans[i] = count(temp, query, query.length() - 1, false);
					} else {
						ans[i] = 0;
					}
				} else {
					if (prefix.containsKey(key)) {
						temp = prefix.get(key);
						ans[i] = count(temp, query, 0, true);
					} else {
						ans[i] = 0;
					}
				}

				result.put(query, ans[i]);
			}
		}

		return ans;
	}

	static int count(Trie t, String query, int idx, boolean pre) { // ?이 뒤에
		if (pre) {
			if (idx == query.length()) { // 끝까지 간경우
				return t.cnt;
			}
		} else {
			if (idx == 0) { // 끝까지 간경우
				return t.cnt;
			}
		}

		char al = query.charAt(idx);

		if (al == '?') { // 중간에 ? 만난경우
			return t.cnt;
		}

		if (t.map.containsKey(al)) {
			Trie temp = t.map.get(al);
			if(pre) {
				return count(temp, query, idx + 1, pre);
			}else {
				return count(temp, query, idx-1, pre);
			}
		} else {
			return 0;
		}
	}

	static void createTrie(Trie t, String word, int idx, boolean pre) {
		t.cnt++; // 자기자신의 갯수 추가
		if (pre) {
			if (idx == word.length()) { // 마지막이면 끝
				return;
			}
		} else {
			if (idx == -1) {
				return;
			}
		}

		char c = word.charAt(idx); // 다음 문자
		Trie temp;
		if (t.map.containsKey(c)) {
			temp = t.map.get(c);
			if (pre) {
				createTrie(temp, word, idx + 1, pre); // 뽑아서 가기
			} else {
				createTrie(temp, word, idx - 1, pre);
			}
		} else {
			temp = new Trie(0, new HashMap<Character, Trie>());

			if (pre) {
				createTrie(temp, word, idx + 1, pre); // 뽑아서 가기
			} else {
				createTrie(temp, word, idx - 1, pre);
			}

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
