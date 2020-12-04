package swexpert.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution9778_카드게임 {
	static int n;
	static int[] arr;
	static int ans;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= t; tc++) {
			n = Integer.parseInt(br.readLine());
			arr = new int[12];
			ans = 52;
			for (int i = 2; i < 12; i++) {
				if (i == 10) {
					arr[i] = 16;
				} else {
					arr[i] = 4;
				}
			}

			ans -= n;

			int sum = 0;
			for (int i = 0; i < n; i++) {
				int num = Integer.parseInt(br.readLine());
				arr[num]--;
				sum += num;
			}

			int down = 0;

			for (int i = 2; i < 12; i++) {
				if (arr[i] != 0) {
					if (sum + i > 21) {
						break;
					} else {
						down += arr[i];
					}
				}
			}

			if(ans-down >= down) {
				System.out.println("#"+tc+" STOP");
			}else {
				System.out.println("#"+tc+" GAZUA");
			}
			
			br.close();
		}
	}
}
