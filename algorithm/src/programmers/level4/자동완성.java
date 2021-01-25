package programmers.level4;

import java.util.HashMap;

public class 자동완성 {
	static int ans = 0;
	public static void main(String[] args) {
		String[] words = { "go", "gone", "guild" };
		System.out.println(solution(words));
	}

	static int solution(String[] words) {
		Trie root = new Trie(0, new HashMap<Character, Trie>());
		Trie now, next;
		for (int i = 0; i < words.length; i++) {
			String word = words[i];
			now = root;
			int idx = 0;
			
			while(true) {
				now.cnt++;
				if (idx == word.length()) { // 다만들었으면 끝내기
					break;
				}

				HashMap<Character, Trie> temp = now.map;
				char c = word.charAt(idx);

				if (temp.containsKey(c)) { // 있으면 그냥 가져오기
					next = temp.get(c);
				} else { // 없으면 새로 만들기
					next = new Trie(0, new HashMap<>());
					temp.put(c, next);
				}
				
				idx++;
				now = next;
			}
		}

		for (int i = 0; i < words.length; i++) {
			String word = words[i];
			int idx = 0;
			now = root;
			while(true) {
				if (idx == word.length() || now.cnt == 1) { // 끝에 도달한 경우
					ans += idx;
					break;
				}

				char c = word.charAt(idx);
				idx++;
				now = now.map.get(c);;
			}
			
		}

		return ans;
	}

	static class Trie {
		int cnt;
		HashMap<Character, Trie> map;

		public Trie(int cnt, HashMap<Character, Trie> map) {
			super();
			this.cnt = cnt;
			this.map = map;
		}
	}
}
