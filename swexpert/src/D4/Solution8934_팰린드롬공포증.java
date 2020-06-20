package D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution8934_팰린드롬공포증 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= t; tc++) {
			String s = br.readLine();
			int[] arr = new int[3];

			for (int i = 0; i < s.length(); i++) {
				char temp = s.charAt(i);

				switch (temp) {
				case 'a':
					arr[0]++;
					break;

				case 'b':
					arr[1]++;
					break;

				case 'c':
					arr[2]++;
					break;
				}
			}
			int min = Integer.MAX_VALUE;
			int max = 0;
			for (int i = 0; i < arr.length; i++) {
				max = Math.max(arr[i], max);
				min = Math.min(arr[i], min);
			}
			
			System.out.println("#" + tc + " " + (max - min > 1 ? "NO" : "YES"));
		}
	}
}
