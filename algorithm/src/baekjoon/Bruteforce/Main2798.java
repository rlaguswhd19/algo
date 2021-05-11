package baekjoon.Bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2798 {
	static int[] arr;
	static int ans = 0, n, m;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		arr = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		com(0, 0, 0);
		
		System.out.println(ans);
	}

	static void com(int idx, int target, int num) {
		if (idx == 3) {
			if(num > m) {
				return;
			}
			
			ans = Math.max(ans, num);
			
			return;
		} else if (target == arr.length) {
			return;
		} else {
			num += arr[target];
			com(idx + 1, target + 1, num);
			num -= arr[target];
			com(idx, target + 1, num);
		}
	}
}
