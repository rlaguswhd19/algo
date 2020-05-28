package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution3032_홍준이의숫자놀이 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= t; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			boolean change = false;
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int qi, si, ri, ti;
			int[] sarr = { 1, 0 };
			int[] tarr = { 0, 1 };
			int[] rarr = new int[2];
			int max;
			int min;

			if (a > b) {
				max = a;
				min = b;
			} else {
				max = b;
				min = a;
				change = true;
			}
			rarr[0] = max;
			rarr[1] = min;

			ri = min;
			qi = max / min;
			si = 0;
			ti = 1;

			while (true) {
				qi = rarr[0] / rarr[1];
				ri = rarr[0] % rarr[1];

				if (ri == 0) {
					break;
				}

				rarr[0] = rarr[1];
				rarr[1] = ri;

				si = sarr[0] - sarr[1] * qi;
				sarr[0] = sarr[1];
				sarr[1] = si;

				ti = tarr[0] - tarr[1] * qi;
				tarr[0] = tarr[1];
				tarr[1] = ti;
			}

			if (change) {
				System.out.println("#" + tc + " " + ti + " " + si);
			} else {
				System.out.println("#" + tc + " " + si + " " + ti);
			}

		}
	}
}
