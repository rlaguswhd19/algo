package Bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1182 {
	static int[] arr;
	static int n, s, result;
	static boolean[] visit;
	static int[] ans;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		s = Integer.parseInt(st.nextToken());
		visit = new boolean[n];
		arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 1; i <= n; i++) {
			ans = new int[i];
			com(i, 0, 0);
		}
		System.out.println(result);
	}
	
	static void com(int size, int target, int cnt) {
		if(cnt == size) {
			int sum = 0;
			for (int i = 0; i < ans.length; i++) {
				sum+= ans[i];
			}
			if(sum == s) {
				result++;
			}
			return;
		}else if(target == n) {
			return;
		}else {
			ans[cnt] = arr[target];
			com(size, target+1, cnt+1);
			com(size, target+1, cnt);
		}
		
	}
}
