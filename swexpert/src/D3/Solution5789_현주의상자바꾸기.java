package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution5789_현주의상자바꾸기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= t; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int q = Integer.parseInt(st.nextToken());
			int[] arr = new int[n + 1];

			for (int i = 1; i <= q; i++) {
				st = new StringTokenizer(br.readLine());
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());

				for (int j = start; j <= end; j++) {
					arr[j] = i;
				}
			}
			
			StringBuilder sb = new StringBuilder();
			sb.append("#"+tc+" ");
			
			for (int i = 0; i < arr.length; i++) {
				sb.append(arr[i]+" ");
			}
			
			System.out.println(sb);
		}
	}
}
