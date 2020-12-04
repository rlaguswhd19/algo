package swexpert.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution9480_민정이와광직이의알파벳공부 {
	static String[] result;
	static int n, size, ans;
	static String[] arr;
	static boolean[] visit;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int tc = Integer.parseInt(br.readLine());

		for (int t = 1; t <= tc; t++) {
			n = Integer.parseInt(br.readLine());
			arr = new String[n];
			ans = 0;
			
			for (int i = 0; i < n; i++) {
				String s = br.readLine();
				arr[i] = s;
			}
			
			for (int i = 1; i <= n; i++) {
				size = i;
				result = new String[size];
				com(0, 0);
			}
			
			System.out.println("#"+t+" "+ans);
		}
	}

	static void com(int target, int cnt) {
		if (cnt == size) {
			visit = new boolean[123];
			
			for (int i = 0; i < result.length; i++) {
				String s = result[i];
				for (int j = 0; j < s.length(); j++) {
					int num = s.charAt(j);
					visit[num] = true;
				}
			}
			
			for (int i = 97; i < 123; i++) {
				if(!visit[i]) {
					return;
				}
			}
			
			ans++;
			
			return;
		} else if (target == n) {
			return;
		} else {
			result[cnt] = arr[target];
			com(target + 1, cnt + 1);
			com(target + 1, cnt);

		}
	}
}
