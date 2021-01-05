package programmers.level3;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class 불량사용자 {
	static boolean[] visit;
	static HashMap<String, HashSet<Integer>> map;
	static int[] res;
	static HashSet<String> ans;

	public static void main(String[] args) {
		String[] user_id = { "frodo", "fradi", "crodo", "abc123", "frodoc" };
//		String[] banned_id = { "fr*d*", "abc1**" };
//		String[] banned_id = { "*rodo", "*rodo", "******" };
		String[] banned_id = { "fr*d*", "*rodo", "******", "******" };
		solution(user_id, banned_id);
	}

	static int solution(String[] user_id, String[] banned_id) {
		map = new HashMap<>();
		visit = new boolean[user_id.length];
		res = new int[banned_id.length];
		ans = new HashSet<>();
		HashSet<Integer> temp;
		for (int i = 0; i < user_id.length; i++) {
			String user = user_id[i];
			for (int j = 0; j < banned_id.length; j++) {
				String ban = banned_id[j];

				if (user.length() != ban.length()) {
					continue;
				}
				char u, b;
				boolean isOk = true;
				for (int k = 0; k < user.length(); k++) {
					u = user.charAt(k);
					b = ban.charAt(k);

					if (b == '*') {
						continue;
					}

					if (b != u) {
						isOk = false;
						break;
					}
				}

				if (isOk) { // 일치하면
					if (map.containsKey(ban)) {
						temp = map.get(ban);
					} else {
						temp = new HashSet<>();
					}

					temp.add(i);
					map.put(ban, temp);
				}
			}
		}
		
		per(0, banned_id);
		return ans.size();
	}

	static void per(int idx, String[] banned_id) {
		if (idx == res.length) {
			int[] copy = res.clone();
			Arrays.sort(copy);
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < copy.length; i++) {
				sb.append(copy[i]);
			}
			
			ans.add(sb.toString());
			return;
		}

		String ban = banned_id[idx];
		HashSet<Integer> temp = map.get(ban);
		for (int index : temp) {
			if (visit[index]) {
				continue;
			}

			visit[index] = true;
			res[idx] = index;
			per(idx + 1, banned_id);
			visit[index] = false;
		}
	}
}
