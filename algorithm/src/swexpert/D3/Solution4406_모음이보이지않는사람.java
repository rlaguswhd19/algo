package swexpert.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution4406_모음이보이지않는사람 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= t; tc++) {
			String s = br.readLine();

			StringBuilder sb = new StringBuilder();

			for (int i = 0; i < s.length(); i++) {
				char temp = s.charAt(i);
				if (temp == 'a' || temp == 'e' || temp == 'o' || temp == 'i' || temp == 'u') {
					continue;
				}

				sb.append(temp);
			}

			System.out.println("#" + tc + " " + sb.toString());
		}
	}
}
