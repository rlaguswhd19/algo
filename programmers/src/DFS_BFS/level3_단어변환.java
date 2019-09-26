package DFS_BFS;

import java.util.ArrayList;

public class level3_단어변환 {
	static String begin = "hit";
	static String target = "cog";
	static String[] words = { "hot", "dot","dog","lot","log" };
	static boolean[] visit;
	static int result;
	static int count;

	public static void main(String[] args) {
		result = 0;
		count = Integer.MAX_VALUE;
		visit = new boolean[words.length];
		dfs(begin, 0, words);
		if(count == Integer.MAX_VALUE) {
			System.out.println(0);
		}else {
			System.out.println(count);
		}
	}

	static void dfs(String begin, int result, String[] words) {
		if (begin.equals(target)) {
			count = Math.min(result, count);
			return;
		}
		for (int i = 0; i < words.length; i++) {
			int cnt = 0;
			if (!visit[i]) {
				for (int j = 0; j < begin.length(); j++) {
					if (words[i].charAt(j) != begin.charAt(j)) {
						cnt++;
					}
				}
				if (cnt == 1) {
					visit[i] = true;
					dfs(begin, result, words); // 안바꿀경우
					visit[i] = false;
					visit[i] = true;
					dfs(words[i], result + 1, words); // 바꿀경우
					visit[i] = false;
				} else { // 안바꿀경우
					visit[i] = true;
					dfs(begin, result, words);
					visit[i] = false;
				}
			}
		}
	}
}
