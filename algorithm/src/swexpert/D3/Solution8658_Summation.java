package swexpert.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution8658_Summation {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= t; tc++) {
			int max = 0;
			int min = Integer.MAX_VALUE;

			StringTokenizer st = new StringTokenizer(br.readLine());
			int size = st.countTokens();

			for (int i = 0; i < size; i++) {
				String s = st.nextToken();
				int sum = 0;

				for (int j = 0; j < s.length(); j++) {
					sum += s.charAt(j) - '0';
				}

				max = Math.max(max, sum);
				min = Math.min(min, sum);
			}
			
			System.out.println("#" + tc + " " + max + " " + min);
		}
	}
}
