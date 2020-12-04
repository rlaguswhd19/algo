package swexpert.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution9700_USB꽂기의미스터리 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= t; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			double p = Double.parseDouble(st.nextToken());
			double q = Double.parseDouble(st.nextToken());

			double s1 = (1 - p) * q;
			double s2 = p * (1 - q) * q;

			if (s1 < s2) {
				System.out.println("#" + tc + " " + "YES");
			} else {
				System.out.println("#" + tc + " " + "NO");
			}
		}
	}
}
