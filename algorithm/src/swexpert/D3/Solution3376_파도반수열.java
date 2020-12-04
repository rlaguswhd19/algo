package swexpert.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution3376_파도반수열 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());
		
		long[] arr = new long[101];
		arr[1] = 1;
		arr[2] = 1;
		arr[3] = 1;
		for (int i = 4; i < arr.length; i++) {
			arr[i] = arr[i-3]+arr[i-2];
		}
		
		for (int tc = 1; tc <= t; tc++) {
			int n = Integer.parseInt(br.readLine());
			
			System.out.println("#"+tc+" "+arr[n]);
		}
	}
}
