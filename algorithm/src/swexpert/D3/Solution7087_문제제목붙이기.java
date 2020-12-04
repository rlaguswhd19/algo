package swexpert.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;

public class Solution7087_문제제목붙이기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= t; tc++) {
			int n = Integer.parseInt(br.readLine());
			LinkedList<Character> list = new LinkedList<>();
			for (int i = 0; i < n; i++) {
				String s = br.readLine();
				list.add(s.charAt(0));
			}

			Collections.sort(list);
			char start = 65;

			for (int i = 0; i < list.size(); i++) {
				char temp = list.get(i);
				if (temp < start) {
					continue;
				} else if (temp == start) {
					start++;
				} else {
					break;
				}
			}

			System.out.println("#" + tc + " " + (start - 65));
		}
	}
}
