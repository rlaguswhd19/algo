package swexpert.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution1289_원재의메모리복구하기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= t; tc++) {

			char[] arr = br.readLine().toCharArray();
			int ans = 0;
			int state = 0;

			for (int i = 0; i < arr.length; i++) {
				int num = arr[i] - '0';
				if (num == state) {
					continue;
				} else {
					state = num;
					ans++;
				}
			}

			System.out.println("#" + tc + " " + ans);
		}
	}
}
