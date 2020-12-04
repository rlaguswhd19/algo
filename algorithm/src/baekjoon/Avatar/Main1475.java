package baekjoon.Avatar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1475 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String n = br.readLine();

		int[] arr = new int[10];

		for (int i = 0; i < n.length(); i++) {
			int num = n.charAt(i) - '0';
			arr[num]++;
		}
		
		int ans = 0;
		for (int i = 0; i < arr.length; i++) {
			if(i == 6 || i == 9) {
				continue;
			}
			
			ans = Math.max(arr[i], ans);
		}
		
		int sum = arr[6] + arr[9];
		if(sum % 2 == 0) {
			sum /= 2;
		}else {
			sum /= 2;
			sum++;
		}
		
		ans = Math.max(ans, sum);
		
		System.out.println(ans);
	}
}
