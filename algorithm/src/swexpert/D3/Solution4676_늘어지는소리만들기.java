package swexpert.D3;

import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;

public class Solution4676_늘어지는소리만들기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= t; tc++) {
			String s = br.readLine();
			int n = Integer.parseInt(br.readLine());
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] arr = new int[21];
			while (st.hasMoreTokens()) {
				int idx = Integer.parseInt(st.nextToken());
				arr[idx]++;
			}

			StringBuilder sb = new StringBuilder();
			
			for (int i = 0; i < arr[0]; i++) {
				sb.append('-');
			}
			
			for (int i = 0; i < s.length(); i++) {
				sb.append(s.charAt(i));
				for (int j = 0; j < arr[i+1]; j++) {
					sb.append('-');
				}
			}

			System.out.println(sb.toString());
		}
	}
}
