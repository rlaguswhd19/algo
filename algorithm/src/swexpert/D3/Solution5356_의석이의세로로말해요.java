package swexpert.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution5356_의석이의세로로말해요 {
	static String[] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());
		arr = new String[5];
		int max = 0;

		for (int tc = 1; tc <= t; tc++) {
			for (int i = 0; i < 5; i++) {
				String s = br.readLine();
				arr[i] = s;
				max = Math.max(max, s.length());
			}

			int cnt = 0;
			StringBuilder sb = new StringBuilder();
			sb.append("#" + tc + " ");
			for (int a = 0; a < max; a++) {
				for (int i = 0; i < 5; i++) {
					if (arr[i].length() > cnt) {
						sb.append(arr[i].charAt(cnt));
					}
				}
				cnt++;
			}
			
			System.out.println(sb);
		}
	}
}
