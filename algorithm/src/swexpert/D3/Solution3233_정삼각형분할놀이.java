package swexpert.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution3233_정삼각형분할놀이 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= t; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			long ans = 0;
			long a = Long.parseLong(st.nextToken());
			long b = Long.parseLong(st.nextToken());

			System.out.println("#" + tc + " " + (a / b) * (a / b));
		}
	}
}
