package baekjoon.Bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main1107 {
	static int n, m, ans, plus, minus;
	static boolean[] visit;
	static char[] arr;
	static ArrayList<Integer> list;
	static int[] result;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		ans = Integer.MAX_VALUE;
		visit = new boolean[10];
		arr = Integer.toString(n).toCharArray();
		result = new int[Integer.toString(n).length()+1];
		if (m != 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < m; i++) {
				visit[Integer.parseInt(st.nextToken())] = true;
			}
		}

		int start = 100;
		ans = Math.abs(n - start);

		dfs(0);
		System.out.println(ans);
	}
	
	static void dfs(int i) {

		StringBuilder sb = new StringBuilder();
		for (int j = 0; j < i; j++) {
			sb.append(result[j]);
		}

		if (sb.length() != 0) {
			int num = Integer.parseInt(sb.toString());
			int abs = Math.abs(n - num) + i;
			ans = Math.min(ans, abs);
		}

		if (i == result.length) {
			return;
		}

		for (int j = 0; j < 10; j++) {
			if (visit[j]) {
				continue;
			}
			result[i] = j;
			dfs(i + 1);
		}
	}

	static boolean isRange(int num) {
		if (num >= 0 && num < 10) {
			return true;
		} else {
			return false;
		}
	}
}
