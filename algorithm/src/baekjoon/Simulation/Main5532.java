package baekjoon.Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main5532 {
	static int l, a, b, c, d, ans;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		l = Integer.parseInt(br.readLine());
		a = Integer.parseInt(br.readLine());
		b = Integer.parseInt(br.readLine());
		c = Integer.parseInt(br.readLine());
		d = Integer.parseInt(br.readLine());

		int study = 0;

		if (a % c == 0) {
			study = a / c;
		} else {
			study = a / c + 1;
		}

		ans = Math.max(ans, study);

		if (b % d == 0) {
			study = b / d;
		} else {
			study = b / d + 1;
		}

		ans = Math.max(ans, study);

		System.out.println(l-ans);
	}
}
