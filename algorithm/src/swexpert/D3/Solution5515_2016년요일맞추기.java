package swexpert.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution5515_2016년요일맞추기 {
	static int[] month = { 0, 31, 60, 91, 121, 152, 182, 213, 244, 274, 305, 335, 366 };
	static int[] day = { 0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= t; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int m = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int cnt = 3;

			cnt += month[m - 1] + d;
			System.out.println("#" + tc + " " + cnt % 7);
		}
	}
}
