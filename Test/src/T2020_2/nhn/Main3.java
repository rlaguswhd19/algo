package nhn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main3 {
	static int n;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			solution(s);
		}
	}

	static void solution(String s) {
		LinkedList<String> q = new LinkedList<>();
		StringBuilder sb = new StringBuilder();

		int idx = 0;

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			// 가로 처리
			if (c == '(') { // 새로운 들어갈 것
				q.add(sb.toString());
				sb = new StringBuilder();
			} else if (c == ')') { // 여기서 처리하기
				StringBuilder next = new StringBuilder(q.pollLast());
				char last = next.charAt(next.length() - 1);
				// 마지막 제거
				next.delete(next.length() - 1, next.length());
				
				StringBuilder temp = new StringBuilder();
				if (last < 65) { // 문자가 아니면
					for (int j = 0; j < last - '0'; j++) {
						temp.append(sb);
					}
				} else { // 문자면?
					for (int j = 0; j < sb.length(); j++) {
						temp.append(last);
						temp.append(sb.charAt(j));
					}

				}
				sb = temp;

				sb = next.append(sb); // 앞에거에 뒤에것 붙이기
			} else if (c < 65) { // 숫자면
				char next = s.charAt(i + 1);

				if (next == '(') { // 다음이 가로면?
					sb.append(c);
					continue;
				}

				for (int j = 0; j < c - '0'; j++) {
					sb.append(next);
				}

				i += 1;
			} else {
				sb.append(c);
			}
		}

		System.out.println(sb.toString());
	}
}
