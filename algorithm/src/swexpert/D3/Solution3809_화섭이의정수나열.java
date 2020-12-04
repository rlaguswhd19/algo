package swexpert.D3;

import java.io.IOException;
import java.util.Scanner;

public class Solution3809_화섭이의정수나열 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();

		for (int tc = 1; tc <= t; tc++) {
			int n = sc.nextInt();
			StringBuilder sb = new StringBuilder();
			
			for (int i = 0; i < n; i++) {
				sb.append(sc.nextInt());
			}

			String s = sb.toString();
			int ans = 0;

			for (int i = 0; i <= 1000000; i++) {
				if (!s.contains("" + i)) {
					ans = i;
					break;
				}
			}

			System.out.println("#" + tc + " " + ans);

		}
	}
}
