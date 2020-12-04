package swexpert.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Solution7853_오타 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= t; tc++) {
			String s = br.readLine();
			char[] arr = s.toCharArray();
			HashSet<Character> set = new HashSet<>();
			long ans = 1;

			for (int i = 0; i < arr.length; i++) {
				set.clear();

				set.add(arr[i]);
				
				if (i + 1 < arr.length) {
					set.add(arr[i + 1]);
				}

				if (i - 1 >= 0) {
					set.add(arr[i - 1]);
				}

				ans *= set.size();
				ans %= 1000000007;
			}
			
			
			System.out.println("#" + tc + " " + ans);
		}
	}
}
