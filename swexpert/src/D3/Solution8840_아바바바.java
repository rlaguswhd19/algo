package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution8840_아바바바 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= t; tc++) {
			long l = Integer.parseInt(br.readLine());
			long ans = 0;
			long temp = l + 1;
			long mok = temp / 2;

			ans = (mok / 2) * temp - l;

			if (mok % 2 != 0) {
				ans += temp / 2;
			}

			System.out.println("#" + tc + " " + ans);
		}
	}
}
