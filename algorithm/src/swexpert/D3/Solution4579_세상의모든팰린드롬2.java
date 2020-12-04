package swexpert.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution4579_세상의모든팰린드롬2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= t; tc++) {
			boolean isOk = true;
			String s = br.readLine();
			char[] arr = s.toCharArray();
			int len = s.length();
			int minus = 1;

			if (s.length() % 2 != 0) {
				len++;
				minus++;
			}

			for (int i = 0; i < len / 2; i++) {
				if (arr[i] == arr[len - minus - i]) {
					continue;
				} else {
					if (arr[i] == '*' || arr[len - minus - i] == '*') {
						isOk = true;
					} else {
						isOk = false;
					}
					break;
				}
			}

			System.out.println("#" + tc + " " + (isOk ? "Exist" : "Not exist"));
		}
	}
}
