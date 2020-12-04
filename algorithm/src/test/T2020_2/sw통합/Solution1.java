package test.T2020_2.sw통합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution1 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int[] arr = new int[n];
		int sum1 = 0;
		int sum2 = 0;
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			if(i == 0) {
				sum1 += arr[i];
			}else {
				sum2 += arr[i];
			}
		}
		
		int idx = 1;
		sum2 -= arr[idx];
		
		while(true) {
			if(sum1 == sum2) {
				System.out.println(idx);
				break;
			}
			sum1+=arr[idx++];
			sum2-=arr[idx];
		}
	}
}
