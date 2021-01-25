package programmers.level3;

import java.util.ArrayList;
import java.util.HashMap;

public class 매칭점수 {
	static String con;

	public static void main(String[] args) {
		String word = "Muzi";
		String[] pages = {
				"<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://careers.kakao.com/interview/list\"/>\n</head>  \n<body>\n<a href=\"https://programmers.co.kr/learn/courses/4673\"></a>#!MuziMuzi!)jayg07con&&\n\n</body>\n</html>",
				"<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://www.kakaocorp.com\"/>\n</head>  \n<body>\ncon%\tmuzI92apeach&2<a href=\"https://hashcode.co.kr/tos\"></a>\n\n\t^\n</body>\n</html>" };
		System.out.println(solution(word, pages));
	}

	static int solution(String word, String[] pages) {
		String[] list = new String[pages.length];
		String content = "<meta property=\"og:url\"";
		String link = "<a href=\"";
		HashMap<String, Integer> count = new HashMap<>();
		HashMap<String, ArrayList<String>> links = new HashMap<>();
		ArrayList<String> temp;
		word = word.toLowerCase();

		String now = "";
		int cnt;
		for (int i = 0; i < pages.length; i++) {
			cnt = 0;
			String page = pages[i];
			temp = new ArrayList<>();
			boolean findContent = false;

			for (int j = 0; j < page.length(); j++) {
				char c = page.charAt(j);

				if (!findContent) {
					if (c == content.charAt(0)) {
						if (check(j, page, content)) {
							now = con;
							findContent = true;
						}
					}

				}

				if (c == link.charAt(0)) {
					if (check(j, page, link)) {
						temp.add(con);
					}
				}
				if (Character.toLowerCase(c) == word.charAt(0)) {
					if (findWord(j, page.toLowerCase(), word)) {
						cnt++;
					}
				}
			}

			count.put(now, cnt);
			links.put(now, temp);
			list[i] = now;
		}

		HashMap<String, Double> score = new HashMap<>();

		double basic;
		double res;
		for (int i = 0; i < list.length; i++) {
			String key = list[i];
			basic = count.get(key); // 기본점수
			temp = links.get(key); // 링크들

			for (int j = 0; j < temp.size(); j++) {
				String next = temp.get(j);

				if (score.containsKey(next)) {
					res = score.get(next);
				} else {
					res = 0;
				}

				res += basic / temp.size();

				score.put(next, res);
			}

			if (score.containsKey(key)) {
				res = score.get(key);
			} else {
				res = 0;
			}

			res += basic;
			score.put(key, res);
		}

		double max = -1;
		int res_idx = 0;
		for (int i = 0; i < list.length; i++) {
			String key = list[i];
			if (max < score.get(key)) {
				max = score.get(key);
				res_idx = i;
			}
		}
		return res_idx;
	}

	static boolean findWord(int idx, String page, String word) {
		int word_idx = 0;
		int len = page.length();

		if (idx - 1 >= 0) {
			if (page.charAt(idx - 1) >= 97 && page.charAt(idx - 1) <= 122) {
				return false;
			}
		}

		while (idx < len) {
			if (word_idx == word.length()) {
				if (idx < page.length()) {
					if (page.charAt(idx) >= 97 && page.charAt(idx) <= 122) {
						return false;
					}
				}

				return true;
			}

			if (page.charAt(idx) != word.charAt(word_idx)) {
				break;
			}
			idx++;
			word_idx++;
		}

		return false;
	}

	static boolean check(int idx, String page, String word) {
		int test = idx;
		
		int content_idx = 0;
		int start = -1;
		int len = page.length();
		while (idx < len) {
			if (content_idx == word.length()) {
				start = idx;
				break;
			}

			if (page.charAt(idx) != word.charAt(content_idx)) {
				break;
			}

			idx++;
			content_idx++;
		}

		if (start == -1) {
			return false;
		}
		
		while (start < page.length()) {
			if (page.charAt(start) == '/' && page.charAt(start + 1) == '/') {
				start += 2;
				break;
			}

			start++;
		}
		
		StringBuilder sb = new StringBuilder();
		char temp;
		while (true) {
			temp = page.charAt(start);
			if (temp == '"') {
				break;
			}

			sb.append(temp);
			start++;
		}

		con = sb.toString();
		return true;
	}
}
