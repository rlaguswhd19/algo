package swexpert.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution3975_승률비교하기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		StringTokenizer st;
		for (int tc = 1; tc <= t; tc++) {
			st = new StringTokenizer(br.readLine());

			double a = Double.parseDouble(st.nextToken());
			double b = Double.parseDouble(st.nextToken());
			double c = Double.parseDouble(st.nextToken());
			double d = Double.parseDouble(st.nextToken());
			double alice = a / b;
			double bob = c / d;

			if (alice > bob) {
				System.out.println("#" + tc + " " + "ALICE");
			} else if (alice < bob) {
				System.out.println("#" + tc + " " + "BOB");
			} else {
				System.out.println("#" + tc + " " + "DRAW");
			}
		}
	}
}
