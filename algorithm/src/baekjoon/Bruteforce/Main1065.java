package baekjoon.Bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1065 {
	static int n, ans;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		ans = 0;

		for (int i = 1; i <= n; i++) {
			dfs(i);
		}
		
		System.out.println(ans);
	}

	static void dfs(int num) {

		String s = "" + num;
		char[] arr = s.toCharArray();
		int c = 0;
		for (int i = 0; i < arr.length - 1; i++) {
			int now = arr[i] - '0';
			int next = arr[i + 1] - '0';

			if (i == 0) {
				c = now - next;
			}else {
				if(c != now - next) {
					return;
				}
			}
		}
		
		ans++;
	}
}
