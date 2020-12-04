package baekjoon.Bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2231 {
	static int n, ans;
	static char[] arr;
	static String num;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		num = br.readLine();
		n = Integer.parseInt(num);
		ans = Integer.MAX_VALUE;

		for (int i = n-(9*num.length()); i < n; i++) {
			arr = ("" + i).toCharArray();
			int sum = 0;
			for (int j = 0; j < arr.length; j++) {
				sum += arr[j]-'0';
			}
			
			if (sum + i == n) {
				ans = i;
				break;
			}
		}
		if(ans == Integer.MAX_VALUE) {
			System.out.println(0);
		}else {
			System.out.println(ans);
		}
	}
}
