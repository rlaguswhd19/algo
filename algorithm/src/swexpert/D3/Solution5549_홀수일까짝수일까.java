package swexpert.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution5549_홀수일까짝수일까 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= t; tc++) {
			String s = br.readLine();

			int n = s.charAt(s.length() - 1);

			System.out.println("#" + tc + " " + (n % 2 == 0 ? "Even" : "Odd"));
		}
	}
}
